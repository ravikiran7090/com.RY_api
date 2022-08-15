package com.TestYantra.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestYantra.pojoLib.PojoClass;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DataVerifiedInDataBaseTest {
	@Test
	public void verificationibdb() throws SQLException {
		Random ran = new Random();
		int num = ran.nextInt(1000);
		String proj = ("project" + num);

		PojoClass pcobj = new PojoClass("Suraj", proj, "on going", "25");

		Response responce = given().body(pcobj).contentType(ContentType.JSON).when()
				.post("http://localhost:8084/addProject");
		responce.then().assertThat().contentType(ContentType.JSON).assertThat().statusCode(201).log().all();

		String createdby = responce.jsonPath().get("createdBy");
		String projectname = responce.jsonPath().get("projectName");
		String projectid = responce.jsonPath().get("projectId");
		String createdon = responce.jsonPath().get("createdOn");
		String status = responce.jsonPath().get("status");
		System.out.println("------------------------------");

		Connection connect = null;
		try {
			Driver driveRef = new Driver();
			DriverManager.registerDriver(driveRef);
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			System.out.println("----------db linked------------- ");
			ResultSet result = connect.createStatement().executeQuery("select * from project");

			while (result.next()) {

				/*
				 * System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" +
				 * result.getString(3) + "\t" + result.getString(4) + "\t" + result.getString(5)
				 * + "\t" + result.getString(6));
				 */
				if (result.getString(1).equals(projectid)) {
					Assert.assertEquals(result.getString(1), projectid);
					Assert.assertEquals(result.getString(2).equals(createdby), true);
					Assert.assertEquals(result.getString(3).equals(createdon), true);
					Assert.assertEquals(result.getString(4).equals(projectname), true);
					Assert.assertEquals(result.getString(5).equals(status), true);
					System.out.println("verified");
				}
			}
		} catch (Exception e) {

		} finally {
			connect.close();
			System.out.println("------------db delinked---------------");
		}

	}
}
