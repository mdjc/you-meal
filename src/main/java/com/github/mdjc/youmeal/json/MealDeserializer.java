package com.github.mdjc.youmeal.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.mdjc.commons.json.SimpleDeserializer;
import com.github.mdjc.youmeal.domain.Meal;

public class MealDeserializer extends SimpleDeserializer<Meal> {

	@Override
	protected Meal deserialize(JsonNode tree) throws Exception {
		int id = tree.get("id").asInt();
		String description = tree.get("description").asText();
		boolean breakfast = tree.get("breakfast").asBoolean();
		boolean lunch = tree.get("lunch").asBoolean();
		boolean dinner = tree.get("dinner").asBoolean();
		return Meal.of(id, description, breakfast, lunch, dinner);
	}
}
