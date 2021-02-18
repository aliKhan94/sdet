package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		System.out.println(driver.getTitle());
		
		WebElement  toggleCheckBox = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		//click to disappear
		toggleCheckBox.click();
		
		//explicit wait for condition
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		
		//click to appear
		toggleCheckBox.click();
		
		//wait until checkbox appear
		
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		
		//check checkbox
		checkbox.click();
		
		System.out.println("Checkbox selected: "+ checkbox.isSelected());
		
		driver.close();

	}

}
