package com.github.mdjc.youmeal.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.github.mdjc.youmeal.domain.User;
import com.github.mdjc.youmeal.domain.UserRepository;

public class SqlUserRepository implements UserRepository {
	private final JdbcTemplate jdbcTemplate;

	public SqlUserRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User get(String name) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM users where user_name = ?", this::mapper, name);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchElementException(String.format("User %s does not exists", name));
		}
	}

	private User mapper(ResultSet rs, int rowNum) throws SQLException {
		return User.of(rs.getString("user_name"), rs.getString("user_email"), rs.getString("user_password"));
	}
}
