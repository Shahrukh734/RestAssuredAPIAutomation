package DataDriven_TestingAPI;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriven_AddNewEmployees_Excel {

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
	String [][] getEmpData() throws IOException{
		
		//Read data from excel
		String path = System.getProperty("user.dir")+"/src/test/java/DataDriven_TestingAPI/empdata.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		
		String empData[][]= new String[rownum][colcount];
		for(int i =1;i<=rownum;i++){
			for(int j=0;j<colcount;j++){
				empData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return(empData);
	}
}

