package seleniumProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;

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

	@BeforeMethod
	public void beforMethod() {
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
	}

	@DataProvider (name="Authentication")
	public static Object[][] credentials() {
		return new Object[][] {{"admin", "pa$$w0rd"}};
	}


	@Test(dataProvider = "Authentication")
	public void leadsTableTestCase(String username, String password) {
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
		
		//find sales item element
		WebElement salesItem = driver.findElement(By.id("grouptab_0"));
		
		//hover cursor to SALES
		//actions.moveToElement(salesItem).moveToElement(driver.findElement(By.id("moduleTab_9_Leads"))).click().build().perform();
		actions.moveToElement(salesItem).build().perform();
		Reporter.log("Cursor hovered |");
		
		//find Leads element and click
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		Reporter.log("Leads found and clicked |");
		
		//wait to load next page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("list-view-rounded-corners")));
		Reporter.log("Leads table is visible |");
		
		//get row list from table
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr"));
		String name;
		String user;
		for(int i = 1; i<=rows.size(); i++) {
			name = driver.findElement(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr["+i+"]/td[3]")).getText();
			user = driver.findElement(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr["+i+"]/td[8]")).getText();
			
			Reporter.log("name: "+name+"\tuser: "+user+" |", false);
		}
	}


	@AfterClass
	public void afterClass() {
		Reporter.log("End of Test |", true);
		//close browser
		driver.close();
	}

}
