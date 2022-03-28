package com.TestYantra.validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponceValidationTest {
	@Test
	public void statiResponceValidations() {
		Response response = when().get("http://localhost:8084/projects");
		response.then().log().all();
		Object projid = response.jsonPath().get("[0].projectId");
		Assert.assertEquals(projid.equals("TY_PROJ_001"), true);

	}
}
