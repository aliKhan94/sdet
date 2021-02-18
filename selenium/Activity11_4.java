package SeleniumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import org.openqa.selenium.By;

public class Activity11_4 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://www.training-support.net/selenium/tab-opener");
		
		System.out.println("Page title is: "+driver.getTitle());
		System.out.println("Parent window handle:"+driver.getWindowHandle());
		
		driver.findElement(By.id("launcher")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		System.out.println("All window handles: "+windowHandles);
		
		for(String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			
		}
		
		System.out.println("Current window handle: "+ driver.getWindowHandle());
		
		wait.until(ExpectedConditions.titleIs("Newtab"));
		
		System.out.println("Cuurent window title: "+driver.getTitle());
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
		
		String newTabHeader = driver.findElement(By.xpath("//div[contains(@class, 'icon')]/div")).getText();
		System.out.println(newTabHeader);
		
		//open another tab
		
		driver.findElement(By.id("actionButton")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		windowHandles = driver.getWindowHandles();
		System.out.println("All Window handle: "+windowHandles);
		
		//switching focus to most recent open tab/window
		for(String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
		}
		
		//print handle
		System.out.println("Handle of most recent open window "+driver.getWindowHandle());
		
		//wait for page to completely load
		wait.until(ExpectedConditions.titleIs("Newtab2"));
		
		newTabHeader = driver.findElement(By.xpath("//div[contains(@class, 'icon')]/div")).getText();
		System.out.println("Most recent tab header: "+newTabHeader);
		
		driver.quit();
	}

}
