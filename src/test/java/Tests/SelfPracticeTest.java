package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class SelfPracticeTest {
	@Test
	public void Test1() {
		baseURI = "https://gorest.co.in";
		given().get("/public/v2/users").then().statusCode(200).body("[3].id", equalTo(3535));
	}
}
