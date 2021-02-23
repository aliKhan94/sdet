package seleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity5 {
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
	
	
	@DataProvider (name="Authentication")
	public static Object[][] credentials() {
		return new Object[][] {{"admin", "pa$$w0rd"}};
	}
	
	
	@Test(dataProvider = "Authentication")
	public void navigationMenuColorTestCase(String username, String password) {
		//find username and password field
		WebElement usernameField = driver.findElement(By.id("user_name"));
		Reporter.log("Username field found |");

		WebElement passwordField = driver.findElement(By.id("username_password"));
		Reporter.log("Password field found |");

		//Enter values
		usernameField.sendKeys(username);
		Reporter.log("username entered");

		passwordField.sendKeys(password);
		Reporter.log("Password entered");

		//find and click login button
		driver.findElement(By.id("bigbutton")).click();
		Reporter.log("login button clicked");


		//verify home page
		String dashboardText = driver.findElement(By.id("tab0")).getText();
		Assert.assertEquals(dashboardText, "SUITECRM DASHBOARD");
		Reporter.log("Logged in to home page");

		//get navigation menu bar color
		String navigationMenuBarColor = driver.findElement(By.id("toolbar")).getCssValue("color");
		Reporter.log("Navigation menu bar color is: " + navigationMenuBarColor + " |", true);
	}


	@AfterClass
	public void afterClass() {
		Reporter.log("End of Test |", true);
		//close browser
		driver.close();
	}

}
