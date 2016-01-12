(function(){
	'use strict';

	angular
		.module('youMealApp')
		.controller('AddMealController', Controller);
	
	Controller.$inject = ['$rootScope', 'mealService', '$location'];
	
	function Controller($rootScope, mealService, $location) {
		var vm = this;
		vm.submit = add;
		vm.cleanAlert = cleanAlert;
		activate();	
		
	    function activate() {				
	    	vm.eatenDate = new Date();
	    	vm.meal = new youMeal.Meal(0, false, false, false);
	    }
		    
		function add() {
			if (!vm.meal.breakfast && !vm.meal.lunch && !vm.meal.dinner){
				vm.alert = common.alerts.warning("Would you please check your meal's category (breakfast, lunch, dinner)?");
				return;
			}
			
			mealService.add($rootScope.username, vm.meal).error(errorCallBack).success(successCallback);
		}
		
		function cleanAlert(){
			vm.alert = {};
		}
		
		function errorCallBack(data, status, headers, config) {
			vm.alert = common.alerts.error("Unexpected error");
		}
		
		function successCallback(data, status, headers, config) {
	    	$location.path("/suggestions");
	    } 
	}
})();
