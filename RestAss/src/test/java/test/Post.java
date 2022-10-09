package test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Post {
	@Test
	public void get() {
		baseURI= "https://reqres.in/api";
		given()
			.get("/users?page=2")
		.then()
			.statusCode(200)
			.body("data[4].first_name", equalTo("George"))
			.body("data.first_name", hasItems("George","Rachel"));
		
		
	}
	@Test
	public void testPost() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("Umesh", "Patil");
		m.put("Entrepreneur", "MultipleB");
		System.out.println(m);
		JSONObject mp = new JSONObject(m);
		mp.put("Test", "Engineer");
		System.out.println(mp);
		
		
		baseURI = "https://reqres.in/api";
		given()
			.body(mp.toJSONString())
			.header("Content-Type","application/JSON")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();

	} 

}
