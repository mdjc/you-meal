package com.github.mdjc.youmeal.domain;

public interface MealRepository {
	MealRepository NULL = new MealRepository() {
		@Override
		public Meal getRandomMeal(MealCategory mealCategory) {
			return Meal.NULL;
		}

		@Override
		public Meal add(Meal meal) {
			return Meal.NULL;
		}

		@Override
		public void setUser(User user) {
		}
	};

	Meal add(Meal meal);

	Meal getRandomMeal(MealCategory mealCategory);

	void setUser(User user);
}