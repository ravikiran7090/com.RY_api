package com.TestYantra.validations;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Random;

public class StaticResponceValidationForPostTest {
	@Test
	public void staticResponceValidations() {
		Response response;

		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project" + num);

		JSONObject obj = new JSONObject();
		obj.put("createdBy", "me");
		obj.put("projectName", proj);
		obj.put("status", "on going");
		obj.put("teamSize", 25);

		response = given().body(obj).contentType(ContentType.JSON).when().post("http://localhost:8084/addProject");
		response.then().log().body();

		Object projname = response.jsonPath().get("projectName");
		System.out.println(projname);
		Object projid = response.jsonPath().get("projectId");
		System.out.println(projid);

		Assert.assertEquals(projname.equals(proj), true);
		Assert.assertEquals(projid, projid);

	}

}
