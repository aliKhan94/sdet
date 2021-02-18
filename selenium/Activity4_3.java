package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/target-practice");
		
		System.out.println(driver.getTitle());
		
		String thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
		System.out.println(thirdHeader);
		
		WebElement fifthHeader = driver.findElement(By.xpath("//h5[@id='fith-header']"));
		
		System.out.println(fifthHeader.getText());
		
		String fifthHeaderColor = fifthHeader.getCssValue("color");
		System.out.println(fifthHeaderColor);
		
		String violetButtonClasses = driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class");
		
		System.out.println("Violet button classes are: "+violetButtonClasses); 
	}

}
