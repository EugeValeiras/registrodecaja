<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en" ng-app="app">
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/appController.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/appService.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/appDirectives.js"></script>


</head>

<body data-ng-controller="appController as appCtrl">

	<div>
		<label>Cantidad: </label><input type="text" ng-model="appCtrl.selectedCantidad"/>
		<label>Descripcion: </label><input type="text" ng-model="appCtrl.selectedDescripcion"/>
		<select name="tipoMoneda" ng-model="appCtrl.selectedTipoMoneda" data-ng-options="tipoMoneda.value as tipoMoneda.toString for tipoMoneda in appCtrl.tiposDeMonedas" required>
	    	<option value="">Selecciona tipo de Moneda</option>
	 	</select>
		<select name="tipoTransaccion" ng-model="appCtrl.selectedTipoTransaccion" data-ng-options="tipoDeTansaccion.value as tipoDeTansaccion.toString for tipoDeTansaccion in appCtrl.tiposDeTansaccion" required>
	    	<option value="">Selecciona tipo de Transaccion</option>
	 	</select>
		<select name="usuario" ng-model="appCtrl.selectedUsuario" data-ng-options="usuario as usuario for usuario in appCtrl.usuarios" required>
	    	<option value="">Selecciona Usuario</option>
	 	</select>
	 	<button ng-disabled="" ng-click="appCtrl.crearTransaccion()" class="" type="submit">Crear Transaccion!</button>
	</div>

	<div class="">
		<table class="">
			<tbody>
				<tr>
					<th>Fecha</th>
					<th>Tipo de Transaccion</th>
					<th>Cantidad</th>
					<th>Tipo de Moneda</th>
					<th>Descripcion</th>
					<th>Usuario</th>
				</tr>
				<tr data-ng-repeat="transaccion in appCtrl.transacciones" class="">
					<td class="">{{transaccion.fecha}}</td>
					<td class="">{{transaccion.tipoTransaccion}}</td>
					<td class="">{{transaccion.dinero.cantidad}}</td>
					<td class="">{{transaccion.dinero.tipo}}</td>
					<td class="">{{transaccion.descripcion}}</td>
					<td class="">{{transaccion.usuario}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<span ng-bind="appCtrl.totalPesosArgentinos"></span><br>
	<span ng-bind="appCtrl.totalPesosUruguayos"></span><br>
	<span ng-bind="appCtrl.totalDolares"></span><br>
	
	<div class="alert alert-danger animate-repeat" ng-repeat="error in appCtrl.errors">{{error}}</div>

</body>
</html>