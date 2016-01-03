package com.github.mdjc.youmeal.domain;

import static com.github.mdjc.common.args.Arguments.*;

public class Meal {
	public static final Meal NULL = new Meal(0, "", false, false, false);

	private final long id;
	private final String description;
	private final boolean breakfast;
	private final boolean lunch;
	private final boolean dinner;

	private Meal(long id, String description, boolean breakfast, boolean lunch, boolean dinner) {
		this.id = id;
		this.description = description;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public boolean isLunch() {
		return lunch;
	}

	public boolean isDinner() {
		return dinner;
	}

	public static Meal of(long id, String description, boolean breakfast, boolean lunch, boolean dinner) {
		check(breakfast || lunch || dinner);
		return new Meal(checkPositive(id), checkBlank(description), breakfast, lunch, dinner);
	}
}