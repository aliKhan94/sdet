package testNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver;

	@Test(groups={"HeaderTests","ButtonTests"})
	public void pageTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Target Practice");
	}
	
	@Test(dependsOnMethods="pageTitleTest", groups="HeaderTests")
	public void thridHeaderTest() {
		WebElement thirdHeader = driver.findElement(By.id("third-header"));
		Assert.assertEquals(thirdHeader.getText(), "Third header");
	}
	
	@Test(dependsOnMethods="pageTitleTest", groups="HeaderTests")
	public void fifthHeaderTest() {
		
		WebElement fifthHeader = driver.findElement(By.xpath("//h5[text()='Fifth header']"));
		Assert.assertEquals(fifthHeader.getCssValue("color"), "rgb(33, 186, 69)");
	}
	
	@Test(dependsOnMethods="pageTitleTest", groups="ButtonTests")
	public void buttonTest1() {
		WebElement oliveButton = driver.findElement(By.cssSelector("button.ui.olive.button"));
		Assert.assertEquals(oliveButton.getText(), "Olive");
	}
	
	@Test(dependsOnMethods="pageTitleTest", groups="ButtonTests")
	public void buttonTest2() {
		WebElement brownButton = driver.findElement(By.cssSelector("button.ui.brown.button"));
		Assert.assertEquals(brownButton.getCssValue("background-color"), "rgb(165, 103, 63)");
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
