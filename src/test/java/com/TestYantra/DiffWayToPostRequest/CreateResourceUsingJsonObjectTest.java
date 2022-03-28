package com.TestYantra.DiffWayToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

public class CreateResourceUsingJsonObjectTest {
	
	@Test
	public void postResource() {
		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project"+num);
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Suraj");
		obj.put("projectName", proj);
		obj.put("status", "onGoing");
		obj.put("teamSize", 20);

//		
//		RequestSpecification reqspec = RestAssured.given();
//		reqspec.contentType(ContentType.JSON);
//		reqspec.body(obj);
//
//		Response response = reqspec.post("http://localhost:8084/addProject");
//
//		ValidatableResponse validate = response.then();
//		validate.assertThat().statusCode(201);
//		validate.assertThat().contentType(ContentType.JSON);
//		validate.log().all();
		
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
				
		
		
	}

}
