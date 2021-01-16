import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.Restassured;
import io.restassured.response.Response;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;



public class restApi_Get_Request {
	
	@test
	void getWeatherDetails() {
		
		RestAssured.baseURI=http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"Hyderabad");
		String responseBody=response.getResponseBody();
		
		System.out.println("Response Body is:  "+responseBody);
		int statusCode=response.getStatusCode();
		System.out.println("Staus Code is:  "+statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println(testing);
		
		String statusLine=response.getStatusText();
		System.out.println("Status Line is:   "+ statusLine.toString());
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
}
