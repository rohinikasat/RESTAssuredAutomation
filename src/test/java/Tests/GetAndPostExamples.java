package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExamples {

	@Test
	public void testPost() {
		//Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Rohini");
//		map.put("job", "Coder");
//		
//		System.out.println(map);
		baseURI = "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("name", "Rohini");
		request.put("job", "Coder");
		System.out.println(request);
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).// telling server that content I'm sending to you is of type Json and the response that I'll accept is also of type JSON
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
	
}
