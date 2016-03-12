'use strict';

var app = angular.module('app');

app.service('appService', function($http) {
	
	var self = this;
	this.urlPedido = 'getCantidad';
	
	this.getTransacciones = function(callback) {
		$http.get('/getAllTransaccion').success(callback);
	};

	this.getTransaccionesOf = function(user, callback) {
		$http.get('/getAllTransaccion/'+user).success(callback);
	};
	
	this.crearTransaccion = function(transaccion, callback) {
		$http.post('/crearTransaccion', transaccion).success(callback);
	};
	
	this.crearTransaccionOf = function(user, transaccion, callback) {
		$http.post('/crearTransaccion/'+user, transaccion).success(callback);
	};
	
	this.borrarTransaccion = function(id, callback) {
		$http.get('/borrarTransaccion/'+id).success(callback);
	};
	
	this.evaluarDolar = function(callback) {
		$http.get('/evaluarDolar').success(callback);
	};
	
	this.argentinosEnCaja = function(username, callback) {
		$http.get('getCantidad/'+username+'/Argentino').success(callback);
	};
	
	this.uruguayosEnCaja = function(username, callback) {
		$http.get('getCantidad/'+username+'/Uruguayo').success(callback);
	};
	
	this.dolaresEnCaja = function(username, callback) {
		$http.get('getCantidad/'+username+'/Dolar').success(callback);
	};
	
	this.nacionPage = function(callback) {
		$http.get('http://lanacion.cloudapi.junar.com/datastreams/invoke/DELIN-EN-LA-ARGEN-TODAS?auth_key=626e1c060ef2ade3270346cf067ba8cf1d89a6a4').success(callback);
	};
	
});