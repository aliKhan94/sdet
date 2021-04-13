package activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2_3 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait =null;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Pixel4Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", ".activities.PeopleActivity");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void addContact() {
		MobileElement addContactButton = driver.findElementByAccessibilityId("Create new contact");
		addContactButton.click();
		
		MobileElement firstNameElement = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
		MobileElement lastNameElement = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
		MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
		
		firstNameElement.sendKeys("Aaditya");
		lastNameElement.sendKeys("Varma");
		phoneNumber.sendKeys("999148292");
		
		driver.findElementById("editor_menu_save_button").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
		
		MobileElement contactCard = driver.findElementById("toolbar_parent");
		Assert.assertTrue(contactCard.isDisplayed());
		
		String contactName = driver.findElementById("large_title").getText();
		System.out.println(contactName);
		Assert.assertEquals(contactName, "Aaditya Varma");
		
	}

	@AfterClass
	public void afterClass() {
	}

}
