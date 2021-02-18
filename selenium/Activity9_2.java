package SeleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		
		WebElement chosenOptions = driver.findElement(By.id("multi-value"));
		
		WebElement multiSelectElement = driver.findElement(By.id("multi-select"));
		
		Select multiSelect = new Select(multiSelectElement);
		
		if(multiSelect.isMultiple()) {
			multiSelect.selectByVisibleText("Javascript");
			//System.out.println(Activity9_1.printSelectedOption(multiSelect));
			System.out.println(chosenOptions.getText());
			
			multiSelect.selectByValue("node");
			System.out.println(chosenOptions.getText());
			
			for(int i = 4; i<=6; i++) {
				multiSelect.selectByIndex(i);
			}
			System.out.println(chosenOptions.getText());
			
			multiSelect.deselectByValue("node");
			System.out.println(chosenOptions.getText());
			
			multiSelect.deselectByIndex(7);
			System.out.println(chosenOptions.getText());
			
			String firstSelectedOption = multiSelect.getFirstSelectedOption().getText();
			System.out.println("First selected option: "+firstSelectedOption);
			
			List<WebElement> selectedList = multiSelect.getAllSelectedOptions();
			
			for(WebElement selectedElement : selectedList) {
				System.out.println(selectedElement.getText());
			}
			
			multiSelect.deselectAll();
		}
		else {
			System.out.println("HTML Element is not multi-select");
		}
		
		driver.close();

	}

}
