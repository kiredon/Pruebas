<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html ng-app="snics">
<head>

<link rel="icon" type="image/png"
	href="${pageContext.servletContext.contextPath}/img/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title><decorator:title default="SNICS" /></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SNICS</title>

<!-- build:css styles/vendor.css -->
<!-- bower:css 
<script>
     var CONTEXT_PATH_SERVICES="http://192.168.1.134:8081/mus-services";
    </script>
-->
<script>
	var CONTEXT_PATH_SERVICES = "${sessionScope.urlBaseServices}";
	var CONTEXT_PATH_WEB = "${pageContext.servletContext.contextPath}";
 	var SNOWFLAKE = "${sessionScope.snowflake}";
	var IDUSUARIO = "${sessionScope.usuario.objetoAutorizacion.idUsuario}";
	var ID_UNIDAD_USUARIO= "${sessionScope.usuario.objetoAutorizacion.idUnidadJerarquica}"; 
</script>

<!-- Bootstrap -->
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet">



	
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
<script src="${pageContext.servletContext.contextPath}/js/modal.min.js"
	charset="charset=ISO-8859-1"></script>
<script src="${pageContext.servletContext.contextPath}/js/master.js"
	charset="charset=ISO-8859-1"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/accordion.min.js"
	charset="charset=ISO-8859-1"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/jquery.datetimepicker.js"
	charset="charset=ISO-8859-1"></script>
<script src="${pageContext.servletContext.contextPath}/js/jquery.scannerdetection.js"
	charset="charset=ISO-8859-1"></script>
<script src="${pageContext.servletContext.contextPath}/js/dropdown.min.js"
	charset="charset=ISO-8859-1"></script>
	
<decorator:head />
</head>
<body>
	
	<header>
	<div class="container">
    	<div class="row">
    		<div class="col-md-2">
      			<h1><img src="${pageContext.servletContext.contextPath}/images/logo-SAGARPA.png" class="img-responsive" alt=""/></h1>
    		</div>
            <div class="col-md-3">
            <img src="${pageContext.servletContext.contextPath}/images/logo-SNICS.png" class="img-responsive" alt=""/>
    		</div>
  		</div>
    </div>
</header>
	
	
	
	<nav class="navbar navbar-default">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#defaultNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
      <a class="navbar-brand" href="#">SNICS</a></div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="defaultNavbar1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Bandeja de entrada</a></li>
        
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Administración<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Unidades de SNICS</a></li>
            <li><a href="#">Roles</a></li>
            <li><a href="#">Identidad</a></li>
          </ul>
        </li>
        
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Gestión de Contenido<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Mensajes</a></li>
            <li><a href="#">Catálogos</a></li>
            <li><a href="#">Cultivos</a></li>
          </ul>
        </li>
        
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Directorio<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Gestión de Organismos</a></li>
          </ul>
        </li>
        
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Calificación<span class="caret"></span></a>
        	<ul class="dropdown-menu" role="menu">
            	<li><a href="#">R-1 Inspección</a></li>
                <li><a href="#">R-3 Remisión</a></li>
                <li><a href="#">R-4 Movilización</a></li>
                <li><a href="#">R-5 Identificación</a></li>
                <li><a href="#">R-7 Supervisión</a></li>
                <li><a href="#">Laboratorio</a></li>
         	</ul>
        </li>
        
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Tareas Pendientes<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">R-3 Remisión</a></li>
            <li><a href="#">R-4 Movilización</a></li>
          </ul>
        </li>
        
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Etiquetas<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Asignar Etiquetas</a></li>
            <li><a href="#">Etiquetas por SNICS</a></li>
            <li><a href="#">Confirmar Etiquetas</a></li>
            <li><a href="#">Cancelar Etiquetas</a></li>
            <li><a href="#">Stock Etiquetas</a></li>
          </ul>
        </li>
        
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Hola, Usuario<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Cerrar Sesión</a></li>
          </ul>
        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>




















	
	
	
	
<div class="container">
  
  <hr>
  <div class="row">
    <div class="text-center col-md-6 col-md-offset-3">
      <p> &copy; 2015 &middot; Derechos Reservados &middot; <a href="#" >SNICS</a></p>
    </div>
  </div>
</div>	
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>