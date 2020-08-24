package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_Post_Employee_Record extends TestBase {

	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	
	
	@BeforeClass
	void createEmployee() throws InterruptedException
	{
		logger.info("*****************Started TC003_Post_Employee_Record*********************");
		
		RestAssured.baseURI="";
		httpRequest = RestAssured.given();
		
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empName);
		requestParams.put("salary", empSalary);
		requestParams.put("age", empAge);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.POST,"/create");
		
		Thread.sleep(5000);
		
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody = response.getBody().toString();
		Assert.assertEquals(responseBody.contains(empName),true);
		Assert.assertEquals(responseBody.contains(empSalary),true);
		Assert.assertEquals(responseBody.contains(empAge),true);
		
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
		logger.info("*****************Finished TC003_Post_Employee_Record******************");
	}
	
	
	
	
}
