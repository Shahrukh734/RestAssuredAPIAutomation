package com.wipro.sfdc.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyUtil {
	public static Logger log=Log4jUtil.getLogger("PropertyUtil");

	
	Properties rb=null;
	
	
	public PropertyUtil() {


		rb=new Properties();
		try {
			rb.load(new FileInputStream(new File(".\\resources\\config.properties")));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		

		
	}
	/**
	* provides functionality for getting url from config.properties 
	  * @return "url"
	 */
	public String getURL(){
		 
		
		return rb.getProperty("url");
	}
public String getURL1(){
		 
		
		return rb.getProperty("url1");
	}
	/**
	* provides functionality for getting browser Name from config.properties 
	  * @return "browserName"
	 */
	public String getBrowserName(){
		return rb.getProperty("browser");
	}
	/**
	* provides functionality for getting log4j filepath from config.properties 
	  * @return "log4jFilePath"
	 */
	public String getLog4jFilePath(){
		 return rb.getProperty("log4jFilepath");
	}
	/**
	* provides functionality for getting destination address for output of the report
	*  from config.properties 
	 */
	public String getHtmlReport(){
		 return rb.getProperty("htmlreport");
	}
	/**
	* provides functionality for getting extentReport configuration filepath from config.properties 
	 */
	public String getExtentReportConfigFilePath(){
		 return rb.getProperty("extentReportConfig");
	}
	/**
	* provides functionality for giving a minimum timeout value  
	  * @return "minimumTimeoutValue"
	 */
	public int getEleMinTimeOut(){
		 String temp=rb.getProperty("eleMinTimeOut");
		 return Integer.parseInt(temp);
	}
	/**
	* provides functionality for giving a minimum timeout value  
	  * @return "minimumTimeoutValue"
	 */
	public int getwaitTime(){
		 String temp=rb.getProperty("waitTime");
		 return Integer.parseInt(temp);
	}
	/**
	* provides functionality for giving a maximum timeout value  
	  * @return "minimumTimeoutValue"
	 */
	public int getEleMaxTimeOut(){
		 String temp= rb.getProperty("eleMaxTimeOut");
		 return Integer.parseInt(temp);
	}
	/**
	* provides functionality for getting path for saving screenshots for extentReports  
	  * @return "minimumTimeoutValue"
	 */
	public String getextentReportScreenshotsLocation(){
		 return rb.getProperty("extentReportScreenshotsLocation");
	}
	
	
}
