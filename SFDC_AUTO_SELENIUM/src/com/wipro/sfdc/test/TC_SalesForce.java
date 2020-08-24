package com.wipro.sfdc.test;

import org.testng.annotations.Test;

import com.wipro.sfdc.businessmethods.SFDC_Utility;


public class TC_SalesForce extends TC_Base{

	@Test(priority=2,dataProvider="dataP", dataProviderClass=SFDC_DataProvider.class)
	public void Test_Sales_Force(String testCaseName,String phone,String white,String opportunity,String industry,String address1,String city,String state,String zip,String country,String sector,String segment,String belongsto,String currentSupplier,String primaryCompet,String state1,String username,String password,String linkName,String verify)
	{
		log.info("------test case: Test_Sales_Force started-----");
		logger=report.startTest(testCaseName);
		SFDC_Utility.loginToSalesForce(username, password, testCaseName);
		SFDC_Utility.leadDetails(linkName,testCaseName);
		SFDC_Utility.convertAndFillDetails(phone, white, opportunity, industry, address1, city,state, zip, country, sector, segment, belongsto, primaryCompet,currentSupplier,  state1, verify,testCaseName);		
		
	}
}
