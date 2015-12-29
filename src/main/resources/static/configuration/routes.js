(function(){
	'use strict';
	
	angular
		.module('youMealApp')
		.config(config);
	
	config.$inject = ['$routeProvider'];
	
	function config($routeProvider) {
		$routeProvider
			.when('/add', route('AddMealController', 'add-meal.html'));
	}	
		
	function route(controller, template) {
    	return {
    		controller: controller,
    		controllerAs: 'vm',
    		templateUrl: template
    	};
    }
})();