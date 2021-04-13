package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleTasksAndKeep2 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", "Pixel4Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void createNote() {
		String noteTitle = "This Is Title";
		String noteDescription = "This is description";
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("new_note_button"))).click();
		driver.findElementById("new_note_button").click();
		driver.findElementById("editable_title").sendKeys(noteTitle);
		driver.findElementById("edit_note_text").sendKeys(noteDescription);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("editable_title"))).sendKeys(noteTitle);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("edit_note_text"))).sendKeys(noteDescription);
		driver.findElementByAccessibilityId("Open navigation drawer").click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("index_note_title")));
		List<MobileElement> addedTitle = driver.findElementsById("index_note_title");
		List<MobileElement> addedDescription = driver.findElementsById("index_note_text_description");
		
		Assert.assertEquals(addedTitle.get(0).getText(), noteTitle);
		Assert.assertEquals(addedDescription.get(0).getText(), noteDescription);
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
