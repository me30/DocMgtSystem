var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

$(document).ready(function() {

    var table = $('#docDetailsTable').DataTable({
        "sAjaxSource": "/d/dashboardGridData",
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
        }/*,{
            "mData": null,
            "render": function(data,type,row,meta) { // render event defines the markup of the cell text 
                var a = '<a href=\'javascript:void(0)\'; onclick=\'docDownlaod('+row.id+');\'>Download</a>'; // row object contains the row data
                return a;
            }
        }*/]   	
    })

    $('#docDetailsTable tbody').on('click', 'tr', function() {
        console.log(table.row(this).data());
    });
});