
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request { // GET REQUEST
	
	
	@Test
	void getweatherDetails() {
		
		// Specify base URI
		
		RestAssured.baseURI= "https://restapi.demoqa.com/utilities/weather/city";
		
		// creating the request object. we will send request with this object
		
		RequestSpecification httpRequest = RestAssured.given();
		
		// Creating response Object. The reponse will be stored in response variable
		
		Response response = httpRequest.request(Method.GET,"/Hyderabad"); // provided the city to get method
		
		// Printing  response on console
	   String responseBody = response.getBody().asString(); // asString method will convert json format to string 
	   System.out.println("Response body is :" + responseBody);
	   
	   // Status code Validation [statuscode] variable is holding the value of the status code
	  int statuscode =  response.getStatusCode();
	  System.out.println("Status code is "+ statuscode);
	  Assert.assertEquals(statuscode, 200); // 200 code means request success 
	  
	  // status line verification
	  String statusLine = response.getStatusLine();
	  System.out.println("Status Line is: " + statusLine);
	  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	  
	   	
	}

}
