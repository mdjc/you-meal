(function(){
	'use strict';

	angular
		.module('youMealApp')
		.controller('MealSuggestionsController', Controller);
	
	Controller.$inject = ['$rootScope', 'mealService'];
	
	function Controller($rootScope, mealService) {
		var vm = this;
		vm.loadBreakfast = loadBreakfast;
		vm.loadLunch = loadLunch;
		vm.loadDinner = loadDinner;
		doLoad();
		
		function doLoad() {
			vm.meal = {};
		}
		
		function loadBreakfast() {
			loadSuggestedMeal("breakfast");
		}
		
		function loadLunch() {
			loadSuggestedMeal("lunch");
		}
		
		function loadDinner() {
			loadSuggestedMeal("dinner");
		}
		
		function loadSuggestedMeal(category) {
			mealService.getSuggestedMeal($rootScope.username, category).error(errorCallBack).success(successCallBack);
		}
		
		function errorCallBack(data, status, headers, config) {
			vm.alert = common.alerts.error("Unexpected error");
		}
		
		function successCallBack(data, status, headers, config) {
	    	vm.meal = data;
	    } 
	}
})();
