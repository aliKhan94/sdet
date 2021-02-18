package SeleniumActivities;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Activity10_2 {

	public static void main(String[] args) throws HeadlessException, UnsupportedFlavorException, IOException {
		WebDriver driver = new FirefoxDriver();
		Actions actions = new Actions(driver);
		String pressedKeyText;
		
		driver.get("https://www.training-support.net/selenium/input-events");
		System.out.println("Title of the page: " + driver.getTitle());
		
		WebElement pressedKey = driver.findElement(By.id("keyPressed"));
		
		Action actionSequence1 = actions.sendKeys("K").build();
		actionSequence1.perform();
		pressedKeyText = pressedKey.getText();
		System.out.println("Pressed key is: "+pressedKeyText);
		
		Action actionsSequence2 = actions
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.sendKeys("c")
				.build();
		actionsSequence2.perform();
		
		String clipboardData = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);
		
		System.out.println(clipboardData);
		
		/*
		
		FileWriter myWriter = new FileWriter("C:\\Users\\AliKhan\\eclipse-workspace\\Sdet_Training\\copiedText.txt");
		myWriter.write(clipboardData);
		myWriter.close();
		*/
		driver.close();
	}

}
