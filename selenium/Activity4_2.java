package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/simple-form");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Ali");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Khan");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sjhdsdk@xyz.com");
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//div[@class='field']/textarea")).sendKeys("This is just selenium activity");
		
		driver.findElement(By.cssSelector("input.ui.green.button")).submit();
		
		driver.close();
	}

}
