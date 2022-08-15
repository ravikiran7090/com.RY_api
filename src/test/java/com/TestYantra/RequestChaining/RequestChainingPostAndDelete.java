package com.TestYantra.RequestChaining;

import java.util.Random;

import org.testng.annotations.Test;

import com.TestYantra.pojoLib.PojoClass;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingPostAndDelete {
	@Test
	public void chaining() {

		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project" + num);

		PojoClass pcobj = new PojoClass("Suraj", proj, "completed", "45");

		Response response = given()
				.body(pcobj)
				.contentType(ContentType.JSON)
				.when()
				.post("http://localhost:8084/addProject");
		response.then()
				.assertThat().statusCode(201).log().body();
		System.out.println("-------PROJECT CREATED-------");

		String projid = response.jsonPath().get("projectId");
		System.out.println("PROJECT ID : "+projid);

		given()
		.pathParam("projectid", projid)
		.when()
		.delete("http://localhost:8084/projects/{projectid}")
		.then()
		.assertThat().statusCode(204)
		.log().all();

	}

}
