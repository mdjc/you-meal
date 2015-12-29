package com.github.mdjc.youmeal.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.github.mdjc.youmeal.domain.Meal;
import com.github.mdjc.youmeal.domain.MealRepository;

public class SqlMealRepository implements MealRepository {
	private final JdbcTemplate jdbcTemplate;

	public SqlMealRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Meal add(Meal meal) {
		PreparedStatementCreator prepStatementCreator = connnection -> {
			PreparedStatement prepStatement = connnection.prepareStatement(
					"insert into meals set meal_description = ?, breakfast = ?, lunch = ?, dinner = ?",
					Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, meal.getDescription());
			prepStatement.setBoolean(2, meal.isBreakfast());
			prepStatement.setBoolean(3, meal.isLunch());
			prepStatement.setBoolean(4, meal.isDinner());
			return prepStatement;
		};

		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(prepStatementCreator, idHolder);
		return new Meal(idHolder.getKey().longValue(), meal.getDescription(), meal.isBreakfast(), meal.isDinner(),
				meal.isLunch());
	}
}