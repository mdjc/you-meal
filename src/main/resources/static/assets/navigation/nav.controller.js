(function(){
	'use strict';
	angular
		.module('youMealApp')
		.controller('NavigationController', Controller);
	
	Controller.$inject = ['$rootScope', '$location', 'authenticationService'];
	
	function Controller($rootScope, $location, authenticationService) {
		var vm = this;
		vm.signOut = signOut;
		
		function signOut() {
			authenticationService.signOut().success(successCallback); 
		}
	
		function successCallback(data, status, headers, config){
			$rootScope.username = '';
			$location.path('/home');
		}	
	}
})();
