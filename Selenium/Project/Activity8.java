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

public class Activity8 {
	

	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/jobs/jobs/");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void backendlogic() {
	 
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
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
