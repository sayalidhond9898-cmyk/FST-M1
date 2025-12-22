package projectJob;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/jobs/jobs/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void postAjob()  {
		
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.findElement(By.linkText("Post a Job")).click();
		System.out.println("Page title is: " + driver.getTitle());
		driver.findElement(By.id("create_account_email")).sendKeys("sayali15@gmail.com");
		driver.findElement(By.id("job_title")).sendKeys("Test Specialist");
		driver.findElement(By.id("job_location")).sendKeys("Bangalore");
		
		WebElement dropdown = driver.findElement(By.id("job_type"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Full Time");
		
		 driver.switchTo().frame("job_description_ifr");
		 WebElement description = driver.findElement(By.id("tinymce"));
		 description.clear();
		 description.sendKeys("This is a job description for Test Specialist role.");
		//driver.findElement(By.id("job_description")).sendKeys("This is a job description for Test Specialist role.");
		//driver.findElement(By.id("application")).sendKeys("http://www.test.com");
		 driver.switchTo().defaultContent();

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


		 WebElement applicationField = wait.until(
		     ExpectedConditions.visibilityOfElementLocated(By.id("application"))
		 );
		 applicationField.sendKeys("test123@example.com");

		 driver.findElement(By.id("company_name")).sendKeys("Test Company");


		 driver.findElement(By.xpath("//input[@value='Preview']")).click();
		 System.out.println("Preview page title is: " + driver.getTitle());

		 WebElement submitBtn = wait.until(
		     ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Submit Listing']"))
		 );
		 submitBtn.click();

	
		 WebElement viewJobLink = wait.until(
				 ExpectedConditions.elementToBeClickable(By.linkText("click here"))
				 );
				 viewJobLink.click();
				 
		WebElement jobTitle = wait.until(
		     ExpectedConditions.visibilityOfElementLocated(By.className("entry-title"))
		 );
		 System.out.println("Posted job title is: " + jobTitle.getText());
		 assert jobTitle.getText().equals("Test Specialist");
		
		 System.out.println("Job submitted successfully");
		
		
	}
	
	@AfterTest
	public void closeBrowser()  {
		
			driver.quit();
		
	}


}
