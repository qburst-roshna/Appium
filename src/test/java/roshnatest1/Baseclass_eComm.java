package roshnatest1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Baseclass_eComm{
	
	public AndroidDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void ConfigureAppium() throws MalformedURLException, InterruptedException {
		
		
		URL appiumServerURL = new URL("http://127.0.0.1:4723");

        // Define the capabilities and add them to the instance of AndroidDriver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("app","//home//roshnaelsajohn//maven//genericstore//src//test//java//resource//General-Store.apk");
        capabilities.setCapability("automationName","UIAutomator2");
        capabilities.setCapability("deviceName","Pixel_3a");
        //capabilities.setCapability("chromeDriver", "//home//roshnaelsajohn//Desktop//chromedriver");
        // Create an instance of AndroidDriver with the capabilities
        driver = new AndroidDriver(appiumServerURL, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Specify the path to the ChromeDriver executable
        File chromedriver = new File("//home//roshnaelsajohn//Desktop//chromedriver");
        System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
        capabilities.setCapability("chromedriverExecutable", chromedriver.getAbsolutePath());
        
	}
		
	
	
	@AfterTest
	
	public void tearDown() {
		driver.quit();
	

}
	
}