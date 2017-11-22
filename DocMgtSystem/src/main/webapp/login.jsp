<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%-- <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="utf-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1">
       <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
       <meta name="description" content="">
       <meta name="author" content="">
   
       <title>Log in with your account</title>
   
       <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
       <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
   
       <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
       <!--[if lt IE 9]>
       <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
       <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
       <![endif]-->
   </head>
   
   <body>
   
   <div class="container">
   
       <form method="POST" action="${contextPath}/login" class="form-signin">
           <h2 class="form-heading">Log in</h2>
   
           <div class="form-group ${error != null ? 'has-error' : ''}">
               <span>${message}</span>
               <input name="username" type="text" class="form-control" placeholder="Username"
                      autofocus="true"/>
               <input name="password" type="password" class="form-control" placeholder="Password"/>
               <span>${error}</span>
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   
               <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
               <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
           </div>
   
       </form>
   
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
      <title>Login</title>
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
      <!-- iCheck -->
      <link rel="stylesheet" href="${contextPath}/resources/plugins/iCheck/square/blue.css">
      <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
   <body class="hold-transition login-page">
      <div class="login-box">
         <div class="login-logo">
            <a href="javascript:void(0);"><b>Document Mgt System</b></a>
         </div>
         <!-- /.login-logo -->
         <div class="login-box-body">
            <form action="${contextPath}/login" method="post">
               <div class="form-group ${error != null ? 'has-error' : ''}">
                  <div class="form-group has-feedback">
                     <span>${message}</span>
                     <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
                  </div>
                  <div class="form-group has-feedback">
                     <input name="password" type="password" class="form-control" placeholder="Password"/>
                     <span>${error}</span>
                     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  </div>
                  <div class="row">
                     <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                  </div>
               </div>
            </form>
            <a href="${contextPath}/registration" class="text-center">Register a new membership</a>
         </div>
         <!-- /.login-box-body -->
      </div>
      <!-- /.login-box -->
      <!-- jQuery 2.2.3 -->
      <script src="${contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
      <!-- Bootstrap 3.3.6 -->
      <script src=".${contextPath}/resources/js/bootstrap.min.js"></script>
      <!-- iCheck -->
      <script src="${contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
      <script>
         $(function () {
           $('input').iCheck({
             checkboxClass: 'icheckbox_square-blue',
             radioClass: 'iradio_square-blue',
             increaseArea: '20%' // optional
           });
         });
      </script>
   </body>
</html>