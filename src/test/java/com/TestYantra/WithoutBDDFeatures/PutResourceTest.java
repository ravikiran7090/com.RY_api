package com.TestYantra.WithoutBDDFeatures;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutResourceTest {

	@Test
	public void fullUpdate() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "MSD");

		RequestSpecification reqspec = RestAssured.given();
		reqspec.body(obj);
		reqspec.contentType(ContentType.JSON);

		Response response = reqspec.put("http://localhost:8084/projects/TY_PROJ_1608");
		//response.prettyPrint();

		ValidatableResponse validate = response.then();
		validate.log().all();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
	}
}
