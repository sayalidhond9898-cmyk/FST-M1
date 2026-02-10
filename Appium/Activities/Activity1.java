package activities;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws Exception, URISyntaxException {
		//set the app file
		File file = new File("src/main/resources/Calculator.apk");
		
		// desired capabilities
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setApp(file.getAbsolutePath());
		caps.noReset();
		
		//set appium server url
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//initalize driver
		driver = new AndroidDriver(serverURL,caps);
		
	}
	
	@Test
	public void testMethod() {
	
		driver.findElement(AppiumBy.id("digit_8")).click();;
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();;
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();;
	String result= 	driver.findElement(AppiumBy.id("result_final")).getText();
	
	//String result = driver.findElement(AppiumBy.id("result_final")).getText();
	Assert.assertEquals(result , "40");	
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
