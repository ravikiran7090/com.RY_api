package com.TestYantra.WithBDDFeatures;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteResourceTest {
	@Test
	public void getresource() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_1804")
			
		.then()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}
}
