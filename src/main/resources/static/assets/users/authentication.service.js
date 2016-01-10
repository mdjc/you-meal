(function() {
	angular
		.module("youMealApp")
		.factory("authenticationService", factory);
	
	factory.$inject = ['$http'];
	
	function factory($http) {
		var service =  {
			principal: principal,
			signOut: signOut
		};
		
		return service;
		
		function principal(config) {
			return  $http.get('/principal', config);
		}		

		function signOut() {
			return $http.post('/logout', {});
		}
	}
})();
