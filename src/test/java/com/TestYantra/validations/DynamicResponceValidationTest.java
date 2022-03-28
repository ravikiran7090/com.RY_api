package com.TestYantra.validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponceValidationTest {
	@Test
	public void dynamicRsponceValidations() {
		Response response = when()
		.get("http://localhost:8084/projects");
		List<String> projid = response.jsonPath().get("projectId");
		System.out.println(projid);
//		boolean flag=false;
//		for (String id : projid) {
//			if(id.equals("project855")) {
//			flag=true;
//			}
//		}
		Assert.assertEquals(projid.contains("TY_PROJ_2819"), true);
		response.then().log().all();
		
		
		
	}

}
