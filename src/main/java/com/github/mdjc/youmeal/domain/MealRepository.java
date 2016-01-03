package com.github.mdjc.youmeal.domain;

public interface MealRepository {
	Meal add(Meal meal);

	Meal getRandomMeal(MealCategory mealCategory);
}