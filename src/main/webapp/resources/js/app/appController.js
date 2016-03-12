'use strict';

var app = angular.module('app', [ 'ngAnimate', 'ui.bootstrap', 'ngCookies']);

app.controller('appController', function($scope, $timeout, $interval, $compile, $cookies, $window, appService) {
	
	var self = this;
	
	this.transacciones = [];
	this.error = '';
	
	this.tiposDeMonedas = [{value: 'Argentino', toString: 'Peso Argentino' }, {value: 'Uruguayo', toString: 'Peso Uruguayo' }, {value: 'Dolar', toString: 'Dolar' }];
	this.tiposDeTansaccion = [{value: 'INGRESO', toString : 'Ingreso'}, {value: 'EGRESO', toString : 'Egreso'}];
	this.usuarios = ['Rodrigo', 'Eugenio'];
	this.username = $cookies.get('username')
	
	
	this.selectedCantidad = 0;
	this.selectedTipoMoneda;
	this.selectedTipoTransaccion;
	this.selectedUsuario;
	this.selectedDescripcion;
	
	this.totalPesosArgentinos;
	this.totalPesosUruguayos;
	this.totalDolares;
	this.loadingTable = true;
	this.loadingValueArgentinos = true;
	this.loadingValueUruguayos = true;
	this.loadingValueDolares = true;
	
	/*On Load Methods*/
	this.getTransacciones = function() {
		this.loadingTable = false;
		appService.getTransaccionesOf(self.username, function(data) {
			self.transacciones = data;
			self.loadingTable = true;
		});
	};
	this.getTransacciones();
	
	this.getDolarNacion = function(){
		appService.nacionPage(function(data){
			debugger
		})
	}
	this.getDolarNacion();
	
	
	this.crearTransaccion = function(){
		this.transaccion = new transaccionFromUI(self.selectedTipoMoneda, self.selectedTipoTransaccion, self.selectedUsuario, self.selectedCantidad, self.selectedDescripcion, self.username)
		appService.crearTransaccion(this.transaccion, function(data){
			self.getTransacciones();
			self.actualizarCaja();
		});
	};
	
	this.actualizarCaja = function(){
		self.loadingValueArgentinos = false;
		self.loadingValueUruguayos = false;
		self.loadingValueDolares = false;

		appService.argentinosEnCaja(self.username, function(data){
			self.totalPesosArgentinos = data;
			self.loadingValueArgentinos = true;
		});
		
		appService.uruguayosEnCaja(self.username, function(data){
			self.totalPesosUruguayos = data;
			self.loadingValueUruguayos = true;
		});
		
		appService.dolaresEnCaja(self.username, function(data){
			self.totalDolares = data;
			self.loadingValueDolares = true;
		});
	};
	this.actualizarCaja();
});