package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		WebElement element;
		
		driver.get("https://www.training-support.net");
		
		String pageTitle = driver.getTitle();
		
		System.out.println(pageTitle);
		
		element = driver.findElement(By.id("about-link"));
		
		
		element = driver.findElement(By.className("green")); 
		
		
		element = driver.findElement(By.linkText("About Us"));
		
		element = driver.findElement(By.cssSelector("a#about-link"));
		
		String elementText = element.getText();
		
		System.out.println(elementText);
		
		driver.close();
		
		
	}

}
