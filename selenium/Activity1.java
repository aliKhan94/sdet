package SeleniumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		
		//Use below code to set browser driver path, if it not set in system variable
		
		/*
		System.setProperty("webdriver.gecko.driver", "path");
		System.setProperty("webdriver.chrome.driver", "path");
		System.setProperty("webdriver.IE.driver", "path");*/
		
		//Create instance of firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the browser
		driver.get("https://www.training-support.net/");
		
		/*
		 * perform testing and assertion
		 */
		
		//Close the browser
		driver.quit();
		System.out.println();
		
	}

}
