package testNGTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		//create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.training-support.net");
	}

	@Test
	public void exampleTestCase() {
		String title = driver.getTitle();
		System.out.println("Page tile is: " + title);
		Assert.assertEquals(title, "Training Support");
		driver.findElement(By.id("about-link")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='About Us']")));

		title = driver.getTitle();
		System.out.println("Page tile is: " + title);
		Assert.assertEquals(title, "About Training Support");

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
