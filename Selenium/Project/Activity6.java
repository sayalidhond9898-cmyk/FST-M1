package projectJob;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity6 {
	

	WebDriver driver;
	String secondHeader;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/jobs/jobs/");
	}
	@Test
	public void searchJob() {
	    driver.get("https://alchemy.hguy.co/jobs/");
	    driver.findElement(By.linkText("Jobs")).click();
	    driver.findElement(By.id("search_keywords")).sendKeys("Banking");
	    driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


	    WebElement jobLink = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//li[contains(@class,'job_listing')]//h3[text()='Senior Banking']/ancestor::li//a")
	    ));
	    jobLink.click();

	    System.out.println("The job title is: " + driver.getTitle());

	 
	    WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(
	    	    By.xpath("//input[@value='Apply for job' or contains(@class,'application_button')] | //a[contains(@class,'application_button')]")
	    	));
	    	applyButton.click();
	  
	    	WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    		    By.xpath("//a[contains(@href,'mailto:')]")
	    ));
	
	    String email = emailElement.getText();
	    System.out.println("The application email is: " + email);
	}

	  @AfterTest
	  public void closeBrowser() {
	        driver.quit();
	    }	
	

}


	
	
