package projectJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver;
	@Test
	public void getImageUrl() {
		
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
		String imageUrl = driver.findElement(
			    By.xpath("//img[@class='attachment-large size-large wp-post-image']")
			).getAttribute("src");

			System.out.println("Image URL: " + imageUrl);
			driver.quit();
		
		
	}	

}
