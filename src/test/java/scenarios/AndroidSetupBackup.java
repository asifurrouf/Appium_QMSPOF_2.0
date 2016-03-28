package scenarios;


import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetupBackup {
    public AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        //File appDir = new File("/Users/tegar/AppiumDemo/apps");
        //File app = new File(appDir, "app-olxid-release.6.1.3.apk");
       DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("no",true);
        //capabilities.setCapability("newCommandTimeout", 100000);
        
        capabilities.setCapability("device","Android");
        //capabilities.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, ".DispatchActivity");

        capabilities.setCapability("appPackage", "com.app.tokobagus.betterb");
        capabilities.setCapability("appActivity", "sea.olx.activities.SplashscreenActivity");
        
        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");
        
        //No Reset Apps
        //capabilities.setCapability("noReset", true);
        //capabilities.setCapability("fullReset", "false");
        //capabilities.setCapability("noRest", true);
        
        //capabilities.setCapability("app", app.getAbsolutePath());
      
        driver =  new AndroidDriver(new URL("http://192.168.99.1:4444/wd/hub"), capabilities);
    }
}
