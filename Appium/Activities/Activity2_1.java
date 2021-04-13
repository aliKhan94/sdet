package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity2_1 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	@Test
	public void findTitle() {
		driver.get("https://www.training-support.net/");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text ='Training Support']")));
		
		String pageTitle = driver.findElementByXPath("//android.view.View[@text ='Training Support']").getText();
		System.out.println("Title on homepage: " + pageTitle);
		
		MobileElement aboutButton =  driver.findElementByXPath("//android.view.View[@content-desc='About Us']");
		aboutButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='About Us']")));
		
		String newPagetitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
		System.out.println("New page tile: " + newPagetitle);
		
		Assert.assertEquals("Training Support", pageTitle);
		Assert.assertEquals("About Us", newPagetitle);
	}
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Pixel4Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
		
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 30);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
