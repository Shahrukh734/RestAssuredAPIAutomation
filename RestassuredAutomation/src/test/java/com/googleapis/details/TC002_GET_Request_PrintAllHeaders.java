package com.googleapis.details;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_GET_Request_PrintAllHeaders {

	@Test
	void googleAPIsPrintAllHeaders(){
		
		//specify the base URI
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Request object 
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object 
		Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4IgTqSTDmHmJ2HoELb4Jy1s");
		
		//print response in console 
		
		String responseBody = response.getBody().asString();
		System.out.println("Response body is " +responseBody);
		
		//capture all the headers 
		Headers allheaders = response.headers();
		
		for(Header header:allheaders)
		{
			System.out.println(header.getName()+ "         " +header.getValue());
		}
		
		
	}
	
	
}
