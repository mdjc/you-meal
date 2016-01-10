(function(){
	'use strict';

	angular
		.module('youMealApp')
		.controller('RootController', Controller);
	
	Controller.$inject = ['$location', '$rootScope', 'authenticationService'];
	
	function Controller($location, $rootScope, authenticationService) {
		var vm = this;
		activate();
    	
    	function activate() {
    		if ($rootScope.username) {
    		    $location.path('/suggestions');
                return;
    		}
    		
    		$location.path('/welcome');
    	}		
	}
	
})();
