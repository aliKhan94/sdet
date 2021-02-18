package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://www.training-support.net/selenium/ajax");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[contains(@class, 'violet')]")).click();
		
		
		//explicit wait for condition
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));

		String ajaxText = driver.findElement(By.id("ajax-content")).getText();
		System.out.println(ajaxText);
		
		//wait for late text
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
		
		String lateText = driver.findElement(By.id("ajax-content")).getText();
		System.out.println(lateText);
		
		driver.close();

	}

}
