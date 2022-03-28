package com.TestYantra.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	public void pathParam() {
		String proId="TY_PROJ_2833";
		given()
			.pathParam("projectId", proId)
			.when()
				.delete("http://localhost:8084/projects/{projectId}")
			.then()
				.assertThat().statusCode(204)
				.log().all();
	}
}
