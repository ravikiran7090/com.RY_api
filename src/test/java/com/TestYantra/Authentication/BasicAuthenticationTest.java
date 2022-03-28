package com.TestYantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthenticationTest {
	@Test
	public void basicAuth() {
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/projects")
		.then()
		.statusCode(200)
		.log().body();
	}
}
