package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleTaskAndKeep1 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@Test
	public void createTasklist() {
		
		String[] tasks = {"Complete Activity with Google Tasks",
				"Complete Activity with Google Keep",
				"Complete the second Activity Google Keep"};
		
		for(String task: tasks) {
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
			driver.findElementById("tasks_fab").click();
			
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
			driver.findElementById("add_task_title").sendKeys(task);
			driver.findElementById("add_task_done").click();
		}
		
		List<MobileElement> addedTasks = driver.findElementsById("task_name");
		int count = tasks.length;
		for(MobileElement addedTask: addedTasks) {
			count--;
			Assert.assertEquals(addedTask.getText(), tasks[count]);
			System.out.println(addedTask.getText());
			
			
		}
		
		
	}
	@BeforeClass
	public void beforeClass() {
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", "Pixel4Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			wait = new WebDriverWait(driver, 10);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
