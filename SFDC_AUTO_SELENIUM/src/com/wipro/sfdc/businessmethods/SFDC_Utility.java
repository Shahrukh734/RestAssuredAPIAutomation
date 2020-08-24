package com.wipro.sfdc.businessmethods;

import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;
import com.wipro.sfdc.test.TC_Base;
import com.wipro.sfdc.ui.SFDC_UI;
import com.wipro.sfdc.util.Log4jUtil;
import com.wipro.sfdc.util.SFDC_General_Utility;



public class SFDC_Utility extends TC_Base {

	public static Logger log=Log4jUtil.getLogger("sfdc_Gen_Utils");


	public static void loginOfficeDepot(String username,String password,String testCaseName){
		log.info("-------inside login--------");
		SFDC_General_Utility.openUrl(property.getURL(),testCaseName);
		log.info("url opened");
		


		logger.log(LogStatus.INFO, "Login started", SFDC_General_Utility.takeShot(testCaseName));


		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.username),testCaseName).sendKeys(username);
		log.info("username entered");
		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.password),testCaseName).sendKeys(password);
		log.info("password entered");
		logger.log(LogStatus.INFO, "Username and Password entered", SFDC_General_Utility.takeShot(testCaseName));


		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.login),testCaseName);
		log.info("login button clicked");
		log.info("--------login finished----------");
		logger.log(LogStatus.PASS, "Logged In", SFDC_General_Utility.takeShot(testCaseName));
	}

	public static void navigateToTestSalesForce(String salesforceUsername,String salesforcePassword,String testCaseName)
	{
		log.info("-------inside navigateToTestSalesForce--------");
		logger.log(LogStatus.INFO, "Navigating to Test Sales Force", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.navigateToUrl("https://test.salesforce.com",testCaseName);

		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.salesforce_username),testCaseName).sendKeys(salesforceUsername);
		log.info("username entered");
		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.salesforce_password),testCaseName).sendKeys(salesforcePassword);
		log.info("password entered");
		logger.log(LogStatus.INFO, "Username and Password entered", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.salesforce_login),testCaseName);
		log.info("login button clicked");
		logger.log(LogStatus.PASS, "Logged In", SFDC_General_Utility.takeShot(testCaseName));
	}

	public static void loginTestSalesForce(String salesforceUsername,String salesforcePassword,String testCaseName)
	{
		log.info("-------inside loginTestSalesForce--------");
		logger.log(LogStatus.INFO, "loginTestSalesForce", SFDC_General_Utility.takeShot(testCaseName));
		SFDC_General_Utility.openUrl(property.getURL1(),testCaseName);
		log.info("TestSalesForce url opened");
		logger.log(LogStatus.INFO, "Url Opened", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.salesforce_username),testCaseName).sendKeys(salesforceUsername);
		log.info("TestSalesForce username entered");
		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.salesforce_password),testCaseName).sendKeys(salesforcePassword);
		log.info("TestSalesForce password entered");
		logger.log(LogStatus.PASS, "Username and Password entered", SFDC_General_Utility.takeShot(testCaseName));

	
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.salesforce_login),testCaseName);
		
		log.info("login button clicked");
		log.info("--------login finished----------");
		logger.log(LogStatus.PASS, "Logging in TestSalesForce", SFDC_General_Utility.takeShot(testCaseName));

	}

	public static void fillData(String itemNumber,String quantity,String quotename,String msg,String testCaseName)
	{


		log.info("------inside fillData------");
		logger.log(LogStatus.INFO, "Home Page Opened", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.findElementBox(By.xpath(SFDC_UI.itemNumber),testCaseName).sendKeys(itemNumber);
		log.info("item number passed");
		SFDC_General_Utility.findElementBox(By.xpath(SFDC_UI.quantity),testCaseName).sendKeys(quantity);
		log.info("quantity passed");
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.addToCart),testCaseName);
		logger.log(LogStatus.PASS, "Add to cart Done", SFDC_General_Utility.takeShot(testCaseName));

		log.info("add to cart button is clicked");
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.shoppingCart),testCaseName);
		logger.log(LogStatus.PASS, "Shopping cart in Progress", SFDC_General_Utility.takeShot(testCaseName));

		log.info("shopping cart button is  clicked");
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.volumePricing),testCaseName);
		logger.log(LogStatus.PASS, "Volume Pricing in Progress", SFDC_General_Utility.takeShot(testCaseName));

		log.info("request volume pricing is clicked");
		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.quotename),testCaseName).sendKeys(quotename);
		log.info("quote name is passed");
		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.msg),testCaseName).sendKeys(msg);
		log.info("quote msg is passed");
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.submitQuote),testCaseName);
		logger.log(LogStatus.PASS, "Quote submission in Progress", SFDC_General_Utility.takeShot(testCaseName));

		log.info("submit quote button is clicked");
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.logout),testCaseName);
		logger.log(LogStatus.PASS, "FillData Completed and Logged out", SFDC_General_Utility.takeShot(testCaseName));
	}

	public static void newLead(String LastName,String CompanyName,String testCaseName)
	{
		log.info("-------inside newLead--------");
		logger.log(LogStatus.INFO, "New Lead Creation method", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.LeadsTab),testCaseName);
		log.info("clicked on leads tab");
		logger.log(LogStatus.PASS, "Leads Tab clicked", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.newButton),testCaseName);
		log.info("clicked on new button");
		logger.log(LogStatus.PASS, "New Lead Create options", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.continueButton),testCaseName);
		log.info("clicked on continue button");
		logger.log(LogStatus.PASS, "Continue creation", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.findElementBox(By.xpath(SFDC_UI.lastName),testCaseName).sendKeys(LastName);
		log.info("LastName Passed");
		SFDC_General_Utility.findElementBox(By.xpath(SFDC_UI.companyName),testCaseName).sendKeys(CompanyName);
		log.info("CompanyName Passed");
		logger.log(LogStatus.PASS, "Last name and company filled", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.saveButton),testCaseName);
		log.info("SaveButton clicked");
		logger.log(LogStatus.INFO, "New Lead saved", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.homeTab),testCaseName);
		log.info("HomeTab clicked");
		logger.log(LogStatus.INFO, "Go to Home Page", SFDC_General_Utility.takeShot(testCaseName));

		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.LeadsTab),testCaseName);
		log.info("LeadsTab clicked");
		logger.log(LogStatus.INFO, "Leads shown", SFDC_General_Utility.takeShot(testCaseName));


		List<WebElement> listOfDiv=SFDC_General_Utility.findElements(By.xpath(SFDC_UI.tableValues),testCaseName);	
		int f=0;
		for(int i = 2 ; i<=listOfDiv.size();i++){
			String lastName= SFDC_UI.tableValues + "[" + i +"]" + "//th[" + 1 +"]" ;
			if(SFDC_General_Utility.findElementBox(By.xpath(lastName),testCaseName).getText().equalsIgnoreCase(LastName)){
				log.info("validated if added lead  exists or not");
				SFDC_General_Utility.assertCheckEqual("true", "true", testCaseName, "Lead is found", "Lead is not there in list");
				f=1;
				break;
			}
		}
		if(f==0){
			SFDC_General_Utility.assertCheckEqual("true", "false", testCaseName, "Lead is found", "Lead is not there in list");

			

		}
		
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.userTab),testCaseName);
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.sfdcLogout),testCaseName);
	}

	public static void verifyQuoteNameAndLogout(String quotename, String timeStamp, String testCaseName) {
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.opportunitiesTab),testCaseName);
		WebElement newQuote=driver.findElement(By.xpath(SFDC_UI.newTechQ));
		SFDC_General_Utility.selectFromDropDownByVisibleText(newQuote,"New Tech Quotes","New Tech quotes selection success","New Tech quotes selection fail",testCaseName);
		
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.goButton),testCaseName);
		logger.log(LogStatus.PASS, "New Tech Quotes on Screen", SFDC_General_Utility.takeShot(testCaseName));
		List<WebElement> oppList=SFDC_General_Utility.findElements(By.xpath(SFDC_UI.opportunityName),testCaseName);

		Iterator<WebElement> i=oppList.iterator();
		int f=0;
		while(i.hasNext()){
			WebElement opp=i.next();
			
			if(opp.getText().equalsIgnoreCase(quotename+timeStamp+" Quote Request")){
				SFDC_General_Utility.assertCheckTrue(true, testCaseName, "Validation success-BSD QUOTE REQUEST", "Validation failed-BSD QUOTE REQUEST");

			f=1;
				break;
			}
		}
		if(f==0){
			SFDC_General_Utility.assertCheckTrue(false, testCaseName, "Validation success-BSD QUOTE REQUEST", "Validation failed-BSD QUOTE REQUEST");


		}
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.userTab),testCaseName);
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.sfdcLogout),testCaseName);
		logger.log(LogStatus.PASS, "success Logout", SFDC_General_Utility.takeShot(testCaseName));

	}
    /**
     This function is used to login TestSalesForce.com by passing the credentials that
     is username and password. 
    */
	public static void loginToSalesForce(String username, String password, String testCaseName) {
		SFDC_General_Utility.openUrl(property.getURL1(),testCaseName);
		logger.log(LogStatus.INFO, "Sales force url opening", SFDC_General_Utility.takeShot(testCaseName));

		Testsalesforce_PageObject.fillUsername(username,testCaseName);
		Testsalesforce_PageObject.fillPassword(password,testCaseName);
		logger.log(LogStatus.PASS, "Username Password filled", SFDC_General_Utility.takeShot(testCaseName));

		Testsalesforce_PageObject.doLogin(testCaseName);
		logger.log(LogStatus.PASS, "Sales force logged in", SFDC_General_Utility.takeShot(testCaseName));


	}

	/**
    This function is used to click lead tab and then it is clicking link in the table.
   */
	public static void leadDetails(String linkName, String testCaseName) {
		Testsalesforce_PageObject.doLead(testCaseName);
		logger.log(LogStatus.PASS, "Show Leads", SFDC_General_Utility.takeShot(testCaseName));

		for(int i = 2 ; i<=SFDC_General_Utility.findElements(By.xpath(SFDC_UI.table),testCaseName).size();i++){
			String name= SFDC_UI.table + "[" + i +"]" + "//th[" + 1 +"]" ;
			if(SFDC_General_Utility.findElement(By.xpath(name),testCaseName).getText().equalsIgnoreCase(linkName)){

				SFDC_General_Utility.clickElement((By.xpath(name+"//a")),testCaseName);
				logger.log(LogStatus.PASS, "Lead Clicked", SFDC_General_Utility.takeShot(testCaseName));

				break;

			}

		}		
	}

	/**
     This function is used to click the convert button and then filling the values in the fields
     and thereafter it is clicking on the convert button and after that it is validating.
   */
	public static void convertAndFillDetails(String phone, String white, String oppertunity, String industry, String address1, String city,String state, String zip, String country, String sector, String segment, String belongsto, String primaryCompet, String currentSupplier,  String state1, String verify, String testCaseName) {
		Testsalesforce_PageObject.doconvert(testCaseName);
		logger.log(LogStatus.PASS, "Filling Lead details", SFDC_General_Utility.takeShot(testCaseName));

		Testsalesforce_PageObject.fillPhone(phone,testCaseName);
		Testsalesforce_PageObject.fillWhite(white,testCaseName);
		Testsalesforce_PageObject.fillOppertunity(oppertunity,testCaseName);
		Testsalesforce_PageObject.selectIndustry(industry);
		Testsalesforce_PageObject.fillAddress1(address1,testCaseName);
		Testsalesforce_PageObject.fillCity(city,testCaseName);
		Testsalesforce_PageObject.fillZip(zip);
		Testsalesforce_PageObject.selectCountry(country);
		Testsalesforce_PageObject.selectSector(sector);
		Testsalesforce_PageObject.selectSegment(segment);
		Testsalesforce_PageObject.selecBelongsto(belongsto);
		Testsalesforce_PageObject.fillPrimaryCompet(primaryCompet);
		Testsalesforce_PageObject.selecCurrentSupplier(currentSupplier);
		Testsalesforce_PageObject.selectState(state1);
		
		logger.log(LogStatus.PASS, "Details Filled", SFDC_General_Utility.takeShot(testCaseName));

		Testsalesforce_PageObject.doconvertAfter(testCaseName);
		SFDC_General_Utility.assertCheckTrue(SFDC_General_Utility.findElement(By.xpath(SFDC_UI.verifyRecord),testCaseName).getText().equalsIgnoreCase(verify), testCaseName,  "Record verified",  "Record verification failed");
		
		


	}





}


