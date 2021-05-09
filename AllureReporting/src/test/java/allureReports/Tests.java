package allureReports;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.SkipException;


public class Tests {

	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
//		//no need to set the path the chrome driver path by using webDrivermanager 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
//		BaseClass bs = new BaseClass();
//		bs.initialize_driver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	}
	
	
	@Test(priority=1)
	public void logoPresence()
	{
		boolean displayStatus = driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
		Assert.assertEquals(displayStatus, true);
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("shahrukh.victor@gmail.com");
		driver.findElement(By.xpath("//label[text()='Password:']/following-sibling::input")).sendKeys("October*14");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store12");
		
		
	}
	
	@Test(priority=3)
	public void registerationTest()
	{
		throw new SkipException("Skipping the test");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
