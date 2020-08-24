package com.wipro.sfdc.ui;

public class SFDC_UI {

	//bsd quote request
	
	public static String username="//input[@id='loginNameBsd']";
	public static String password="//input[@id='loginPasswordBsd']";
	public static String login="//input[@type='submit']";
	public static String itemNumber="//input[@class='item' and @type='text']";
	public static String quantity="//input[@class='qty' and @type='text']";
	public static String quickOrder="//div[@id='reorder']/h3";
	public static String addToCart="//input[@type='submit' and @value='Add to Cart']";
	public static String shoppingCart="//a[@id='buttonShoppingCart']";
	public static String volumePricing="//a[@class='btn secondary med_txt auto_width' and contains(text(),'Volume')]";
	public static String quotename="//input[@id='quoteName']";
	public static String msg="//textarea[@id='quoteMsg']";
	public static String submitQuote="//div[@class='iCol1of2']//div[@class='b1']//input[@id='placeQuoteCheckout' and @tabindex='18']";
	public static String logout="//ul[@id='logIn_bsd']/span/a";
	
	//test.salesforce.com
	public static String opportunitiesTab="//li[@id='Opportunity_Tab']/a";
	public static String newTechQ="//select[@id='fcf']";
	public static String newTechQCheck="//*[@id='fcf']//option[contains(text(),'New Tech Quotes')]";
	public static String opportunityName="//div[contains(@id,'OPPORTUNITY_NAME')]//a/span";
	public static String goButton="//form[@id='filter_element']/div/span/span/input";
	
	public static String userTab=".//span[@id='userNavLabel']";
	public static String sfdcLogout=".//div[@id='userNav-menuItems']/a[@title='Logout']";
	
	//create new lead
	public static String salesforce_username="//input[@id='username']";
	public static String salesforce_password="//input[@id='password']";
	public static String salesforce_login="//input[@id='Login']";
	
	public static String LeadsTab="//li[@id='Lead_Tab']/a[@title='Leads Tab']";
	public static String newButton="//form[@id='hotlist']//input";
	public static String continueButton="//td[@id='bottomButtonRow']//input[@name='save']";
	public static String lastName="//div[@class='requiredInput']//input[@id='j_id0:j_id3:j_id30:j_id37:j_id40']";
	public static String companyName="//div[@class='requiredInput']//input[@id='j_id0:j_id3:j_id30:j_id37:j_id39']";
	public static String saveButton=".//td[@id='j_id0:j_id3:j_id30:j_id34:bottom']//input[@value='Save']";
	public static String homeTab="//li[@id='home_Tab']/a";
	
	public static String tableValues="//table[@class='list']//tr";
	

	//salesforce test
	public static String loginSandBox=".//input[@id='Login']";
	
	public static String lead=".//nav//li[@id='Lead_Tab']/a[@title='Leads Tab']";

	public static String view=".//select[@title='View:']";
	public static String table=".//*[@id='bodyCell']//*[@class='pbBody']//table//tr";
	
	
	public static String convert=".//td[@id='topButtonRow']//input[@title='Convert']";
	
	public static String phone=".//input[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id56']";	
	public static String White=".//input[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id57']";
	public static String oppertunity=".//input[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id58']";
	public static String industry=".//select[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id59']";
	public static String address1=".//input[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id61']";
	public static String city=".//input[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id63']";
	public static String state=".//select[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id64']";
	public static String zip=".//input[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id65']";
	public static String country=".//select[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id66']";
	public static String sector=".//select[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id67']";
	public static String segment=".//select[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id68']";
	public static String belongsTo=".//select[@id='page:form:mainPgBlock:buttonrender:oppPgBlockSection:j_id69']";
	public static String currentSupplier=".//label[contains(text(),'Current Supplier')]/parent::th/following-sibling::td//select";
	public static String primaryCompetitor=".//span[@class='lookupInput']//input";
	
	public static String convertAfter=".//td[@id='page:form:mainPgBlock:j_id30:bottom']//input[@value='Convert']";
	
	public static String verifyRecord=".//table[@class='detailList']//td[@class='labelCol' and contains(text(),'Record Type')]/following-sibling::td//div";
		
	
	
}
