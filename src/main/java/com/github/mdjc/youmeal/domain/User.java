package com.github.mdjc.youmeal.domain;

import static com.github.mdjc.commons.args.Arguments.*;

public class User implements Comparable<User> {
	public static User NULL = new User("", "", "", MealRepository.NULL);

	private final String name;
	private final String email;
	private final String password;
	private final MealRepository mealRepository;

	private User(String name, String email, String password, MealRepository mealRepository) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.mealRepository = mealRepository;
		mealRepository.setUser(this);
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public MealRepository getMealRepository() {
		return mealRepository;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (!(other instanceof User)) {
			return false;
		}

		User that = (User) other;

		return compareTo(that) == 0;

	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public int compareTo(User other) {
		return this.name.compareToIgnoreCase(other.name);
	}

	@Override
	public String toString() {
		return name;
	}

	public static User of(String name, String email, String password, MealRepository mealRepository) {
		name = checkBlank(name);
		email = checkBlank(email);
		password = checkBlank(password);
		return new User(name, email, password, mealRepository);
	}
}
