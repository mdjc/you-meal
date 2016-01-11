(function(){
	'use strict';

	angular
		.module('youMealApp')
		.controller('AddMealController', Controller);
	
	Controller.$inject = ['$rootScope', 'mealService', '$location'];
	
	function Controller($rootScope, mealService, $location) {
		var vm = this;
		vm.submit = add;		
		activate();	
		
	    function activate() {				
	    	vm.eatenDate = new Date();
	    	vm.meal = new youMeal.Meal(0, false, false, false);
	    }
		    
		function add() {
			mealService.add($rootScope.username, vm.meal).error(errorCallBack).success(successCallback);
		}
		
		function errorCallBack(data, status, headers, config) {
			vm.alert = common.alerts.error("Unexpected error");
		}
		
		function successCallback(data, status, headers, config) {
	    	$location.path("/suggestions");
	    } 
	}
})();
