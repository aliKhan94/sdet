package testNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriver driver;
	
	@Test
	public void firstTestMethod() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Target Practice");
		System.out.println("Page Title: " + title);	
	}
	
	@Test
	public void secondTestMethod() {
		WebElement blackButton = driver.findElement(By.className("black"));
		Assert.assertFalse(blackButton.isDisplayed());
	}
	
	@Test(enabled = false)
	public void thirdTestMethod() {
		System.out.println("This method will skipped but won't shown in report");
	}
	
	@Test
	public void fourthTestMethod() {
		throw new SkipException("This method will be skipped");
		
	}
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/target-practice");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
