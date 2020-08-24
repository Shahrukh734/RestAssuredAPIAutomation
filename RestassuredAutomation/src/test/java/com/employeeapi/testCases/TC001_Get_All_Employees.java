package com.employeeapi.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC001_Get_All_Employees extends TestBase{

	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		logger.info("************Started TC001_Get_All_Employees*************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response =  httpRequest.request(Method.GET,"");
		
		
		Thread.sleep(3);
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("****************Checking Response Body*****************");
		String responseBody = response.getBody().asString();
		logger.info("Response Body is ==> "  +responseBody);
		Assert.assertTrue(responseBody!=null);
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
			logger.warn("Response Time is greater than 2000");
		
		Assert.assertTrue(responseTime<2000);
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
	void checkContentLength()
	{
		logger.info("**************Checking content length*****************");
		String contentLength = response.header("Content-Length");
		logger.info("Content length is ==> " +contentLength);
		
		if(Integer.parseInt(contentLength)<100)
			logger.warn("Content length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
		
	}
	
	
	@Test
	void checkCookies()
	{
		logger.info("*******************Checking Cookies*******************");
		String cookie = response.getCookie("PHPSESSID");
	}
	
	
	@AfterClass
	void tearDown()
	{
		logger.info("*****************Finished TC001_Get_All_Employees******************");
	}
	
	
}
