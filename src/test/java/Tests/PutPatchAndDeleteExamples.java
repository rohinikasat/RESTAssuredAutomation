package Tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAndDeleteExamples {
	
	@Test
	public void testPut() {
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
			put("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testPatch() {
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
			patch("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in/api";
		
		when().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();
	}
	
}
