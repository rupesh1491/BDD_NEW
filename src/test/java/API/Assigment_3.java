
package API;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Assigment_3 {
    
	 public static void main(String[] args){
	        // Set the base URL for the API
	        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";

	        // Step 1: Create a new user
	        createUser();

	        // Step 2: Read the created user
	        String createdUserId = "theUser"; // Replace with the actual user ID
	        readUser(createdUserId);

	        // Step 3: Update the user's username
	        String updatedUsername = "newUsername"; // Replace with the updated username
	        updateUser(createdUserId, updatedUsername);

	        // Step 4: Read the updated user
	        

	     // Step 4: Read the updated user
	        readUser(updatedUsername);

	        // Step 5: Delete the user
	        deleteUser(updatedUsername);

	        // Step 6: Verify the user is deleted
	        verifyUserDeleted(updatedUsername); 
	    }
    	
    	
    	    private static void createUser() {
    	        // Define the request payload (user data)
    	        String requestBody = "{\n" +
    	                "  \"id\": 15,\n" +
    	                "  \"username\": \"theUser\",\n" +
    	                "  \"firstName\": \"John\",\n" +
    	                "  \"lastName\": \"James\",\n" +
    	                "  \"email\": \"john@email.com\",\n" +
    	                "  \"password\": \"12345\",\n" +
    	                "  \"phone\": \"12345\",\n" +
    	                "  \"userStatus\": 1\n" +
    	                "}";

    	        // Send the POST request to create a new user
    	        Response response = RestAssured.given()
    	                .contentType(ContentType.JSON)
    	                .body(requestBody)
    	                .post();

    	        // Print the response
    	        System.out.println("Create User Response Code: " + response.getStatusCode());
    	        System.out.println("Create User Response Body: " + response.getBody().asString());
    	    }

    	    private static void readUser(String userId) {
    	        // Send the GET request to read the user
    	        Response response = RestAssured.given()
    	                .pathParam("username", userId)
    	                .get("/{username}");

    	        // Print the response
    	        System.out.println("Read User Response Code: " + response.getStatusCode());
    	        System.out.println("Read User Response Body: " + response.getBody().asString());
    	    }

    	    private static void updateUser(String userId, String updatedUsername) {
    	        // Define the request payload (updated user data)
    	        String requestBody = "{\n" +
    	                "  \"id\": 15,\n" +
    	                "  \"username\": \"" + updatedUsername + "\",\n" +
    	                "  \"firstName\": \"John\",\n" +
    	                "  \"lastName\": \"James\",\n" +
    	                "  \"email\": \"john@email.com\",\n" +
    	                "  \"password\": \"12345\",\n" +
    	                "  \"phone\": \"12345\",\n" +
    	                "  \"userStatus\": 1\n" +
    	                "}";

    	        // Send the PUT request to update the user
    	        Response response = RestAssured.given()
    	                .contentType(ContentType.JSON)
    	                .pathParam("username", userId)
    	                .body(requestBody)
    	                .put("/{username}");

    	        // Print the response
    	        System.out.println("Update User Response Code: " + response.getStatusCode());
    	        System.out.println("Update User Response Body: " + response.getBody().asString());
    	    }

    	    private static void deleteUser(String userId) {
    	        // Send the DELETE request to delete the user
    	        Response response = RestAssured.given()
    	                .pathParam("username", userId)
    	                .delete("/{username}");

    	        // Print the response
    	        System.out.println("Delete User Response Code: " + response.getStatusCode());
    	        System.out.println("Delete User Response Body: " + response.getBody().asString());
    	    }

    	    private static void verifyUserDeleted(String userId) {
    	        // Send the GET request to read the user
    	        Response response = RestAssured.given()
    	                .pathParam("username", userId)
    	                .get("/{username}");

    	        // Print the response
    	        System.out.println("Verify User Deleted Response Code: " + response.getStatusCode());
    	        System.out.println("Verify User Deleted Response Body: " + response.getBody().asString());
    	    }
    	   

    	}
