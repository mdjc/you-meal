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
			
		function add(username, meal) {
			return $http.post('/users/' + username + '/meals/', meal);
		}
		
		function getSuggestedMeal(username, category) {
			return $http.get('/users/' + username + "/categories/" + category + "/meals/suggestion");
		}
	}
})();
