package com.github.mdjc.youmeal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mdjc.youmeal.domain.Meal;
import com.github.mdjc.youmeal.domain.MealRepository;

@RestController
public class MealRestController {
	@Autowired
	MealRepository repository;

	@RequestMapping(method = RequestMethod.POST, value = "/meals")
	@ResponseStatus(HttpStatus.CREATED)
	public Meal add(@RequestBody Meal meal) {
		return repository.add(meal);
	}
}
