package com.TestYantra.RequestChaining;

import java.util.Random;

import org.testng.annotations.Test;

import com.TestYantra.pojoLib.PojoClass;
import com.TestYantra.pojoLib.PojoClassUser;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Project_and_Allocate_User_Test {
	@Test
	public void createProjectAndAllocateUser() {

		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project" + num);
		String userName=("suraj"+num);

		PojoClass pcobj = new PojoClass("Suraj", proj, "completed", "45");

		Response response = given().body(pcobj).contentType(ContentType.JSON).when()
				.post("http://localhost:8084/addProject");
		response.then().assertThat().statusCode(201).log().body();
		System.out.println("------------------------------------");

		String projName = response.jsonPath().get("projectName");
		System.out.println(projName);
		System.out.println("-----------------------------");
		
		PojoClassUser pcu=new PojoClassUser("SDET","25/05/1999","sdet@gamil.com",
				"Suraj","2","9876543210",projName,"tester",userName);
			given()
			.body(pcu)
			.contentType(ContentType.JSON)
			.when().post("http://localhost:8084/employees")
			.then()
			.assertThat().statusCode(201)
			.log().body();
	
	}
}
