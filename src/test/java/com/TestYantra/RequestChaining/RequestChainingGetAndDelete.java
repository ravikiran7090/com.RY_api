package com.TestYantra.RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingGetAndDelete {
	@Test(invocationCount = 5)
	public void chaining() {
		
		Response response = when().get("http://localhost:8084/projects");
		Object projId = response.jsonPath().get("[3].projectId");
		
		given()
		.pathParam("projectID", projId)
		.when().delete("http://localhost:8084/projects/{projectID}")
		.then()
		.assertThat().statusCode(204)
		.log().body();
	}

}
