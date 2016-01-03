(function() {
	angular
		.module("youMealApp")
		.factory("mealService", factory);
	
	factory.$inject = ['$http'];	
	
	function factory($http) {
		var service =  {
			add: add,
			getSuggestedMeal: getSuggestedMeal
		};
		
		return service;
			
		function add(meal) {
			return $http.post('/meals/', meal);
		}
		
		function getSuggestedMeal(category) {
			return $http.get("/categories/" + category + "/meals/suggestion");
		}
	}
})();
