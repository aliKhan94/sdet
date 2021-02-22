package testNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Activity9 {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		Reporter.log("Starting Test |", true);
		
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Reporter.log("Opened Browser |");
		
		Reporter.log("Page title is " + driver.getTitle() + " |");
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("Test Case Setup Started |");
		driver.switchTo().defaultContent();
	}

	@Test
	public void simpleAlertTestCase() {
		Reporter.log("simpleAlertTestCase() Test Case Started |");
		driver.findElement(By.id("simple")).click();
		Reporter.log("Simple Alert Opened |");
		
		Alert simpleAlert = driver.switchTo().alert();
		Reporter.log("Switched focus to alert |");
		
		String simpleAlertMessage = simpleAlert.getText();
		Reporter.log("Alert text is: " + simpleAlertMessage + " |");
		
		Assert.assertEquals(simpleAlertMessage, "This is a JavaScript Alert!");
		
		simpleAlert.accept();
		Reporter.log("Alert closed |");
		
		Reporter.log("Test case ended |");
		
	}
	
	@Test
	public void confirmAlertTestCase() {
		Reporter.log("confirmAlertTestCase() Test Case Started |");
		driver.findElement(By.id("confirm")).click();
		Reporter.log("Confirmation Alert Opened |");
		
		Alert confirmationAlert = driver.switchTo().alert();
		Reporter.log("Focus switched to alert |");
		
		String confirmationAlertMessage = confirmationAlert.getText();
		Reporter.log("Alert test is: " + confirmationAlertMessage + " |");
		
		Assert.assertEquals(confirmationAlertMessage, "This is a JavaScript Confirmation!");
		
		confirmationAlert.accept();
		Reporter.log("Alert Closed |");
		
		Reporter.log("Test case ended |");
	}
	
	@Test
	public void promptAlertTestCase() {
		Reporter.log("promptAlertTestCase() Test Case started |");
		driver.findElement(By.id("prompt")).click();
		
		Alert promptAlert = driver.switchTo().alert();
		Reporter.log("Focus switched to alert |");
		
		String promptAlertMessage = promptAlert.getText();
		Reporter.log("Alert text is: " + promptAlertMessage + " |");
		
		promptAlert.sendKeys("sending message in prompt");
		Reporter.log("Message entered in prompt alert |");
		
		Assert.assertEquals(promptAlertMessage, "This is a JavaScript Prompt!");
		
		promptAlert.accept();
		Reporter.log("Alert closed |");
		
		Reporter.log("Test case ended |");
		
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("Ending Test |", true);
		driver.close();
	}

}
