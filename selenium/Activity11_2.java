package SeleniumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Activity11_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		System.out.println("Page title is: "+driver.getTitle());
		
		driver.findElement(By.id("confirm")).click();
		
		Alert confirmationAlert = driver.switchTo().alert();
		System.out.println("Text in alert: "+confirmationAlert.getText());
		confirmationAlert.accept();
		
		driver.findElement(By.id("confirm")).click();
		
		confirmationAlert = driver.switchTo().alert();
		System.out.println("Text in alert: "+confirmationAlert.getText());
		confirmationAlert.dismiss();
		
		driver.close();
	}

}
