package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		try {
			
		driver.get("https://training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		
		WebElement firstname = driver.findElement(By.id("firstName"));
		WebElement lastname = driver.findElement(By.id("lastName"));
		
		firstname.sendKeys("Ali");
		lastname.sendKeys("Khan");
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("alikhan@xyz.com");
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys("1234567890");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.green")).submit();
		
		System.out.println("code run successfully");
		} catch(Exception e) {
			driver.close();
		}
		finally {
			driver.close();
		}
		
		
	}

}
