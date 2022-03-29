package com.TestYantra.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class AllHttpMethods {

	Object projid;

	@Test(priority = 1)
	public void getMethod() {
		Response res = given().when().get("http://localhost:8084/projects");
		res.then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON).log().body();
		System.out.println("************************get method executed");
	}

	@Test(priority = 0)
	public void postMethod() {

		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project" + num);

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Suraj");
		jobj.put("projectName", proj);
		jobj.put("status", "on Going");
		jobj.put("teamSize", num);

		Response res = given().body(jobj).contentType(ContentType.JSON).when().post("http://localhost:8084/addProject");
		res.then().assertThat().contentType(ContentType.JSON).assertThat().statusCode(201).log().all();
		projid = res.jsonPath().get("projectId");
		System.out.println(projid);
		System.out.println("************************post method executed");

	}

	@Test(priority = 2)
	public void putMethod() {
		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project" + num);

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "SurajNag");
		jobj.put("projectName", proj);
		jobj.put("status", "on Going");
		jobj.put("teamSize", num);

		given().pathParam("projidnum", projid)
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/{projidnum}")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.assertThat().statusCode(200)
				.log().all();
		System.out.println("************************put method executed");
	}

	@Test(priority = 3)
	public void deleteMethod() {
		given().pathParam("projidnum", projid).when().delete("http://localhost:8084/projects/{projidnum}").then()
				.assertThat().statusCode(204).assertThat().contentType(ContentType.JSON).log().all();
		System.out.println("************************delete method executed");
	}
}
