'use strict';

var app = angular.module('loginApp', [ 'ngAnimate', 'ui.bootstrap', 'ngCookies']);

app.controller('loginController', function($scope, $timeout, $interval, $compile, $cookies, $window, loginService) {
	
	var self = this;
	this.username;
	this.password;
	
	this.login = function(){
		loginService.login({"username" : self.username, "password" : self.password}, function(data){
			$cookies.put('username', data.username);
			$window.location.href = '/'+data.username;
		}, function(data){
			$scope.message = 'ERROR';
		})
	}
});