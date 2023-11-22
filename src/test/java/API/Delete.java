package API;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Delete {
	
	@Test
	public void testPost() {
		RestAssured.baseURI="http://ergast.com/api/f1/2005/last.json" ;
		RestAssured.basePath="/delete/limit";
	
		Response response =
		 
		 given()
		
		
		.when()
		.delete()
		
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.log().all()
		.extract().response();
		
		String jsonString=response.asString();
		Assert.assertEquals(jsonString.contains("sucessfully deleted record"),true);
		
		

}
}
