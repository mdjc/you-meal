package com.github.mdjc.youmeal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mdjc.youmeal.domain.Meal;
import com.github.mdjc.youmeal.domain.MealCategory;
import com.github.mdjc.youmeal.domain.User;
import com.github.mdjc.youmeal.domain.UserRepository;

@RestController
public class MealRestController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST, value = "users/{username}/meals")
	@ResponseStatus(HttpStatus.CREATED)
	public Meal add(@PathVariable String username, @RequestBody Meal meal) {
		User user = userRepository.get(username);
		return user.getMealRepository().add(meal);
	}

	@RequestMapping("users/{username}/categories/{category}/meals/suggestion")
	public Meal pickMeal(@PathVariable String username, @PathVariable String category) {
		MealCategory mealCategory = Enum.valueOf(MealCategory.class, category.toUpperCase());
		User user = userRepository.get(username);
		return user.getMealRepository().getRandomMeal(mealCategory);
	}
}
