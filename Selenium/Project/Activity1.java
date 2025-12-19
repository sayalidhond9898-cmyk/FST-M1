package projectJob;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void verifyTitle()  {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
		System.out.println("Page title is: " + title);
	}
	
	@AfterClass
	
	public void closeBrowser() {
		 {
			System.out.println("Test Passed");
			driver.quit();
			
		}
	}
}

