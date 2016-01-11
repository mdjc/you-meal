package com.github.mdjc.youmeal.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.github.mdjc.youmeal.domain.Meal;
import com.github.mdjc.youmeal.domain.MealCategory;
import com.github.mdjc.youmeal.domain.MealRepository;
import com.github.mdjc.youmeal.domain.User;

public class SqlMealRepository implements MealRepository {
	private final JdbcTemplate jdbcTemplate;
	private User user;

	public SqlMealRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Meal add(Meal meal) {
		PreparedStatementCreator prepStatementCreator = connnection -> {
			PreparedStatement prepStatement = connnection.prepareStatement(
					"insert into meals set user_id = (select user_id from users where user_name = ?),"
							+ " description = ?, is_breakfast = ?, is_lunch = ?, is_dinner = ?",
					Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, user.getName());
			prepStatement.setString(2, meal.getDescription());
			prepStatement.setBoolean(3, meal.isBreakfast());
			prepStatement.setBoolean(4, meal.isLunch());
			prepStatement.setBoolean(5, meal.isDinner());
			return prepStatement;
		};

		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(prepStatementCreator, idHolder);
		return Meal.of(idHolder.getKey().longValue(), meal.getDescription(), meal.isBreakfast(), meal.isDinner(),
				meal.isLunch());
	}

	@Override
	public Meal getRandomMeal(MealCategory mealCategory) {
		try {
			String query = String.format(
					"select * from meals where user_id = (select user_id from users where user_name = ?)"
							+ " and %s = true order by rand() limit 1",
					asField(mealCategory));
			return jdbcTemplate.queryForObject(query, this::mapper, user.getName());
		} catch (EmptyResultDataAccessException e) {
			return Meal.NULL;
		}
	}

	private String asField(MealCategory mealCategory) {
		switch (mealCategory) {
		case BREAKFAST:
			return "is_breakfast";
		case LUNCH:
			return "is_lunch";
		case DINNER:
			return "is_dinner";
		default:
			return null;
		}
	}

	private Meal mapper(ResultSet rs, int rowNum) throws SQLException {
		return Meal.of(rs.getLong("meal_id"),
				rs.getString("description"),
				rs.getBoolean("is_breakfast"),
				rs.getBoolean("is_lunch"),
				rs.getBoolean("is_dinner"));
	}
}