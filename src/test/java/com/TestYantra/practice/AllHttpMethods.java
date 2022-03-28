package com.TestYantra.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class AllHttpMethods {

	int num;
	String proj;
	

	@Test(priority = 0)
	public void getMethod() {
		given()

				.when().get("http://localhost:8084/projects").then().assertThat().statusCode(200).assertThat()
				.contentType(ContentType.JSON).log().body();
	}

	@Test(priority = 1)
	public void postMethod() {

		Random ran = new Random();
		num = ran.nextInt(1000);
		proj = ("project" + num);

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Suraj");
		jobj.put("projectName", proj);
		jobj.put("status", "on Going");
		jobj.put("teamSize", num);

		given().body(jobj).contentType(ContentType.JSON).when().post("http://localhost:8084/addProject").then()
				.assertThat().contentType(ContentType.JSON).assertThat().statusCode(201).log().all();
	 Response res = when().get();
	 Object projid = res.jsonPath().get("[0].projectId");
	 System.out.println(projid);
		
	}

	@Test(priority = 2)
	public void putMethod() {

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Suraj");
		jobj.put("projectName", proj);
		jobj.put("status", "on Going");
		jobj.put("teamSize", num);

		given().body(jobj).contentType(ContentType.JSON).when().post("http://localhost:8084/projects/projid")
				.then().assertThat().contentType(ContentType.JSON).assertThat().statusCode(201).log().all();
	}

	@Test(priority = 3)
	public void deleteMethod() {
		given().when().delete("http://localhost:8084/projects/projid").then().assertThat().statusCode(204)
				.assertThat().contentType(ContentType.JSON).log().all();
	}
}
