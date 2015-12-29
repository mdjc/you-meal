(function(){
	'use strict';

	angular
		.module('youMealApp')
		.controller('AddMealController', Controller);
	
	Controller.$inject = ['$filter','meal'];
	
	function Controller($filter, meal) {
		var vm = this;
		vm.submit = add;
		
		activate();	
		
	    function activate() {				
	    	vm.eatenDate = new Date();
	    	vm.meal = new youMeal.Meal(0, false, false, false);
	    }
		    
		function add() {
			console.log(vm.meal);
			meal.add(vm.meal).error(errorCallBack).success(successCallback);
		}
		
		function errorCallBack(data, status, headers, config) {
			vm.alert = new common.alerts.ErrorBuilder().build(status, "Unexpected error");
		}
		
		function successCallback(data, status, headers, config) {
	    	vm.alert = common.alerts.info("Your meal has been created!");
	    } 
	}
})();
