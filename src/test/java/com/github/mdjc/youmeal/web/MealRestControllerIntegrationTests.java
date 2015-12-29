package com.github.mdjc.youmeal.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.mdjc.web.test.RestControllerTest;
import com.github.mdjc.youmeal.Application;
import com.github.mdjc.youmeal.domain.Meal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MealRestControllerIntegrationTests extends RestControllerTest {
	@Before
	public void setUp() throws Exception {
		buildWebContext();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddSuccesful() throws Exception {
		String mealAsJson = json(new Meal(0, "non-bones chicken chicharron", false, true, true));
		this.mockMvc.perform(post("/meals")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mealAsJson))
				.andExpect(status().isCreated());
	}
}
