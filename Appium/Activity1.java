package mobileexample;


import java.io.File;
import java.net.URI;
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
    public void setUp() throws Exception {
        // Set the app file
        File file = new File("src/main/resources/Calculator.apk");
        
        // Desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setApp(file.getAbsolutePath());
        caps.noReset();
        
        // Set Appium server URL
        URL serverURL = new URI("http://localhost:4723").toURL();
        
        // Initialize driver
        driver = new AndroidDriver(serverURL, caps);
    }
    
    @Test
    public void testMethod() {
        // Locator 1: ID
        driver.findElement(AppiumBy.id("digit_8")).click();
        
        // Locator 2: Accessibility ID
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        
        // Locator 3: XPath
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='5']")).click();
        
        // Again using Accessibility ID for equals
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        
        // Fetch result using ID
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        
        // Assertion
        Assert.assertEquals(result, "40");
    }
    
    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}

