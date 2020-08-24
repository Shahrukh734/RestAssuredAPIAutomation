package com.wipro.sfdc.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import com.wipro.sfdc.util.Log4jUtil;
import com.wipro.sfdc.util.PropertyUtil;
import com.wipro.sfdc.util.SFDC_General_Utility;

public class TC_Base{
	
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger; 
	public static PropertyUtil property=new PropertyUtil();
	public static Logger log=Log4jUtil.getLogger("TC_base");
	static{
	report=new ExtentReports(property.getHtmlReport(),NetworkMode.OFFLINE);
	report.loadConfig(new File(property.getExtentReportConfigFilePath()));
	}
	static String browser="";
	
	public static String getBrowser() {
		return browser;
	}


	@BeforeMethod
	public void initBrowser(){
		log.info("  -------initBrowser() method started-----");
		browser=property.getBrowserName();
		if(browser.equalsIgnoreCase("firefox")){
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("profile");       
			log.info("profile created");
			driver = new FirefoxDriver(ffprofile);
		}
		else if(browser.equalsIgnoreCase("chrome")){
			File file = new File(".\\BrowserDrivers\\ChromeDriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
			File file = new File(".\\BrowserDrivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			System.out.println(file.getAbsolutePath());
			driver = new InternetExplorerDriver();
		}
		
		log.info("driver initialized");
		driver.manage().window().maximize();
		log.info("window maximized");
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(property.getEleMinTimeOut(), TimeUnit.SECONDS);
		log.info("exiting initBrowser() method");
	}
	

	/**This method runs after each @Test method
	 * Provides the functionality to add a screenshot and close the browser.
	 * @return "void"
	 */
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		log.info("inside tearDown method");
		String screenshot_path=null;
		String image= null;
		try{
			screenshot_path=SFDC_General_Utility.takeScreenshot(driver, result.getName());
			image= logger.addScreenCapture(screenshot_path);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		
		if(result.getStatus()==ITestResult.SUCCESS){
		logger.log(LogStatus.PASS, result.getName(), image);
		}
		else if(result.getStatus()==ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, result.getName(), image);

		}
		else if(result.getStatus()==ITestResult.SKIP){
			logger.log(LogStatus.SKIP, result.getName());

		}
		report.endTest(logger);
		log.info("extent report endTest() method completed");
		SFDC_General_Utility.i=0;
		driver.manage().deleteAllCookies();
		driver.close();
		log.info("driver closed");
	}
	/**This method runs after suite is completed.
	 * Provides the functionality to close the report.
	 * @return "void"
	 */
	@AfterSuite
	public void flushReport()
	{
		log.info("inside flushReport() method");
		report.flush();
		log.info("report flushed");
	
	}
	
}
