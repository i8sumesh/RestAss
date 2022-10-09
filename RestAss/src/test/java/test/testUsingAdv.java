package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class testUsingAdv {
	@Test
	public void test2() {
		Response rp = get("https://reqres.in/api/users?page=2");
		System.out.println(rp.getStatusCode());

	}
	@Test
	public void testJsonPath() {
		baseURI = "https://reqres.in";
		given()
			.get("/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data[1].id", equalTo(8))
			.log().all();
	}

}
