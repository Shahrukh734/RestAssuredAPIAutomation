
package com.wipro.sfdc.businessmethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.wipro.sfdc.test.TC_Base;
import com.wipro.sfdc.ui.SFDC_UI;
import com.wipro.sfdc.util.SFDC_General_Utility;

public class Testsalesforce_PageObject extends TC_Base{

	public static WebElement element;
	public static void fillUsername(String username, String testCaseName)
	{
		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.salesforce_username),testCaseName).sendKeys(username);
	}
	
	
	public static void fillPassword(String password, String testCaseName)
	{
		SFDC_General_Utility.findElement(By.xpath(SFDC_UI.salesforce_password),testCaseName).sendKeys(password);
		
	}
	
	public static void doLogin(String testCaseName)
	{
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.loginSandBox),testCaseName);
		
	}
	
	public static void doLead(String testCaseName)
	{
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.lead),testCaseName);
		
	}
	
	public static WebElement view(String testCaseName)
	{
		element=SFDC_General_Utility.findElement(By.xpath(SFDC_UI.view),testCaseName);
		return element;
	}
	
	 public static WebElement tableList(String testCaseName)
	 {	    	
	    	element=SFDC_General_Utility.findElement(By.xpath(SFDC_UI.table),testCaseName);
	    	return element;
	 }
	 
	 public static void doconvert(String testCaseName)
	 {
		SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.convert),testCaseName);
			
	 }
	 
	 public static void fillPhone(String phone, String testCaseName)
	 {
			SFDC_General_Utility.findElement(By.xpath(SFDC_UI.phone),testCaseName).sendKeys(phone);
			
	 }
	 
	 public static void fillWhite(String white, String testCaseName)
	 {
			SFDC_General_Utility.findElement(By.xpath(SFDC_UI.White),testCaseName).sendKeys(white);
			
	 }
	 
	 public static void fillOppertunity(String oppertunity, String testCaseName)
	 {
			SFDC_General_Utility.findElement(By.xpath(SFDC_UI.oppertunity),testCaseName).sendKeys(oppertunity);
			
	 }
	public static WebElement selectIndustry(String dropValue)
	 {
		 element=driver.findElement(By.xpath(SFDC_UI.industry));
		 Select dropDown=new Select(element);
		 dropDown.selectByVisibleText(dropValue);
		 return element;
	 }
	 public static void fillAddress1(String address, String testCaseName)
	 {
			SFDC_General_Utility.findElement(By.xpath(SFDC_UI.address1),testCaseName).sendKeys(address);
			
	 }
	 
	 public static void fillCity(String city, String testCaseName)
	 {
			SFDC_General_Utility.findElement(By.xpath(SFDC_UI.city),testCaseName).sendKeys(city);
			
	 }
	
	 public static WebElement fillPrimaryCompet(String pComp)
	 {
			element=driver.findElement(By.xpath(SFDC_UI.primaryCompetitor));
			element.clear();
			element.sendKeys(pComp);
			return element;
			
	 }
	
	 public static WebElement selectState(String dropValue)
	 {
			element=driver.findElement(By.xpath(SFDC_UI.state));
			 Select dropDown=new Select(element);
			 dropDown.selectByVisibleText(dropValue);
			return element;
	 }
	 
	 public static WebElement fillZip(String zip)
	 {
			element=driver.findElement(By.xpath(SFDC_UI.zip));
			element.sendKeys(zip);
			return element;
	 }
	 
	 public static WebElement selectCountry(String dropValue)
	 {
			element=driver.findElement(By.xpath(SFDC_UI.country));
			 Select dropDown=new Select(element);
			 dropDown.selectByVisibleText(dropValue);
			return element;
	 }
	 
	 public static WebElement selectSector(String dropValue)
	 {
			element=driver.findElement(By.xpath(SFDC_UI.sector));
			 Select dropDown=new Select(element);
			 dropDown.selectByVisibleText(dropValue);
			return element;
	 } 
	 
	 public static WebElement selectSegment(String dropValue)
	 {
			element=driver.findElement(By.xpath(SFDC_UI.segment));
			 Select dropDown=new Select(element);
			 dropDown.selectByVisibleText(dropValue);
			return element;
	 }
	 
	 public static WebElement selecBelongsto(String dropValue)
	 {
			element=driver.findElement(By.xpath(SFDC_UI.belongsTo));
			 Select dropDown=new Select(element);
			 dropDown.selectByVisibleText(dropValue);
			return element;
	 }
	 public static WebElement selecCurrentSupplier(String dropValue)
	 {
			element=driver.findElement(By.xpath(SFDC_UI.currentSupplier));
			 Select dropDown=new Select(element);
			 dropDown.selectByVisibleText(dropValue);
			return element;
	 }
	 
	 public static void doconvertAfter(String testCaseName)
	 {
			SFDC_General_Utility.clickElement(By.xpath(SFDC_UI.convertAfter),testCaseName);
			
	}
	 
}
