package seleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		//create a new instance of firefox driver
		driver = new FirefoxDriver();
		
		Reporter.log("Starting Test |", true);
		//open browser
		driver.get("https://alchemy.hguy.co/crm/");
		Reporter.log("Browser opened |");
		
		//wait for page to completely loaded
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Website completely loaded |");
	}
	
	@Test
	public void footerCopyrightTestCase() {
		//get footer copyright text
		String copyrightText = driver.findElement(By.id("admin_options")).getText();
		Reporter.log("Footer copyright text is: " + copyrightText + " |", true);
	}
	

	@AfterClass
	public void afterClass() {
		Reporter.log("End of Test |", true);
		//close browser
		driver.close();
	}

}
