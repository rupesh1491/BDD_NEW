package API;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class Test1 {
	
	@Test
	public void getdetails() {
		given()
		.when()
		.get("https://api.agify.io?name=meelad")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("name",equalTo("meelad"))
		.header("Content-type", "application/json; charset=utf-8");
		
		
	}

}
