package com.wipro.sfdc.util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.sfdc.test.TC_Base;






public class WaitUtility extends TC_Base {
	public static Logger log=Log4jUtil.getLogger("WaitUtility");


	public static void explicitlyWaitForElementsPresence(int time,By by)
	{
		log.info("-----Explicitly Wait For Elements Presence-----");
	WebDriverWait wait=new WebDriverWait(driver, time);
	driver.manage().timeouts().pageLoadTimeout(property.getEleMaxTimeOut(), TimeUnit.SECONDS);
	try{
	wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
	
	}
	catch(Exception e){
		System.out.println(by.toString());
		
	}


	
	}
	public static void explicitlyWaitToClick(int time,By by)
	{
		log.info("-----Explicitly Wait To Click-----");
	WebDriverWait wait=new WebDriverWait(driver, time);
	WebElement ele=driver.findElement(by);
	fluentWait(ele);
	wait.until(ExpectedConditions.presenceOfElementLocated(by));
	wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//	wait.until(ExpectedConditions.elementToBeClickable(SapFiori_Util.findElement(by)));

	
}
	
	
	
	
	public static void fluentWait(WebElement we)
	{
		log.info("-----Fluently Waiting-----");
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(property.getEleMaxTimeOut(), TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	//wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(we)));
    wait.until(ExpectedConditions.elementToBeClickable(we));
    
	}
	
	
	
	
}
