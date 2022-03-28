package com.TestYantra.WithBDDFeatures;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PartialUpdateTest {

	@Test
	public void update() {
		JSONObject obj = new JSONObject();
		obj.put("name", "dog");
		obj.put("job", "bark");

		given().body(obj).contentType(ContentType.JSON).when().patch("https://reqres.in/api/users/2").then()
				.assertThat().contentType(ContentType.JSON).assertThat().statusCode(200).log().all();

	}

}
