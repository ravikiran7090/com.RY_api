package com.TestYantra.DiffWayToPostRequest;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingResourceUsingJsonFileTest {
	@Test
	public void create() {
		
		File file = new File("./src/test/resources/demo.json");
		
		given()
			.body(file)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.assertThat().statusCode(201)
			.log().all();
	}
}
