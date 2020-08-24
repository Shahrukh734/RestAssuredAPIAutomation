package com.wipro.sfdc.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.wipro.sfdc.test.TC_Base;



/**
 * Provides the functionality to check whether an element is present or not.
 * @return "true" or "false"
 */
public class SFDC_General_Utility extends TC_Base{
	public static Logger log=Log4jUtil.getLogger("sfdc_Util");



	//For clicking any web element

	// Waiting 30 seconds for an element to be present on the page, checking	 
	// for its presence once every 5 seconds.

	static WebDriverWait wait =new WebDriverWait(driver, 100);


	public static WebElement findElementBox(By by, String testCaseName){
		WebElement we=null;
		try{

			we=driver.findElement(by);
			WaitUtility.fluentWait(we);
			//loggingAndReporting(true, testCaseName, we.getText()+" Element found on page");
			log.info(we.getText()+" Element found on page");

		}
		catch(Exception e){
			//loggingAndReporting(true, testCaseName, "Element not found on page - identified by "+by.toString());
			log.info("Element not found on page - identified by "+by.toString()+e.getMessage());

		}
		return driver.findElement(by);

	}


	/**
	 * Provides the functionality to find an element.
	 * @param testCaseName 
	 * @return "WebElement"
	 */
	public static WebElement findElement(By by, String testCaseName){
		WebElement we=null;
		try{	
			we=driver.findElement(by);
			
				WaitUtility.fluentWait(we);
			
			//loggingAndReporting(true, testCaseName, we.getText()+" Element found on page");
			log.info(we.getText()+" Element found on page");
			

		}
		catch(Exception e)
		{
			//loggingAndReporting(true, testCaseName, "Element not found on page - identified by "+by.toString());
			log.info("Element not found on page - identified by "+by.toString()+e.getMessage());
			
		}


		return we;

	}
	/**
	 * Provides the functionality to wait and find a no of elements and store them in a list.
	 * @param testCaseName 
	 * @return "List"
	 */
	public static List<WebElement> findElements(By by, String testCaseName){
		List<WebElement> listOfElements=new ArrayList<>();
		try{
			WaitUtility.explicitlyWaitForElementsPresence(10, by);
			
			listOfElements= driver.findElements(by);
			//loggingAndReporting(true, testCaseName, listOfElements.size()+" number of Elements found in List");

		}
		catch(Exception e)
		{
			//loggingAndReporting(false, testCaseName, "NO Elements found in List identified by "+by.toString());

		}
		return listOfElements;
	}
	/**
	 * Provides the functionality to find and click an element.
	 * @param testCaseName 
	 * @return "void"
	 */

	public static void clickElement(By by, String testCaseName){
		WebElement we=null;
		try{
		WaitUtility.explicitlyWaitToClick(property.getEleMinTimeOut(), by);
		we=findElement(by, testCaseName);
		we.click();
		loggingAndReporting(true, testCaseName," Button clicked");
		}catch(Exception e){
		
			loggingAndReporting(true, testCaseName, "Unable to click Element identified by "+by.toString());

		}
	}

	/**
	 * Provides the functionality to take a screenshot and store it at some designated place.
	 * @return "path where screenshots are stored"
	 */
	public static String takeScreenshot(WebDriver driver,String nameOfOutputFileIncludingExtension)  {
		File scrFile = null;
		File destination = null;
		try {
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			destination = new File("ExtentReports/screenshots/" + nameOfOutputFileIncludingExtension+".jpg");


			FileUtils.copyFile(scrFile, destination);
		} catch (Exception e) {
			log.info("Unable to capture Screenshot in  takeScreenshot()"+e.getMessage());

		}
		return destination.getAbsolutePath();
	}


	/**
	 * provides functionality for adding screenshots to the extentReport output file 
	 * @return "Image Name"
	 */

	public static int i=0;
	public static String takeShot(String testCaseName)
	{String screenshot_path="";
	String image="";
	try{
	
		screenshot_path=SFDC_General_Utility.takeScreenshot(driver, testCaseName+i);
		image=logger.addScreenCapture(screenshot_path);
		i++;


	}catch(Exception e){
		log.info("Unable to capture Screenshot in takeShot()"+e.getMessage());
	}

	return image;

	}



	/**
	 * provides functionality to enter values in a WebElement before waiting it to become clickable. 
	 * @param passMsg 
	 * @param failMsg 
	 * @param testCaseName 
	 * @return "void"
	 */

	public static void sendKeyElement(By by, Keys enter, String passMsg, String failMsg, String testCaseName) {
		try{
			log.info("-----sendKeyElement() started-----");
			WaitUtility.explicitlyWaitToClick(property.getEleMaxTimeOut(), by);
			WebElement we=findElement(by, testCaseName);
			we.sendKeys(enter);
			loggingAndReporting(true, testCaseName,passMsg);


		}
		catch(Exception e){
			loggingAndReporting(false, testCaseName,failMsg);

		}


	}


	/**
	 * provides functionality to check the assert whether it fails or pass. 
	 * @return "void"
	 */

	public static void assertCheckEqual(String expected,String actual,String testCaseName ,String passMsg,String failMsg){
		log.info("-----assertCheck() started-----");
		try{
			Assert.assertEquals(expected, actual);
			loggingAndReporting(true, testCaseName,passMsg);

		}
		catch(Exception e)
		{
			loggingAndReporting(false, testCaseName,failMsg);



		}
	}


	/**
	 * provides functionality to check the assert whether it fails or pass. 
	 * @return "void"
	 */

	public static void assertCheckTrue(Boolean expectedCondition,String testCaseName ,String passMsg,String failMsg){
		log.info("-----assertCheck() started-----");
		try{
			Assert.assertTrue(expectedCondition);
			loggingAndReporting(true, testCaseName,passMsg);

		}
		catch(Exception e)
		{
			loggingAndReporting(false, testCaseName,failMsg);

		}
	}

	public static String createTimeStamp(String string, String testCaseName) {
		SimpleDateFormat sdFormat=null;
		try{
			sdFormat=new SimpleDateFormat(string);
			loggingAndReporting(true, testCaseName, "Timestamp creation passed");

		}
		catch(Exception e){
			loggingAndReporting(false, testCaseName,"Timestamp creation failed");

		}
		return sdFormat.format(new Date());

	}

	public static void navigateToUrl(String url, String testCaseName) {
		try{
			driver.navigate().to(url);
			loggingAndReporting(true, testCaseName, url+" opened");

		}
		catch(Exception e){
			loggingAndReporting(false, testCaseName,url+" open failed");

		}
	}

	public static void openUrl(String url, String testCaseName) {
		try{
			driver.get(url);
			loggingAndReporting(true, testCaseName, url+" opened");

		}
		catch(Exception e){
			loggingAndReporting(false, testCaseName,url+" open failed");

		}

	}

	public static void selectFromDropDownByVisibleText(WebElement dropdownElement, String option,String passMessage,String failMessage,String testCaseName) {
		try{
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(option);
			loggingAndReporting(true, testCaseName, passMessage);

		}
		catch(Exception e){
			loggingAndReporting(false, testCaseName,failMessage);


		}
	}

	public static void loggingAndReporting(boolean passFailStatus,String testCaseName ,String message)
	{

		if(passFailStatus){
			logger.log(LogStatus.PASS,message,takeShot(testCaseName));
			log.info(message);
		}
		else{
			logger.log(LogStatus.FAIL,message,takeShot(testCaseName));
			log.info(message);
		}
	}




}
