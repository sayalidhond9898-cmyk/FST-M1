package projectJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Activity2 {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void verifyHeading()  {
		//driver.findElement(By.className("entry-title")).getText();
		WebElement heading = driver.findElement(By.className("entry-title"));
		Assert.assertEquals(heading.getText(), "Welcome to Alchemy Jobs");
		System.out.println("Heading is: " + heading.getText());
	}
	
	@AfterTest
	public void closeBrowser()  {
		
			driver.quit();
		
	}
}
