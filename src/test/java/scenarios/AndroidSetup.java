package scenarios;


import io.appium.java_client.android.AndroidDriver;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import tracking.NetClient;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AndroidSetup {

    public static AndroidDriver driver;
    public static JSONArray array;
    public NetClient net;
    
    public void prepareAndroidForAppium(String udid) throws MalformedURLException, Exception {
        //File appDir = new File("/Users/buddyarifin/Documents/AutomationsTools/olxid-mobile-test/Resources");
        File appDir = new File("/Users/tegar/olxid-mobile-test/Resources");
        File app = new File(appDir, "olxid-6.4.2.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        capabilities.setCapability("appPackage", "com.app.tokobagus.betterb");
        capabilities.setCapability("appActivity", "sea.olx.activities.SplashscreenActivity");
        //capabilities.setCapability(CapabilityType.BROWSER_NAME,"android");
        //mandatory capabilities
        //capabilities.setCapability("deviceName",udid);
        capabilities.setCapability("deviceName","Galaxy S4");
        capabilities.setCapability("platformName","Android");
        //capabilities.setCapability("udid", udid);
        
        //No Reset Apps
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", true);
        
        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);
        System.out.println("SESSION CREATED : "+driver.getSessionId().toString()+" "+udid+" ");
    }

    @Parameters({"udid"})
    @BeforeClass
    public void setUp(String udid) throws Exception{
        prepareAndroidForAppium(udid);
        net = new NetClient(driver);
        this.array = net.getBugsJson();
    }


    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Closed App and Erase session ");
        driver.quit();
    }

    public static AndroidDriver getDriver (){
        return driver;
    }
    
}
