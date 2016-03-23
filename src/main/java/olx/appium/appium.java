package olx.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class appium {
	
	//protected WebDriver driver;
	protected AppiumDriver driver;
	protected Wait wait;
	int TIMEOUT=80;
	
	public void firstLaunchAndroid(){
		System.out.println("First Launch Setup for Android Apps");
		//File appDir = new File("C:/Users/WCSUser/Downloads");
		//AutoLog.message("test 2");
		//File app = new File(appDir, "com.instagram.android-6.20.1-APK4Fun.com.apk");
		//File app = new File(appDir, "traveloka - [www.zona-apk.com].apk");
		
		//File app = new File("app-olxid-release.6.1.3.apk");//install app 
		
		System.out.println("Set Desired Capabilities");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus4");
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability(CapabilityType.PLATFORM, "MAC");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("app-package", "com.instagram.android");
		capabilities.setCapability("appPackage", "com.app.tokobagus.betterb");
		//capabilities.setCapability("app-activity", "com.guru99app.MainActivity");
		capabilities.setCapability("appActivity", "sea.olx.activities.SplashscreenActivity");
		
		System.out.println("Instatiate Driver");
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:8889/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.switchTo().window("NATIVE_UP");
		System.out.println("Instatiate Driver is success");
		wait = new WebDriverWait(driver, 80);
	}
	
	public void quitDriver(){
		driver.quit();
	}

}
