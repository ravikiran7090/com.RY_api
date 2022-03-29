package com.TestYantra.WithBDDFeatures;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FullUpdateTest {
	
	@Test
	public void update() {
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "medgdadf");
		obj.put("projectName", "TYSdsfdsagdgfgfdhdfhbadfa");
		obj.put("status", "on going");
		obj.put("teamSize", "25");
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_4610")
		.then()
			.assertThat().contentType(ContentType.JSON)
		//assertThat().statusCode(200)
			.log().all();
		
		
	}

}
