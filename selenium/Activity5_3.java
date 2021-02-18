package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		System.out.println(driver.getTitle());
		
		WebElement inputText = driver.findElement(By.id("input-text"));
		
		System.out.println("Input text is selected: "+inputText.isEnabled());
		
		driver.findElement(By.id("toggleInput")).click();
		
		System.out.println("Input text is selected: "+inputText.isEnabled());
			
		
		driver.close();

	}

}
