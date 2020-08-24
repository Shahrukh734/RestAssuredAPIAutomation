package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends TestBase{

	@BeforeClass
	void getEmployeeData() throws InterruptedException
	{
		logger.info("************Started TC002_Get_Single_Employee_Record*************");
		RestAssured.baseURI = "";
		httpRequest = RestAssured.given();
		response =  httpRequest.request(Method.GET,"/employee/"+empID);
		
		Thread.sleep(3);
	}
	
	
	@Test
	void checkResponseBody()
	{
		logger.info("****************Checking Response Body*****************");
		String responseBody = response.getBody().asString();
		logger.info("Response Body is ==> "  +responseBody);
		Assert.assertEquals(responseBody.contains(empID), true);
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
	void checkResponseTime()
	{
		logger.info("***************Checking Resonse Time****************");
		long responseTime = response.getTime();
		logger.info("Response Time is ==>" +responseTime);
		
		if(responseTime>2000)
			logger.warn("Response Time is greater than 6000");
		
		Assert.assertTrue(responseTime<6000);
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
	void checkContentLength()
	{
		logger.info("**************Checking content length*****************");
		String contentLength = response.header("Content-Length");
		logger.info("Content length is ==> " +contentLength);
		Assert.assertTrue(Integer.parseInt(contentLength)<1500);
		
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*****************Finished TC002_Get_Single_Employee_Record********************");
	}
	
	
	
	
}
