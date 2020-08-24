package com.googleapis.details;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	@Test
	void googleMapTest(){
		
				//specify the base URI
				RestAssured.baseURI = "https://maps.googleapis.com";
				
				//Request object 
				RequestSpecification httpRequest = RestAssured.given();
				
				//Response object 
				Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4IgTqSTDmHmJ2HoELb4Jy1s");
				
				//print response in console 
				
				String responseBody = response.getBody().asString();
				System.out.println("Response body is " +responseBody);
				
				//capture content type details from response 
				String contentType = response.header("Content-Type");
				System.out.println("Content type is " +contentType);
				Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
				
				//capture content encoding details from response
				String contentEncoding = response.header("Content-Encoding");
				System.out.println("Content type is " +contentEncoding);
				Assert.assertEquals(contentEncoding, "gzip");
				
	}
	
	
	
}
