(function() {
	'use strict';
	angular
		.module('youMealApp', ['ngRoute'])
		.run(run);

	run.$inject = ['$rootScope', 'authenticationService']; 
	
	function run($rootScope, authenticationService) {
		authenticationService.principal().success(successCallback);
		
	    function successCallback(data, status, headers, config) {
	    	if (data && data.principal) {        		
	    		$rootScope.username = data.principal;
	    	}
	    }
	}	
})();