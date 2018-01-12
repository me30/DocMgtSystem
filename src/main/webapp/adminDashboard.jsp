<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%-- 
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="utf-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1">
       <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
       <meta name="description" content="">
       <meta name="author" content="">
   
       <title>Create an account</title>
   
       <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
   
       <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
       <!--[if lt IE 9]>
       <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
       <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
       <![endif]-->
   </head>
   <body>
   <div class="container">
   
       <c:if test="${pageContext.request.userPrincipal.name != null}">
           <form id="logoutForm" method="POST" action="${contextPath}/logout">
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
           </form>
   		<h2>Admin role</h2>
           <h3>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h3>
   
       </c:if>
   
   </div>
   <!-- /container -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
   <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
   </body>
   </html> --%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="_csrf" content="${_csrf.token}"/>
      <meta name="_csrf_header" content="${_csrf.headerName}"/>
      <title>AdminLTE 2 | Blank Page</title>
      <!-- Tell the browser to be responsive to screen width -->
      <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
      <!-- Bootstrap 3.3.6 -->
      <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
      <!-- Font Awesome -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
      <!-- Ionicons -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
      <!-- Theme style -->
      <link rel="stylesheet" href="${contextPath}/resources/dist/css/AdminLTE.min.css">
      <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
      <link rel="stylesheet" href="${contextPath}/resources/dist/css/skins/_all-skins.min.css">
      <link rel="stylesheet" href="${contextPath}/resources/dist/css/styles.css">
      <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
      <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
   </head>
   <body class="hold-transition skin-blue sidebar-mini">
      <!-- Site wrapper -->
      <div class="wrapper">
         <jsp:include page="header.jsp" />
         <!-- =============================================== -->
         <!-- Left side column. contains the sidebar -->
         <aside class="main-sidebar">
            <jsp:include page="menu.jsp" />
         </aside>
         <!-- =============================================== -->
         <!-- Content Wrapper. Contains page content -->
         <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
            </section>
            <!-- Main content -->
            <section class="content">
               <div class="row">
                  <div class="col-xs-12">
                     <div class="box">
                        <div class="box-header">
                           <h3 class="box-title">Document Details</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                           <table id="docDetailsTableAd" class="table table-bordered table-striped">
                              <!-- Header Table -->
                              <thead>
                                 <tr>
                                    <th style="display:none;">Id</th>
                                    <th>Title</th>
                                    <th>Short Description</th>
                                    <th>Document Name</th>
                                    <th>State</th>
                                    <th style="display:none;">Created By Id</th>
                                    <th>Created By Name</th>
                                    <th>Created Date</th>
                                    <th style="display:none;">Approve By Id</th>
                                    <th>Approve By Name</th>
                                    <th>Approve Date</th>
                                    <th>Approve</th>
                                    <th>Rejected</th>
                                    <!-- <th>Dowload</th> -->
                                 </tr>
                              </thead>
                              <!-- Footer Table -->
                              <!--  <tfoot>
                                 <tr>
                                    <th style="display:none;">Id</th>
                                 <th>Title</th>
                                     <th>Short Description</th>
                                     <th>Document Name</th>
                                     <th>State</th>
                                     <th>Approve By Id</th>
                                     <th>Approve By Name</th>
                                     <th>Approve Date</th>
                                     <th>Created By Id</th>
                                     <th>Created By Name</th>
                                     <th>Created Date</th>
                                 </tr>
                                 </tfoot> -->
                           </table>
                        </div>
                     </div>
                  </div>
               </div>
            </section>
            <!-- /.content -->
         </div>
         <!-- /.content-wrapper -->
         <footer class="main-footer">
            <jsp:include page="footer.jsp" />
         </footer>
      </div>
      <!-- ./wrapper -->
      <!-- jQuery 2.2.3 -->
      <script src="${contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
      <!-- Bootstrap 3.3.6 -->
      <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
      <!-- SlimScroll -->
      <script src="${contextPath}/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
      <!-- FastClick -->
      <script src="${contextPath}/resources/plugins/fastclick/fastclick.js"></script>
      <!-- AdminLTE App -->
      <script src="${contextPath}/resources/dist/js/app.min.js"></script>
      <!-- AdminLTE for demo purposes -->
      <script src="${contextPath}/resources/dist/js/demo.js"></script>
      <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
      <script type="text/javascript" src="${contextPath}/resources/devJs/adminDashboard.js"></script>
   </body>
</html>