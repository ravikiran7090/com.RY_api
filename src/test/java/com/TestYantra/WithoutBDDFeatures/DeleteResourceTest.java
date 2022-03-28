package com.TestYantra.WithoutBDDFeatures;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteResourceTest {

	@Test
	public void deleteProject() {
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.delete("http://localhost:8084/projects/TY_PROJ_1812");
		response.prettyPrint();
		ValidatableResponse validate = response.then();
		validate.assertThat().statusCode(204);
		
		RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1813");
	}
}
