package roshnatest1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_TC1 extends Baseclass_eComm{
	
	@Test
	public void Fillform() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("roshna");
		driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Argentina\"))")).click();
        //driver.findElement(By.xpath("android.widget.TextView")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        //To handle the toast message
//        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//        System.out.print(toastMessage+"+++++++++++++++++++++++++++++++++++++++++++++++++++++ +++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        Assert.assertEquals(toastMessage,"Please enter your name");
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"))"));
        Thread.sleep(1000);
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productImage")).size();

        for (int i=0; i<productCount; i++) {
        String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();	
        }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();	
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        String lastPageProduct =driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
        
        
        
        
        
        
        
	}
	

}
