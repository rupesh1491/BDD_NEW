package API;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Put_Data {
	
	
	public static HashMap map=new HashMap();
	
	String cccountry=RestUtils.getCountry();
	String series="f1";
	
	@BeforeClass
	public void postdata()
	{
		map.put("country", cccountry);
		
		RestAssured.baseURI="http://ergast.com/api/f1/2005/last.json" ;
		RestAssured.basePath="/update/"+series;
		
	}
	@Test
	public void testPost() {
		given()
		.contentType("application/json; charset=utf-8")
		.body(map)
		.when()
		.put()
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
