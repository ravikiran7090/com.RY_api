package com.TestYantra.DiffWayToPostRequest;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingResourceUsingMapTest {
	@Test
	public void create() {
		
		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project"+num);
		
		HashMap map=new HashMap();
		map.put("createdBy", "Suraj");
		map.put("projectName", proj);
		map.put("status", "onGoing");
		map.put("teamSize", 20);
		
		given()
			.body(map)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.assertThat().statusCode(201)
			.log().all();
	}
}
