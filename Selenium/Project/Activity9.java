package projectJob;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity9 {
	
	
WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/jobs/jobs/");
		driver.manage().window().maximize();
	}
	
	@Test	
	public void publishJob() throws InterruptedException {
	 
		driver.get("https://alchemy.hguy.co/jobs/wp-login.php");
	    System.out.println("Page title is: " + driver.getTitle());

	  
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement username = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))
	    );
	    username.sendKeys("root");

	    driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	    driver.findElement(By.id("wp-submit")).click();

	    System.out.println("Dashboard page title is: " + driver.getTitle());
	    WebElement jobsMenu = wait.until(
	        ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'edit.php?post_type=job_listing')]")));
	    
	    ////a[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-job_listing menu-top-last']//div[@class='wp-menu-image dashicons-before dashicons-admin-post']
	    jobsMenu.click();	
	        
	    //driver.findElement(By.xpath("//a[text()='Job Listing']")).click();
	    System.out.println("Job Listing page title is: " + driver.getTitle());
	    WebElement newJob = wait.until(
	        ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='page-title-action' and text()='Add New']")));
	    newJob.click();
	    	//	driver.findElement(By.xpath("//a[text()='Add New']")).click();
	    System.out.println("Add New Job page title is: " + driver.getTitle());
	    
	    
	    try {
	        WebElement closeBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close dialog']"))
	        );
	        closeBtn.click();
	        System.out.println("Closed Block Editor modal.");
	    } catch (TimeoutException e) {
	        System.out.println("No Block Editor modal found, continuing...");
	    }

	    // Continue with editor actions
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("textarea.editor-post-title__input")
	    ));
	    System.out.println("Editor is ready to use.");
	    
//	    driver.findElement(By.xpath("//div[@id='editor-b8a2ab7a-0cd3-4a01-87ed-c2e92128819f']")).sendKeys("Test Architect Job");
//	    System.out.println("Job title entered.");
	   
	    
	    WebElement positionField = wait.until(
	    	    ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='post-title-0']"))
	    	);
	    	positionField.click();
	    	positionField.sendKeys("Senior QA Automation Engineer");

	    	// 2. Click and fill Description block
	    	WebElement descriptionField = wait.until(
	    	    ExpectedConditions.elementToBeClickable(
	    	        By.xpath("//div[contains(@class,'wp-block-freeform') and @contenteditable='true']")
	    	    )
	    	);
	    	descriptionField.click();
	    	descriptionField.sendKeys("Responsible for designing scalable automation frameworks, writing robust test scripts, and collaborating with cross-functional teams to ensure product quality.");
	    Thread.sleep(2000);


	    	WebElement publishBtn = wait.until( ExpectedConditions.elementToBeClickable( By.cssSelector("button.editor-post-publish-button__button.is-primary") ) ); publishBtn.click(); 
	    	System.out.println("Clicked first Publish button.");
	    	
	    	Thread.sleep(2000);
	    	// Second Publish button in confirmation panel
	    	wait.until(ExpectedConditions.attributeContains(
	    		    By.cssSelector("button.editor-post-publish-panel__toggle"), "aria-expanded", "true"
	    		));
	    	System.out.println("Publish panel expanded.");
	    	WebElement confirmPublishBtn = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//div[contains(@class,'editor-post-publish-panel')]//button[text()='Publish']") ) );

	    	confirmPublishBtn.click();
	    	System.out.println("Clicked confirm Publish button.");
	    	
	    	WebElement viewJobLink = wait.until(
	    	    ExpectedConditions.elementToBeClickable(
	    	        By.xpath("//a[contains(@class,'components-button') and text()='View Job']")
	    	    )
	    	);
	    	viewJobLink.click();
//	    	System.out.println("Clicked View Job link.");
//

	    	
	    	
	    	WebElement jobTitle = wait.until(
	    		    ExpectedConditions.visibilityOfElementLocated(
	    		        By.cssSelector("h1.entry-title")
	    		    )
	    		);
	    		String publishedTitle = jobTitle.getText();
	    		if (publishedTitle.equals("Senior QA Automation Engineer")) {
	    		    System.out.println("Job title verified successfully.");
	    		} else {
	    		    System.out.println("Job title mismatch! Found: " + publishedTitle);
	    		}

	 }
	  
	@AfterTest
	
	public void closeBrowser() {
		driver.quit();
	
	}
	

	}	


	
