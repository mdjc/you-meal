package com.github.mdjc.youmeal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.mdjc.commons.webapps.spring.security.UsernamePasswordAuthenticationProvider;
import com.github.mdjc.youmeal.domain.Meal;
import com.github.mdjc.youmeal.domain.UserRepository;
import com.github.mdjc.youmeal.impl.SqlUserRepository;
import com.github.mdjc.youmeal.json.MealDeserializer;

@SpringBootApplication
public class Application {
	@Autowired
	DataSource dataSource;

	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new UsernamePasswordAuthenticationProvider(u -> userRepository().get(u).getPassword());
	}

	@Bean
	public UserRepository userRepository() {
		return new SqlUserRepository(dataSource);
	}

	@Bean
	public Module module() {
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Meal.class, new MealDeserializer());
		return module;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}