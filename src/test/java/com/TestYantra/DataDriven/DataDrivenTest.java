package com.TestYantra.DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestYantra.pojoLib.PojoClass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenTest {
	@Test(dataProvider = "projectData")
	public void createResource(String createdBy, String projectName, String status, String teamSize) {

		 PojoClass data = new PojoClass(createdBy, projectName, status, teamSize);

		given()
		.body(data)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().body();

	}

	@DataProvider
	public Object[][] projectData() {
		Object[][] obj = new Object[4][4];

		obj[0][0] = "Suraj";
		obj[0][1] = "Suryaempire 1";
		obj[0][2] = "on going";
		obj[0][3] = "455";

		obj[1][0] = "Suraj";
		obj[1][1] = "Suryaempire 2";
		obj[1][2] = "on going";
		obj[1][3] = "455";

		obj[2][0] = "Suraj";
		obj[2][1] = "Suryaempire 3";
		obj[2][2] = "on going";
		obj[2][3] = "455";

		obj[3][0] = "Suraj";
		obj[3][1] = "Suryaempire 4";
		obj[3][2] = "on going";
		obj[3][3] = "455";

		return obj;
	}
}
