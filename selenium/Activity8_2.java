package SeleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'sortable')]/thead/tr/th"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr"));
		
		System.out.println("No of columns: "+cols.size());
		System.out.println("No of rows: "+rows.size());
		
		WebElement cellValueBefore = driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]")); 
		System.out.println(cellValueBefore.getText());
		
		driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/thead/tr[1]/th[1]")).click();
		
		WebElement cellValueAfter = driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]"));
		System.out.println(cellValueAfter.getText());
		
		driver.close();
		
		

	}

}
