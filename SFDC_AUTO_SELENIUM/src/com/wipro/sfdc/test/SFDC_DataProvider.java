package com.wipro.sfdc.test;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import com.wipro.sfdc.util.ExcelUtility;
import com.wipro.sfdc.util.Log4jUtil;
;

public class SFDC_DataProvider {
	public static Logger log=Log4jUtil.getLogger("Data_Provider_sfdc");
	/** Provides the functionality to provide testdata to the case TC_myTimesheet
	 * @return "Object[][]"
	 */
	@DataProvider(name = "bsdQuoteRequest")
	public static Object[][] dataProviderMyTimsheeet() {

		log.info("-----dataProviderbsdQuoteRequest() method started------");
		int noOfRows=1;
		int start=0;
		
		Object[][] obj=new Object[noOfRows][];

		for(int k=start;k<start+noOfRows;k++)
		{
			obj[k]=ExcelUtility.readExcel("bsdQuoteRequest",".\\resources\\validationData.xlsx", k);
		}

		log.info("Object[][] array filled");
		log.info("-----dataProviderbsdQuoteRequest() method finished------");
		return obj;
		
		
	}

	
	@DataProvider(name = "createNewLead")
	public static Object[][] createNewLead() {
		log.info("-----dataProviderbsdQuoteRequest() method started------");
		int noOfRows=1;
		int start=0;
		
		Object[][] obj=new Object[noOfRows][];

		for(int k=start;k<start+noOfRows;k++)
		{
			obj[k]=ExcelUtility.readExcel("createNewLead",".\\resources\\validationData.xlsx", k);
		}

		log.info("Object[][] array filled");
		log.info("-----dataProviderbsdQuoteRequest() method finished------");
		return obj;
		
		
	}
	
	@DataProvider(name="dataP")
	public static Object[][] sfdcData(){
		log.info("-----dataProvidercreatesalesforce() method started------");

		int noOfRows=1;
		int start=0;
		Object[][] obj=new Object[noOfRows][];

		for(int k=start;k<start+noOfRows;k++)
		{
			obj[k]=ExcelUtility.readExcel("testSalesForce", ".\\resources\\validationData.xlsx", k);
		}

		log.info("Object[][] array filled");
		log.info("-----dataProvidercreatesalesforce() method finished------");
		return obj;
	}
	
}
