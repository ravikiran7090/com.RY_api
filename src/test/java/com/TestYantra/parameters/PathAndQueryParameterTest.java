package com.TestYantra.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathAndQueryParameterTest {
@Test
public void pathAndquery() {
	
	given()
		.pathParam("username", "SurajkumarN")
		.queryParam("sort", "created")
		.queryParam("page", "2")
	.when()
		.get("https://api.github.com/users/{username}/repos")
	.then()
		.assertThat().statusCode(200)
		.log().all();
}
}
