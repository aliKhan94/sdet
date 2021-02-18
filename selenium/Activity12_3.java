package SeleniumActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://www.training-support.net/selenium/popups");
		
		System.out.println("Page Tile: "+driver.getTitle());
		
		WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
		
		actions.moveToElement(signInButton).pause(Duration.ofSeconds(1)).build().perform();
		
		String toolTipText = signInButton.getAttribute("data-tooltip");
		
		System.out.println("Pop-up text: "+toolTipText);
		
		signInButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		String confirmationMessage = driver.findElement(By.cssSelector("div#action-confirmation")).getText();
		
		System.out.println(confirmationMessage);
		
		driver.close();
		
		
	}

}
