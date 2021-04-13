package project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleChrome1 {
	WebDriverWait wait = null;
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
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
	}
	
	@Test
	public void toDoListTest() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='Selenium']")));
		
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
		
		driver.findElement(MobileBy.AndroidUIAutomator(
				"UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"To-Do List\")")).click();
		//driver.findElement(MobileBy.AndroidUIAutomator(
		//"UiScrollable(UiSelector().scrollable(true)).getChildByText(UiSelector().className(\"android.widget.TextView\"), \"To-Do List\")")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='Dynamically add and remove elements.']")));
		
		//MobileElement taskInputField = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")"));
		
		//MobileElement addTaskButton = driver.findElementByXPath("//android.widget.Button[@text='Add Task']");
		
		driver.findElement(MobileBy.xpath("//android.view.View/android.view.View[3]/android.view.View[3]")).click();
		
		String tasks[] = {"Add tasks to list", 
				"Get number of tasks", 
				"Clear the list"};
		
		for(int i = 0; i < tasks.length; i++) {
			driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys(tasks[i]);
			//Thread.sleep(1000);
			driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
		}
		
		Thread.sleep(2000);
		
		List<MobileElement> tasksList = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
		
		System.out.println("Total task added: " + tasksList.size());
		
		int i = 0;
		for(MobileElement taskList: tasksList) {
			System.out.println(taskList.getText());
			Assert.assertEquals(taskList.getText(), tasks[i]);
			i++;
			taskList.click();
			Thread.sleep(1000);
		}
		
		
		driver.findElement(MobileBy.xpath("//android.view.View/android.view.View[3]/android.view.View[3]")).click();
		
		Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
