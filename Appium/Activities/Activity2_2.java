package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2_2 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = null;

	@BeforeClass
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Pixel4Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", ".Calculator");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void add() {
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("digit_5")));
		driver.findElementById("digit_5").click();
		driver.findElementByAccessibilityId("plus").click();
		driver.findElementById("digit_9").click();
		driver.findElementById("eq").click();

		String result = driver.findElementById("result").getText();
		System.out.println(result);
		Assert.assertEquals(result, "14");
	}

	@Test
	public void subtract() {
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("digit_5")));
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementByAccessibilityId("minus").click();
		driver.findElementById("digit_5").click();
		driver.findElementById("eq").click();
		
		String result = driver.findElementById("result").getText();
		System.out.println(result);
		Assert.assertEquals(result, "5");
	}
	
	@Test
	public void multiply() {
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("digit_5")));
		driver.findElementById("digit_5").click();
		driver.findElementByAccessibilityId("multiply").click();
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("eq").click();
		
		String result = driver.findElementById("result").getText();
		System.out.println(result);
		Assert.assertEquals(result, "500");
	}
	
	@Test
	public void divide() {
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("digit_5")));
		driver.findElementById("digit_5").click();
		driver.findElementById("digit_0").click();
		driver.findElementByAccessibilityId("divide").click();
		driver.findElementById("digit_2").click();
		driver.findElementById("eq").click();
		
		String result = driver.findElementById("result").getText();
		System.out.println(result);
		Assert.assertEquals(result, "25");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
