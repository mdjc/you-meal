(function() {
	angular
		.module("youMealApp")
		.factory("meal", factory);
	
	factory.$inject = ['$http'];	
	
	function factory($http) {
		var service =  {
			add: add
		};
		
		return service;
			
		function add(meal) {
			return $http.post('/meals/', meal);
		}
	}
})();
