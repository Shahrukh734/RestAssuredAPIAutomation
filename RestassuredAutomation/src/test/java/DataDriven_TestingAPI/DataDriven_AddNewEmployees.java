package DataDriven_TestingAPI;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriven_AddNewEmployees {

	@Test(dataProvider="empdataProvider")
	void postNewEmployees(String ename,String esal, String eage){
		
				//specify the base URI
				RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
				
				//Request object 
				RequestSpecification httpRequest = RestAssured.given();
				
				//Request payload sending along with post request
				JSONObject requestParams = new JSONObject();
				requestParams.put("name", ename);
				requestParams.put("salary", esal);
				requestParams.put("age", eage);
				
				httpRequest.header("Content-Type","application/json");
				httpRequest.body(requestParams.toJSONString()); //attach above data to the request
				
						//Response object 
						Response response = httpRequest.request(Method.POST, "/create");
						
						
						//capture response body to perform validations
						String responseBody = response.getBody().toString();
						
						Assert.assertEquals(responseBody.contains(ename),true);
						Assert.assertEquals(responseBody.contains(esal),true);
						Assert.assertEquals(responseBody.contains(eage),true);
						
						int statusCode= response.getStatusCode();
						Assert.assertEquals(statusCode,200);
						
						
	}

	
	
	@DataProvider(name="empdataProvider")
	String [][] getEmpData(){
		String empData[][]={{"abc123","30000","28"},{"def123","40000","29"},{"ghi123","50000","30"}};
		return(empData);
	}


}
