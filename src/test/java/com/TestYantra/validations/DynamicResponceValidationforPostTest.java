package com.TestYantra.validations;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Random;

public class DynamicResponceValidationforPostTest {
	@Test
	public void dynamicRsponceValidation() {
		
		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project" + num);

		JSONObject obj = new JSONObject();
		obj.put("createdBy", "me");
		obj.put("projectName", proj);
		obj.put("status", "on going");
		obj.put("teamSize", 25);

		Response response = given()
				.body(obj)
				.contentType(ContentType.JSON)
				.when().post("http://localhost:8084/addProject");
		
		response.then().log().body();
		
		Object projid = response.jsonPath().get("projectId");

		
		Response responsebase = when().get("http://localhost:8084/projects");
		responsebase.then().log().body();
		
		List<String> pname = responsebase.jsonPath().get("projectName");
		Assert.assertEquals(pname.contains(proj), true);
		
		List<String> pid = responsebase.jsonPath().get("projectId");
		Assert.assertEquals(pid.contains(projid), true);
			
	}
}
