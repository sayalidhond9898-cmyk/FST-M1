package projectJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver;
	String secondHeader;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
		
	}
	@Test
	public void naviatetoJobsPage() {
		
	    driver.findElement(By.linkText("Jobs")).click();
	    driver.getTitle();
	    System.out.println("Jobs Page Title: " + driver.getTitle());
	}
	
	@AfterMethod
	public void closeBrowser() {
	        System.out.println("Test Completed");
	        driver.quit();   
	   }
	
}