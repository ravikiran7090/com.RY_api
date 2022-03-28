package com.TestYantra.RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.TestYantra.pojoLib.PojoClassUser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAndDeleteUserTest {
	@Test
	public void CreateAndDeleteUser() {
		Random ran = new Random();
		int num = ran.nextInt(1000);
		String userName=("Suraj"+num);
		
		Response response = given()
			.when().get("http://localhost:8084/projects");
		String projName = response.jsonPath().get("[0].projectName");
		System.out.println("PROJECT NAME :---"+projName);
		System.out.println("------PROJECT NAME------");
		
		PojoClassUser pcu=new PojoClassUser("SDET","25/05/1999","sdet@gamil.com",
				"Suraj","2","9876543210",projName,"tester",userName);
			Response respost = given()
			.body(pcu)
			.contentType(ContentType.JSON)
			.when()
			.post("http://localhost:8084/employees");
		respost.then()
			.assertThat().statusCode(201)
			.log().body();
		System.out.println("------EMPLOYEE CREATED------");
		
		String empid= respost.jsonPath().get("employeeId");
		System.out.println("EMPLOYEE ID : "+empid);
		System.out.println("------EMPLOYEE ID------");
	
			
			given()
			.pathParam("empID", empid)
			.when()
			.delete("http://localhost:8084/employees/{empID}")
			.then()
			.assertThat()
			.statusCode(204)
			.log().all();
			
	}
}
