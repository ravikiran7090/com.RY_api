package com.TestYantra.RequestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DeleteUser_EmployeeTest {
	@Test
	public void deleteEmployee() {
		//String empid = "TYP_00837";
		given()
		//.pathParam("empID", empid)
		.when()
		.delete("http://localhost:8084/employees/TYP_00837")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
		
	}

}
