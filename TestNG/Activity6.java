package testNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;


public class Activity6 {
	WebDriver driver;
	
	@Parameters ( {"username", "password"} )
	@Test
	public void loginTest(String username, String password) {
		WebElement usernameInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
		
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
		
		String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
		
		Assert.assertEquals(loginMessage, "Welcome Back, admin");
	}
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
