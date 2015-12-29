package com.github.mdjc.youmeal.domain;

public class Meal {
	private final long id;
	private final String description;
	private final boolean breakfast;
	private final boolean lunch;
	private final boolean dinner;

	public Meal(long id, String description, boolean breakfast, boolean lunch, boolean dinner) {
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
}