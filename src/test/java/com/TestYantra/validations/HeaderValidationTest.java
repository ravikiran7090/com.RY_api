package com.TestYantra.validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderValidationTest {
	@Test
	public void headerValidation() {
		String expectedvalue = "Access-Control-Request-Headers";
		Response response = when().get("http://localhost:8084/projects");
		String actualvalue = response.header("vary");
		System.out.println(actualvalue);

		//Assert.assertEquals(actualvalue, expectedvalue);
		response.then().assertThat().header("vary", expectedvalue);

	}

}


