package com.TestYantra.WithBDDFeatures;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateAResourceTest {
	@Test
	public void CreateResource() {
		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project"+num);
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "me");
		obj.put("projectName", proj);
		obj.put("status", "on going");
		obj.put("teamSize", 25);
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
//		.then()
//			.assertThat().contentType(ContentType.JSON)
//			.assertThat().statusCode(201)
//			.log().all();
	}
}
