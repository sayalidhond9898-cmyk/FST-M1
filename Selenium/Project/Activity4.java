package projectJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {
	
	WebDriver driver;
	String secondHeader;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void secondHeader() {
	    secondHeader = driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]"))
	            .getText();
	   
	    Assert.assertEquals(secondHeader, "Quia quis non", "Header text did not match!");
	}
	@AfterMethod
	public void closeBrowser() {
	    if(secondHeader.equals("Quia quis non")) {
	        System.out.println("Test Passed");
	        driver.quit();   // closes only if it matches
	    } 
	   }
	}

	

