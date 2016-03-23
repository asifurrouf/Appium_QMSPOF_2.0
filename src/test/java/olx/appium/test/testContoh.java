package olx.appium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import olx.appium.appium;

public class testContoh extends appium {

	@BeforeSuite
	public void setUp(){
		firstLaunchAndroid();
	}
	
	@Test
	public void testAjah() throws InterruptedException{
		Thread.sleep(30000);
		System.out.println("yeah ...");

		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Buka navigasi']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Login']")));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text='Email']")));
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys("suci.istch@gmail.com");
		driver.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys("test123");
	}
	
	@AfterSuite
	public void tearDown(){
		quitDriver();
	}
}
