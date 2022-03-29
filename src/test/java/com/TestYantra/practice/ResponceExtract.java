package com.TestYantra.practice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

public class ResponceExtract {
	@Test
	public void httpmethods() {
		RestAssured.baseURI = "http://localhost:8084/";
		RestAssured.basePath="projects";
		
		 Response res = given()
		.when()
			.get();
		res.then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON)
			.extract().response();
		//System.out.println(res.asPrettyString());
		System.out.println("***************************************");
		//System.out.println(res.asString());
		System.out.println("***************************************");
		System.out.println(res.print());
		System.out.println("***************************************");
		System.out.println(res.prettyPrint());
		
	}

}
