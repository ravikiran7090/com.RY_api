package com.TestYantra.WithoutBDDFeatures;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetResouceTest {
	@Test
	public void getAllProjects() {

		Response responce = RestAssured.get("http://localhost:8084/projects");

		// printing header, projects,
		ValidatableResponse res = responce.then();
		System.out.println(res.log().all());
		
		// print all project in single line
		// System.out.println(responce.asString());

		// print all projects present in DB
		// System.out.println(responce.prettyPrint());

		// print header, project,
		// System.out.println(responce.prettyPeek());
		
		
	}
}
