package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions actions = new Actions(driver);
		
		driver.get("https://training-support.net/selenium/drag-drop");
		System.out.println("Page title is: "+driver.getTitle());
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));
		
		WebElement ball = driver.findElement(By.id("draggable"));
		WebElement leftBox = driver.findElement(By.id("droppable"));
		WebElement rightBox = driver.findElement(By.id("dropzone2"));
		
		Action actionsSequence1 = actions
				.clickAndHold(ball)
				.dragAndDrop(ball, leftBox)
				.release()
				.build();
		
		actionsSequence1.perform();
		
		wait.until(ExpectedConditions.attributeToBeNotEmpty(leftBox, "background-color"));
		System.out.println("Ball entered dropzone1");
		
		actions.dragAndDrop(ball, rightBox).build().perform();
		wait.until(ExpectedConditions.attributeToBeNotEmpty(rightBox, "background-color"));
		System.out.println("Ball entered dropzone2");
		
		driver.close();

	}

}
