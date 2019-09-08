import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_POST_Request { // POST REQUEST [post means create new]
	
	
	
	@Test
	void RegistrationSuccessful() {
		
	// Specify Base URI
		RestAssured.basePath = "https://restapi.demoqa.com/customer";
		
	// Request object 
	RequestSpecification httpRequest = RestAssured.given();
	
	// response Object
	// Request payload sending along with post
	
	JSONObject requestParams = new JSONObject();// JSONObject is a json-simple jar class
	
	requestParams.put("FirstName", "arif");
	requestParams.put("LastName","mod");
	requestParams.put("UserName", "Arif212");
	requestParams.put("Password", "mod415");
	requestParams.put("Email","raj@gmail.com");
	
	httpRequest.header("Content-Type","application/json");
		
	httpRequest.body(requestParams.toJSONString());// this method will convert above info into json format
	                                                // and then attach above data to the request
		
		
	// ABOVE WE WERE PREPARING OUR REQUEST DETAILS AND CONVERTING TO JSON METHOD.
	// NOW BELOW WE WILL ACTUALLY SEND THE REQUEST.
	
	// Response object [ sending request with object]
	Response response = httpRequest.request(Method.POST, "/register");// this is post method means create new
	
	// print response in console window
	String responseBody = response.getBody().asString();// will turn json response into String & store into responsebody
	System.out.println("Response body is: "+ responseBody);
	
	// status code validation using assert from testng
	int statusCode = response.getStatusCode();
	System.out.println("Status code is:"+ statusCode);
	Assert.assertEquals(statusCode, 201); // 201 is a sucessful post code 
	
	// this method will get the value of SuccessCode from Json response and add it the variable 
	String successCode = response.jsonPath().get("SuccessCode");
	Assert.assertEquals(successCode, "OPERATION_SUCCESS"); // asserting to compare the successcodes
	
	
		
	}
	

}
