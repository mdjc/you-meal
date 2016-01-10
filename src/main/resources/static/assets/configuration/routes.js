(function(){
	'use strict';
	
	angular
		.module('youMealApp')
		.config(config);
	
	config.$inject = ['$routeProvider'];
	
	function config($routeProvider) {
		$routeProvider
			.when('/', new youMeal.Route('RootController'))
			.when('/welcome', new youMeal.Route('WelcomeController', 'assets/welcome.html'))
			.when('/signin', new youMeal.Route('SignInController', 'assets/users/sign-in.html'))
			.when('/add', new youMeal.Route('AddMealController', 'assets/meals/add-meal.html'))
			.when('/suggestions', new youMeal.Route('MealSuggestionsController', 'assets/meals/meal-suggestions.html'))
			.otherwise({redirectTo: '/'});
	}	
})();