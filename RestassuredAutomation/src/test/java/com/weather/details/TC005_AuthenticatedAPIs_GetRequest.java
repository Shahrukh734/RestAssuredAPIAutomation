package com.weather.details;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_AuthenticatedAPIs_GetRequest {

	@Test
	void AuthorizationAPI(){
		
		//specify the base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

		//Basic Authentication
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		RestAssured.authentication = authscheme;
		
		//Request object 
		RequestSpecification httpRequest = RestAssured.given();
				
		//Response object 
		Response response = httpRequest.request(Method.GET, "/");
				
		//print response in console 
		String responseBody = response.getBody().asString();
		System.out.println("Response body is " +responseBody);
				
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		
	}
	
	
	
}
