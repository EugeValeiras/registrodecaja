<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en" ng-app="loginApp">
<head>
<meta charset="utf-8">
<title>Registro de Caja</title>
<head>
  
<!-- JQUERY -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/node_modules/jquery/dist/jquery.min.js"></script>

<!-- Angular Dependents -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/node_modules/angular/angular.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/node_modules/angular-animate/angular-animate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/node_modules/angular-cookies/angular-cookies.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/node_modules/angular-ui-bootstrap/ui-bootstrap-tpls.js"></script>

<!-- My CSS --> 

<!-- My Angular App  -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/entity/dinero.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/entity/transaccion.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/loginController.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/loginService.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/loginDirectives.js"></script>


</head>

<body data-ng-controller="loginController as loginController">
	<div>
		<form  ng-submit="loginController.login()" class="form-signin" name="sendTest">
		<h2 class="form-signin-heading">Sign in</h2>
		 	<label for="username" class="sr-only">Username: </label>
			<input ng-required="true" ng-model="loginController.username" class="form-control" placeholder="Username"/><br/> 
		 	<label for="username" class="sr-only">Password: </label>
			<input ng-required="true" ng-model="loginController.password" type="password" class="form-control" placeholder="Password"/><br/> 
			<button id="w" type="submit" class="ladda-button" data-color="blue" data-style="zoom-in" ng-disabled="disabled">
     	 		<span class="ladda-label">Log in</span>
    		</button>
    		<img alt="loading" src="${pageContext.request.contextPath}/resources/gif/loader.gif" ng-if="disabled"><br/>
			<span style="color : red;">{{loginController.loginNotification}}</span>
		</form>
	</div>
</body>
</html>