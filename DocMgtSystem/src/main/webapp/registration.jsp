<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Registration Page</title>
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
   <body class="hold-transition register-page">
      <div class="register-box">
         <div class="register-box-body">
            <p class="login-box-msg">Register a new membership</p>
            <form:form method="POST" modelAttribute="userForm" class="form-signin">
               <spring:bind path="username">
                  <div class="form-group ${status.error ? 'has-error' : ''}">
                     <form:input type="text" path="username" class="form-control" placeholder="Username"
                        autofocus="true"></form:input>
                     <form:errors path="username"></form:errors>
                  </div>
               </spring:bind>
               
               <spring:bind path="email">
                  <div class="form-group ${status.error ? 'has-error' : ''}">
                     <form:input type="text" path="email" class="form-control" placeholder="Email"></form:input>
                     <form:errors path="email"></form:errors>
                  </div>
               </spring:bind>
               
               <spring:bind path="password">
                  <div class="form-group ${status.error ? 'has-error' : ''}">
                     <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                     <form:errors path="password"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="passwordConfirm">
                  <div class="form-group ${status.error ? 'has-error' : ''}">
                     <form:input type="password" path="passwordConfirm" class="form-control"
                        placeholder="Confirm your password"></form:input>
                     <form:errors path="passwordConfirm"></form:errors>
                  </div>
               </spring:bind>
               <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            </form:form>
            <a href="${contextPath}/login" class="text-center">I already have a membership</a>
         </div>
         <!-- /.form-box -->
      </div>
      <!-- /.register-box -->
      <!-- jQuery 2.2.3 -->
      <script src="${contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
      <!-- Bootstrap 3.3.6 -->
      <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
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