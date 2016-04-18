package scenarios;


import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {
    protected AndroidDriver driver;
    
    
    protected void prepareAndroidForAppium(String udid) throws MalformedURLException, Exception {
       // File appDir = new File("/Users/tegar/AppiumDemo/apps");
       // File app = new File(appDir, "app-olxid-release.6.1.3.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        capabilities.setCapability("appPackage", "com.app.tokobagus.betterb");
        capabilities.setCapability("appActivity", "sea.olx.activities.SplashscreenActivity");
        //capabilities.setCapability(CapabilityType.BROWSER_NAME,"android");
        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("udid", udid);
        
        //No Reset Apps
        capabilities.setCapability("no-reset", true);
        capabilities.setCapability("full-reset", false);
        
        //other caps
        //capabilities.setCapability("app", app.getAbsolutePath());
        //Thread.sleep(3500);
        driver =  new AndroidDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);
        System.out.println("SESSION CREATED : "+driver.getSessionId().toString()+" "+udid);
        Thread.sleep(10000);
    }
    
    
}
