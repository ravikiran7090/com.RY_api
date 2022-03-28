package com.TestYantra.validations;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class UsingMatchersValidations {
	@Test
	public void usingMatchers() {
		when().get("http://localhost:8084/projects")
		.then().log().body()
		.assertThat().time(Matchers.lessThan(1000L),TimeUnit.MILLISECONDS)
		.assertThat().body("[0].createdBy",Matchers.equalTo("suraj"))
		.assertThat().contentType(Matchers.equalTo("application/json"));
	}

}
