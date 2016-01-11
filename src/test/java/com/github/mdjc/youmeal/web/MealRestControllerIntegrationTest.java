package com.github.mdjc.youmeal.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.mdjc.commons.db.DBUtils;
import com.github.mdjc.commons.webapps.test.RestControllerTest;
import com.github.mdjc.youmeal.Application;
import com.github.mdjc.youmeal.domain.Meal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MealRestControllerIntegrationTest extends RestControllerTest {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() throws Exception {
		jdbcTemplate = new JdbcTemplate(dataSource);
		buildWebContext();
		resetDatabase();
	}

	@Test
	public void add_shouldReturnTheAddedMeal() throws Exception {
		Meal meal = Meal.of(0, "bonless chicken chicharron", false, true, true);
		String mealAsJson = json(meal);
		this.mockMvc.perform(post("/users/mirna/meals")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mealAsJson))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.description", is(meal.getDescription())))
				.andExpect(jsonPath("$.breakfast", is(meal.isBreakfast())))
				.andExpect(jsonPath("$.lunch", is(meal.isLunch())))
				.andExpect(jsonPath("$.dinner", is(meal.isDinner())));
	}

	@Test
	public void pickMeal_shouldReturnABreakfast() throws Exception {
		List<Meal> breakfasts = loadMeals().stream().filter(m -> m.isBreakfast()).collect(Collectors.toList());
		this.mockMvc.perform(get("/users/mirna/categories/breakfast/meals/suggestion"))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", isIn(breakfasts.stream().map(m -> (int) m.getId()).toArray())))
				.andExpect(jsonPath("$.description", isIn(breakfasts.stream().map(m -> m.getDescription()).toArray())))
				.andExpect(jsonPath("$.breakfast", is(true)));
	}

	@Test
	public void pickMeal_shouldReturnANullMeal() throws Exception {
		this.mockMvc.perform(get("/users/mirna/categories/lunch/meals/suggestion"))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(0)))
				.andExpect(jsonPath("$.description", is("")))
				.andExpect(jsonPath("$.breakfast", is(false)))
				.andExpect(jsonPath("$.lunch", is(false)))
				.andExpect(jsonPath("$.dinner", is(false)));
	}

	private void resetDatabase() {
		jdbcTemplate.update("delete from meals");
	}

	private List<Meal> loadMeals() {
		List<Meal> meals = new ArrayList<>();
		int mealId = 1;
		meals.add(Meal.of(mealId++, "milk chocolate and toasts", true, false, false));
		meals.add(Meal.of(mealId++, "Fried Chicken", false, true, false));
		meals.add(Meal.of(mealId++, "Sea-food soup", false, true, false));
		meals.add(Meal.of(mealId++, "milk chocolate and toasts", true, false, false));
		meals.add(Meal.of(mealId++, "3 Hits: salami-eggs-cheese and mangu", true, false, false));
		meals.forEach(m -> DBUtils.insert(jdbcTemplate, "meals", asArray("mirna", m)));
		return meals;
	}

	private Object[] asArray(String username, Meal meal) {
		int mealFieldCount = 6;
		Object[] array = new Object[mealFieldCount];
		array[0] = meal.getId();
		array[1] = userId(username);
		array[2] = meal.getDescription();
		array[3] = meal.isBreakfast();
		array[4] = meal.isLunch();
		array[5] = meal.isDinner();
		return array;
	}

	private long userId(String username) {
		return jdbcTemplate.queryForObject("select user_id from users where user_name = ? ", Long.class, username);
	}
}