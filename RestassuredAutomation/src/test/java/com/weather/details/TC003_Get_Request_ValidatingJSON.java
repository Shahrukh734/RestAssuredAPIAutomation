package com.weather.details;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_Get_Request_ValidatingJSON {

	@Test
	void validatingJSON_GetRequest(){
		
				//specify the base URI
				RestAssured.baseURI = "weather api";
				
				//Request object 
				RequestSpecification httpRequest = RestAssured.given();
				
				//Response object 
				Response response = httpRequest.request(Method.GET, "/Delhi");
				
				//print response in console 
				
				String responseBody = response.getBody().asString();
				System.out.println("Response body is " +responseBody);
				
				Assert.assertEquals(responseBody.contains("Delhi"), true);
		
	}
	
	
	
}
