package test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.*;

public class PutPatchDelete {
	@Test
	public void put() {
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("Umesh", "Patil");
		map.put("SW Eng", "Fit Trainer");
		
		JSONObject j= new JSONObject(map);
		System.out.println(j);
		baseURI="https://reqres.in/api";
		given()
			.body(j.toJSONString())
			.header("Content-Type","Application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
			
		
	}
	@Test
	public void patch() {
		Map<String, Object> ma=new HashMap<String, Object>();
		ma.put("Entrepreneur", "Politician");
		JSONObject t=new JSONObject(ma);
		System.out.println(ma);
		
		baseURI="https://reqres.in/api";
		given()
			.body(t.toJSONString())
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.patch("/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test
	public void delete() {
		baseURI="https://reqres.in/api";
		when()
			.delete("/users/2")
		.then()
			.statusCode(204);
	}

}
