<header class="main-header">
   <!-- Logo -->
   <a href="javascript:void(0);" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>DMS</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Doc Mgt Sys</b></span>
   </a>
   <!-- Header Navbar: style can be found in header.less -->
   <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      </a>
      <div class="navbar-custom-menu">
         <ul class="nav navbar-nav">
            <!-- User Account: style can be found in dropdown.less -->
            <li class="user-name"><i class="fa fa-fw fa-user"></i> ${pageContext.request.userPrincipal.name}</li>
            <li class="user user-menu">
               <form id="logoutForm" method="POST" action="${contextPath}/logout">
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
               </form>
               
               <a onclick="document.forms['logoutForm'].submit()" href="javascript:void(0);" class="dropdown-toggle"><i class="fa fa-fw fa-sign-out"></i> Sign out</a>
            </li>
            <!-- Control Sidebar Toggle Button -->
            <!-- <li>
               <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
               </li> -->
         </ul>
      </div>
   </nav>
</header>