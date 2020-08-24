package com.wipro.sfdc.test;

import org.testng.annotations.Test;
import com.wipro.sfdc.businessmethods.SFDC_Utility;
import com.wipro.sfdc.util.SFDC_General_Utility;

public class TC_BSDQuoteRequest extends TC_Base{

	@Test(priority=0,dataProvider="bsdQuoteRequest",dataProviderClass=SFDC_DataProvider.class)
	public void BSD_Quote_Request(String username,String password,String testCaseName,String itemNumber,String quantity,String quotename,String msg,String salesforceUsername,String salesforcePassword)
	{
		
		log.info("------test case: bsdQuoteRequest started-----");
		logger=report.startTest(testCaseName);
		SFDC_Utility.loginOfficeDepot(username,password,testCaseName);
		String timeStamp=SFDC_General_Utility.createTimeStamp("dd/MMM/yyyy/hh/mm/ss",testCaseName);
		SFDC_Utility.fillData(itemNumber,quantity,quotename+timeStamp,msg,testCaseName);
		SFDC_Utility.navigateToTestSalesForce(salesforceUsername, salesforcePassword,testCaseName);
		SFDC_Utility.verifyQuoteNameAndLogout(quotename, timeStamp, testCaseName);
	
	}


















}
