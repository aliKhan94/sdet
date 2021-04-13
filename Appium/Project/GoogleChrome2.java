package project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleChrome2 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	MobileElement username = null;
	MobileElement password = null;
	MobileElement loginButton = null;

	@BeforeClass
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel4Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 30);

		driver.get("https://www.training-support.net/selenium");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='Selenium']")));

		driver.findElement(MobileBy.AndroidUIAutomator(
				"UiScrollable(UiSelector().scrollable(true)).scrollForward()"));

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"Login Form\")")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='Sign in! Welcome Back!']")));
		
		username = driver.findElement(MobileBy.AndroidUIAutomator(
				"UiSelector().resourceId(\"username\")"));
		password = driver.findElement(MobileBy.AndroidUIAutomator(
				"UiSelector().resourceId(\"password\")"));
		
		loginButton = driver.findElement(MobileBy.AndroidUIAutomator(
				"UiSelector().text(\"Log in\")"));
	}

	
	@Test
	public void loginFormCorrectCredentialTest() throws InterruptedException {
		username.sendKeys("admin");
		password.sendKeys("password");
		loginButton.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(
				"UiSelector().resourceId(\"action-confirmation\")")));
		
		String loginMessage = driver.findElement(MobileBy.AndroidUIAutomator(
				"UiSelector().resourceId(\"action-confirmation\")")).getText();
		System.out.println(loginMessage);
		
		Assert.assertEquals(loginMessage, "Welcome Back, admin");
		
		

	}
	
	@Test
	public void loginFormIncorrectCredentialTest() throws InterruptedException {
		username.sendKeys("admin");
		password.sendKeys("p@ssw0rd");
		loginButton.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(
				"UiSelector().resourceId(\"action-confirmation\")")));
		
		String loginMessage = driver.findElement(MobileBy.AndroidUIAutomator(
				"UiSelector().resourceId(\"action-confirmation\")")).getText();
		System.out.println(loginMessage);
		
		Assert.assertEquals(loginMessage, "Invalid Credentials");
		
		

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
