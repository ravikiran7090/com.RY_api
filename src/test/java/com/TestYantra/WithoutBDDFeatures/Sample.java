package com.TestYantra.WithoutBDDFeatures;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Sample {
	@Test
	public void postProjectDetails() {
		
		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project"+num);
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "ramrajya");
		obj.put("projectName", proj);
		obj.put("status", "onGoing");
		obj.put("teamSize", 20);

		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(obj);

		Response response = reqspec.post("http://localhost:8084/addProject");
		//response.prettyPrint();
		JsonPath path = response.getBody().jsonPath();
		Object d = path.getJsonObject("projectId");
		System.out.println(d);

		ValidatableResponse validate = response.then();
		//validate.assertThat().statusCode(201);
		validate.assertThat().contentType(ContentType.JSON);
		validate.log().all();

	}

}
