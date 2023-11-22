package API;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Post_Data {
	
	public static HashMap map=new HashMap();
	
	@BeforeClass
	public void postdata()
	{
		map.put("id", "10");
		map.put("firstname", "John");
		
		RestAssured.baseURI="https://petstore3.swagger.io/#/user" ;
		RestAssured.basePath="/register";
		
	}
	@Test
	public void testPost() {
		given()
		.contentType("application/json; charset=utf-8")
		.body(map)
		.when()
		.post()
		
		.then()
		.statusCode(201);
		
		
	}

}
