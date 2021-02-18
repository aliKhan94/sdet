package SeleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		
		WebElement dropdownElement = driver.findElement(By.id("single-select"));
		
		Select dropdown = new Select(dropdownElement);
		
		dropdown.selectByVisibleText("Option 2");
		String slectedOption = printSelectedOption(dropdown);
		System.out.println("Print selected option: "+slectedOption);
		
		dropdown.selectByIndex(3);
		dropdown.selectByValue("4");
		
		List<WebElement> dropdownOptions = dropdown.getOptions();
		
		for(WebElement element : dropdownOptions) {
			System.out.println(element.getText());
		}
		
		driver.close();

	}
	
	public static String printSelectedOption(Select select) {
		return select.getFirstSelectedOption().getText();
	}

}
