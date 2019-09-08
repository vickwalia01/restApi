import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T003_GET_Request {
	
	@Test
	void googleMapTest() { // google maps get request
		
	// Specify base URI
		RestAssured.baseURI= "https://maps.googleapis.com";
		
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response object
		Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=40.739922,-73.877384&radius=1500&type=supermarket&key=AIzaSyA9BtU2EQ4kI1iGB_1zXJppGnML01LX0o8");
		
		// print response in console window
		
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:" + responseBody);
		
		// validating headers
		
		String contentType = response.header("Content-Type"); // capture details of Content-type header
		System.out.println("content Type is :" + contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		String contentEncoding = response.header("Content-Encoding"); // capture details of Content-type header
		System.out.println("content Encoding is :" + contentEncoding);
		Assert.assertEquals(contentType, "gzip");
			
	}
	
}
