package testNGTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
  @Test
  public void loginTest() {
	  WebElement username = driver.findElement(By.id("username"));
	  WebElement password = driver.findElement(By.id("password"));
	  WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
	  
	  username.sendKeys("admin");
	  password.sendKeys("password");
	  loginButton.click();
	  
	  String confirmationMessage = driver.findElement(By.id("action-confirmation")).getText();
	  Assert.assertEquals(confirmationMessage, "Welcome Back, admin");
	  
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
