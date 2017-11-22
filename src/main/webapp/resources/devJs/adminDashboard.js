var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

$(document).ready(function() {
	var table = '';
    timerAjaxFun = function (){
		console.log("call");
		table = $('#docDetailsTableAd').DataTable({
	        "sAjaxSource": "/a/dashboardGridData",
	        "sAjaxDataProp": "",
	        "sServerMethod": "POST",
	        destroy: true,
	        "order": [
	            [0, "asc"]
	        ],
	        "aoColumns": [{
	            "mData": "id",
	            "visible": false
	        }, {
	            "mData": "title"
	        }, {
	            "mData": "shortDescription"
	        }, {
	            "mData": "docname"
	        }, {
	            "mData": "state"
	        }, {
	            "mData": "createdById",
	            "visible": false
	        }, {
	            "mData": "createdByName"
	        }, {
	            "mData": "createdDate"
	        },{
	            "mData": "approveById",
	            "visible": false
	        }, {
	            "mData": "approveByName"
	        }, {
	            "mData": "approvedDate"
	        },{
	            "mData": null,
	            "render": function(data,type,row,meta) { // render event defines the markup of the cell text 
	                var a = '<a href=\'javascript:void(0)\'; onclick=\'approveDoc('+row.id+');\'>Approve</a>'; // row object contains the row data
	                return a;
	            }
	        },{
	            "mData": null,
	            "render": function(data,type,row,meta) { // render event defines the markup of the cell text 
	                var a = '<a href=\'javascript:void(0)\'; onclick=\'rejectedDoc('+row.id+');\'>Rejected</a>'; // row object contains the row data
	                return a;
	            }
	        }/*,{
	            "mData": null,
	            "render": function(data,type,row,meta) { // render event defines the markup of the cell text 
	                var a = '<a href=\'javascript:void(0)\'; onclick=\'docDownlaod('+row.id+');\'>Download</a>'; // row object contains the row data
	                return a;
	            }
	        }*/]
	    })
	    $('#docDetailsTableAd').DataTable().ajax.reload();
	}
    timerAjaxFun();
	var mytimeout = setInterval(function(){timerAjaxFun()}, 8000);
	
    $('#docDetailsTableAd tbody').on('click', 'tr', function() {
        console.log(table.row(this).data());
    });

    approveDoc = function(id){
    	clearTimeout(mytimeout);
    	$.ajax({
	        type: "POST",
	        timeout: 30000,
	        url: "/a/approveDoc?id=" + id ,
	        success: function(dataSet) {
	        	timerAjaxFun();
	        	mytimeout = setInterval(function(){timerAjaxFun()}, 8000);
	        },error: function(dataSet){
	        	timerAjaxFun();
	        	mytimeout = setInterval(function(){timerAjaxFun()}, 8000);
	        }
	    });
    }
    
    rejectedDoc = function(id){
    	clearTimeout(mytimeout);
    	$.ajax({
	        type: "POST",
	        timeout: 30000,
	        url: "/a/rejectedDoc?id=" + id ,
	        success: function(dataSet) {
	        	timerAjaxFun();
	        	mytimeout = setInterval(function(){timerAjaxFun()}, 8000);
	        }
	    });
    }
    
    docDownlaod = function(id){
    	clearTimeout(mytimeout);
    	$.ajax({
	        type: "POST",
	        timeout: 30000,
	        url: "/a/docDownlaod?id=" + id ,
	        success: function(dataSet) {
	        	timerAjaxFun();
	        	mytimeout = setInterval(function(){timerAjaxFun()}, 8000);
	        },error: function(dataSet){
	        	timerAjaxFun();
	        	mytimeout = setInterval(function(){timerAjaxFun()}, 8000);
	        }
	    });
    }
});