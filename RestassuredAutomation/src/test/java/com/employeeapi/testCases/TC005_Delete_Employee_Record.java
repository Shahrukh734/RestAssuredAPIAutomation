package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Employee_Record extends TestBase {

	@BeforeClass
	void deleteEmployee() throws InterruptedException
	{
		logger.info("*****************Started TC005_Delete_Employee_Record*********************");
		
		RestAssured.baseURI="";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET,"/employees");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		//Capture ID from the response itself 
		String empID = jsonPathEvaluator.get("[0].id");
		
		
		response = httpRequest.request(Method.DELETE,"/delete/" + empID);
		
		Thread.sleep(5000);
		
	}
	

	@Test
	void checkResponseBody()
	{
		String responseBody = response.getBody().toString();
		Assert.assertEquals(responseBody.contains("Successfully! deleted Records"),true);
		
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("****************Checking Status Code***************");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is ==>"  + statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void checkStatusLine()
	{
		logger.info("****************Checking Status Line****************");
		String statusLine = response.getStatusLine();
		logger.info("Status line is ==>" +statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void checkContentType()
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}
	
	@Test
	void checkServerType()
	{
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "nginx/1.14.1");
	}
	
	@Test
	void checkContentEncoding()
	{
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding, "gzip");
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*****************Finished TC005_Delete_Employee_Record******************");
	}
	
	
}
