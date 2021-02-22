package testNGTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		return new Object[][] {{"admin", "password"}, {"testUser2", "password2"}};
	}
	
	@Test (dataProvider = "Authentication")
	public void loginTest(String username, String password) {
		WebElement usernameInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
		
		Assert.assertEquals(loginMessage, "Welcome Back, admin");
	}
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
