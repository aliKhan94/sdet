package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/nested-iframes");
		
		System.out.println("Page Title: "+driver.getTitle());
		
		//switch to frame on the page
		driver.switchTo().frame(0);
		
		//switch to first frame in that frame
		driver.switchTo().frame(0);
		String headerText = driver.findElement(By.cssSelector("div.ui.header")).getText();
		System.out.println("First child frame header:\n"+headerText);
		
		//switch to parent frame
		driver.switchTo().parentFrame();
		
		//switch to second child frame
		driver.switchTo().frame(1);
		headerText = driver.findElement(By.cssSelector("div.ui.header")).getText();
		System.out.println("Second child frame header:\n"+headerText);
		
		//switch to main page
		driver.switchTo().defaultContent();
		headerText = driver.findElement(By.cssSelector("div.activity.content")).getText();
		System.out.println("Main page header:\n"+headerText);
		
		//closing browser
		driver.close();

	}

}
