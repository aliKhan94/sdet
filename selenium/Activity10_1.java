package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions actions = new Actions(driver);
		
		driver.get("https://www.training-support.net/selenium/input-events");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		WebElement cube = driver.findElement(By.id("D3Cube"));
		
		actions.click(cube).perform();
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement cubValue = driver.findElement(By.className("active"));
		System.out.println("On left click: "+cubValue.getText());
		
		actions.doubleClick().perform();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cubValue = driver.findElement(By.className("active"));
		System.out.println("On double click: "+cubValue.getText());
		
		actions.contextClick(cube).perform();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cubValue = driver.findElement(By.className("active"));
		System.out.println("On right click: "+cubValue.getText());
		
		driver.close();

	}

}
