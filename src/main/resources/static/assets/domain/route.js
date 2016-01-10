var youMeal;

(function(youMeal) {
	youMeal.Route = Route;
	
	function Route(controller, templateUrl) {
		this.controller = controller;
		this.controllerAs = 'vm';
		
		if (templateUrl) {
			this.templateUrl = templateUrl;			
		} else {
			this.template = '';
		}		
	}
})(youMeal || (youMeal = {}));