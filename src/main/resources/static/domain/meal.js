var youMeal;

(function(youMeal) {
	youMeal.Meal = Meal;
	
	function Meal(id, breakfast, lunch, dinner) {
		this.id = id;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
	}
})(youMeal || (youMeal = {}));