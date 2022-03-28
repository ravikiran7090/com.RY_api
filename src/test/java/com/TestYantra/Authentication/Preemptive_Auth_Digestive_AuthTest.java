package com.TestYantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Preemptive_Auth_Digestive_AuthTest {
	@Test
	public void preemptiveAuth() {
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("http://localhost:8084/projects")
		.then().statusCode(200).log().body();
	}
	
	@Test
	public void digestiveAuth() {
		given()
		.auth()
		.digest("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/projects")
		.then()
		.statusCode(200)
		.log().body();
	}

}
