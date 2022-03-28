package com.TestYantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TokenAuthTest {
	@Test
	public void tokenAuth() {
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/users/SurajkumarN/repos")
		.then()
		.statusCode(200)
		.log().body();
	}
}
