package com.TestYantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0Test {
		@Test
		public void Oauth2(){
			Response response = given()
				.formParam("client_id", "Chiken")
				.formParam("client_secret", "7cd5c9f2097882663583f862b68ad28e")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://example.com")
			.when()
				.post("http://coop.apps.symfonycasts.com/token");
			
			response.then().log().body();
			
			
			String token = response.jsonPath().get("access_token");
			
			given()
				.auth().oauth2(token)
				.pathParam("USER_ID", 2921)
			.when()
				.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
			.then()
				.log().body();
		}

}
