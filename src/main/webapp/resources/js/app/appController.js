'use strict';

var app = angular.module('app', [ 'ngAnimate']);

app.controller('appController', function($scope, $timeout, $interval, $compile, appService) {
	
	var self = this;
	
	this.transacciones = [];
	this.error = '';
	
	this.tiposDeMonedas = [{value: 'Argentino', toString: 'Peso Argentino' }, {value: 'Uruguayo', toString: 'Peso Uruguayo' }, {value: 'Dolar', toString: 'Dolar' }];
	this.tiposDeTansaccion = [{value: 'INGRESO', toString : 'Ingreso'}, {value: 'EGRESO', toString : 'Egreso'}];
	this.usuarios = ['Rodrigo', 'Eugenio'];
	
	this.selectedCantidad = 0;
	this.selectedTipoMoneda;
	this.selectedTipoTransaccion;
	this.selectedUsuario;
	this.selectedDescripcion;
	
	this.totalPesosArgentinos;
	this.totalPesosUruguayos;
	this.totalDolares;
	
	/*On Load Methods*/
	this.getTransacciones = function() {
		appService.getTransacciones(function(data) {
			self.transacciones = data;
		});
	};
	this.getTransacciones();
	
	this.crearTransaccion = function(){
		this.transaccion = new transaccionFromUI(self.selectedTipoMoneda, self.selectedTipoTransaccion, self.selectedUsuario, self.selectedCantidad, self.selectedDescripcion)
		appService.crearTransaccion(this.transaccion, function(data){
			self.getTransacciones();
			self.actualizarCaja();
		});
	};
	
	this.actualizarCaja = function(){
		appService.argentinosEnCaja(function(data){
			self.totalPesosArgentinos = data;
		});
		appService.uruguayosEnCaja(function(data){
			self.totalPesosUruguayos = data;
		});
		appService.dolaresEnCaja(function(data){
			self.totalDolares = data;
		});
	};
	this.actualizarCaja();
});