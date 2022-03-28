package com.TestYantra.DiffWayToPostRequest;

import org.testng.annotations.Test;

import com.TestYantra.pojoLib.PojoClass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreatingResourceUsingPojoLibraryTest {
	@Test
	public void create() {
		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project"+num);
		
		PojoClass pojo = new PojoClass("Suraj", proj, "onGoing", "456");

		given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
				.assertThat().contentType(ContentType.JSON)
				.assertThat().statusCode(201)
				
				.log().all();

	}
}
