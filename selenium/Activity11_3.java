package SeleniumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Activity11_3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		System.out.println("Page title is: "+driver.getTitle());
		
		driver.findElement(By.id("prompt")).click();
		
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Yes, you are!");
		System.out.println("Text in alert: "+promptAlert.getText());
		promptAlert.accept();
		
		driver.close();
	}

}
