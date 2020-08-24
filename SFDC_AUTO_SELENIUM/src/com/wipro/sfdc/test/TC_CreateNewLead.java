package com.wipro.sfdc.test;

import org.testng.annotations.Test;

import com.wipro.sfdc.businessmethods.SFDC_Utility;

public class TC_CreateNewLead extends TC_Base {
	
	
	@Test(priority=1,dataProvider="createNewLead",dataProviderClass=SFDC_DataProvider.class)
	public void Create_New_Lead(String salesforceUsername,String salesforcePassword,String testCaseName,String LastName,String CompanyName)
	{
		
		log.info("------test case: createNewLead started-----");
		logger=report.startTest(testCaseName);
		SFDC_Utility.loginTestSalesForce(salesforceUsername, salesforcePassword,testCaseName);
		SFDC_Utility.newLead(LastName,CompanyName,testCaseName);
		
		
	}
}
