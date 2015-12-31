
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html ng-app="snics">
<head>
<link rel="icon" type="image/png"
	href="${pageContext.servletContext.contextPath}/img/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title>SNICS</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- build:css styles/vendor.css -->
<!-- bower:css -->

<script type="text/javascript">
     var CONTEXT_PATH_SERVICES="<spring:eval expression="@propertyConfigurer.getProperty('SNICS.SERVICES.BASE')" />"
     </script>
    
<!-- Bootstrap -->
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet">

<!--Add onss CSS-->


<script
	src="${pageContext.servletContext.contextPath}/js/jquery-2.1.4.min.js"
	charset="charset=ISO-8859-1"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/angular.min.js"
	charset="charset=ISO-8859-1"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/angular-animate.min.js"
	charset="charset=ISO-8859-1"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/semantic.min.js"
	charset="charset=ISO-8859-1"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/loading-bar.min.js"
	charset="charset=ISO-8859-1"></script>
	
<script
	src="${pageContext.servletContext.contextPath}/js/jquery.cookie.js"
	charset="charset=ISO-8859-1"></script>
	
<script
	src="${pageContext.servletContext.contextPath}/js/loginService.js"
	charset="charset=ISO-8859-1"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/loginController.js"
	charset="charset=ISO-8859-1"></script>
	
	
<style type="text/css">
body {
	background-color: #f6f6f6;
}

body>.grid {
	height: 100%;
}

.image {
	margin-top: -100px;
}

.column {
	max-width: 450px;
}
</style>


</head>
<body>


	<div class="container" ng-controller="loginController" >

      <form name="formLogin">
        <h2 class="form-signin-heading">Inicio de sesión</h2>
         <div class="checkbox">
          <label>
          </label>
        </div>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="text" id="usuario" class="form-control" placeholder="Nombre de Usuario" required="" autofocus="" ng-enter="buscar()" ng-model="loginService.getUserData().usuario">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password"   ng-model="loginService.getUserData().contrasenia" required="">
        <div class="checkbox">
          <label>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" ng-click="buscar();"ng-disabled="formLogin.$invalid" >Sign in</button>
      </form>

    </div>


</body>
</html>