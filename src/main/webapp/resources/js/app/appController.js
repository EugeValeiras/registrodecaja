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
	this.loadingTable = true;
	this.loadingValueArgentinos = true;
	this.loadingValueUruguayos = true;
	this.loadingValueDolares = true;
	
	/*On Load Methods*/
	this.getTransacciones = function() {
		this.loadingTable = false;
		appService.getTransacciones(function(data) {
			self.transacciones = data;
			self.loadingTable = true;
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
		self.loadingValueArgentinos = false;
		self.loadingValueUruguayos = false;
		self.loadingValueDolares = false;

		appService.argentinosEnCaja(function(data){
			self.totalPesosArgentinos = data;
			self.loadingValueArgentinos = true;
		});
		appService.uruguayosEnCaja(function(data){
			self.totalPesosUruguayos = data;
			self.loadingValueUruguayos = true;
		});
		appService.dolaresEnCaja(function(data){
			self.totalDolares = data;
			self.loadingValueDolares = true;
		});
	};
	this.actualizarCaja();
});