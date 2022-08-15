package com.TestYantra.RequestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DeleteUser_EmployeeTest {
	@Test
	public void deleteEmployee() {
		String empid = "TYP_01003";
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
