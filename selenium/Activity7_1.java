package SeleniumActivities;

/*
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		/*
		Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(45))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		*/
		
		
		
		
		driver.get("https://www.training-support.net/selenium/dynamic-attributes");
		
		System.out.println(driver.getTitle());
		
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@class, 'username-')]"));
		WebElement password = driver.findElement(By.cssSelector("[class^='password-']"));
		
		username.sendKeys("admin");
		password.sendKeys("password");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		
		//explicit wait for condition
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='action-confirmation']"), "Welcome Back, admin"));
		
		String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
		
		System.out.println(loginMessage);
		
		driver.close();

	}

}
