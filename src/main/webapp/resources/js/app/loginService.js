'use strict';

var app = angular.module('loginApp');

app.service('loginService', function($http) {
	
	var self = this;
	
	this.login = function(user, callback, errorCallback) {
		$http.post('/login', user).success(callback).error(errorCallback);
	};
});