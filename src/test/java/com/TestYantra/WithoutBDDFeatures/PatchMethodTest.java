package com.TestYantra.WithoutBDDFeatures;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PatchMethodTest {
	@Test
	public void partialUpdate() {
		
		 JSONObject obj = new JSONObject();
		 obj.put("name", "modi");
		 obj.put("job", "prime minister");
		 
		 RequestSpecification reqspec = RestAssured.given();
		 reqspec.contentType(ContentType.JSON);
		 reqspec.body(obj);
		 
		 Response response = reqspec.patch("https://reqres.in/api/users/2");
		 ValidatableResponse validate = response.then();
		 validate.log().all();
		 validate.assertThat().contentType(ContentType.JSON);
		 validate.assertThat().statusCode(200);
	}
}
