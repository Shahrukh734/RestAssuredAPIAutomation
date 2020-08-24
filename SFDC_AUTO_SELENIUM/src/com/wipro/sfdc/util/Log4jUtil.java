package com.wipro.sfdc.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jUtil {
	public static Logger log=null;
	public static PropertyUtil property=null;
	
	
	public static Logger getLogger(String className){
		property=new PropertyUtil();
		PropertyConfigurator.configure(property.getLog4jFilePath());
		log=Logger.getLogger(className);
		return log;
	}
}
