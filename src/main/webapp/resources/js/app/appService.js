'use strict';

var app = angular.module('app');

app.service('appService', function($http) {
	
	var self = this;
	this.urlPedido = 'getCantidad';
	
	this.getTransacciones = function(callback) {
		$http.get('/getAllTransaccion').success(callback);
	};

	this.crearTransaccion = function(transaccion, callback) {
		$http.post('/crearTransaccion', transaccion).success(callback);
	};
	
	this.borrarTransaccion = function(id, callback) {
		$http.get('/borrarTransaccion/'+id).success(callback);
	};
	
	this.evaluarDolar = function(callback) {
		$http.get('/evaluarDolar').success(callback);
	};
	
	this.argentinosEnCaja = function(callback) {
		$http.get(self.urlPedido+'/Argentino').success(callback);
	};
	
	this.uruguayosEnCaja = function(callback) {
		$http.get(self.urlPedido+'/Uruguayo').success(callback);
	};
	
	this.dolaresEnCaja = function(callback) {
		$http.get(self.urlPedido+'/Dolar').success(callback);
	};
});