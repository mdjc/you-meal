(function(){
	'use strict';

	angular
		.module('youMealApp')
		.controller('SignInController', Controller);
	
	Controller.$inject = ['$rootScope', '$location', 'authenticationService'];
	
	function Controller($rootScope, $location, authenticationService) {
		var vm = this;
		vm.username = '';
        vm.password = '';
        vm.signIn = signIn;
        
        function signIn() {
        	if ($rootScope.username) {
        		$location.path('/suggestions');
        		return;
        	}
        	
            var authorization = 'Basic ' + btoa(vm.username + ':' + vm.password);
            var config = {
            	headers: {
                    'Authorization': authorization
                }
            };
            authenticationService.principal(config).error(errorCallback).success(successCallback);
        }
        
        function errorCallback(data, status, headers, config) {
        	vm.alert = new common.alerts.ErrorSelector()
    						.when(401, "Incorrect username or password")
    						.select(status);
        }
        
        function successCallback(data, status, headers, config) {
        	 $rootScope.username = data.principal;
             $location.path('/suggestions');
        }
    }
		
})();
