package scenarios;

import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pages.BasePage;
import sun.nio.ch.Net;
import tracking.NetClient;

/**
 * Created by buddyarifin on 6/14/16.
 */
public class ScreenshootsListener extends TestListenerAdapter {
    private WebDriver driver;
    private BasePage base;
    protected JSONArray array;
    protected AndroidSetup setup = new AndroidSetup();
    public NetClient request = new NetClient(AndroidSetup.getDriver());

    @Override
    public void onTestFailure(ITestResult testResult){
        driver = AndroidSetup.getDriver();
        base = new BasePage(driver);
        try {
            System.out.println("***** Error "+testResult.getName()+" test has failed *****");
            base.getAttachment("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
            request.goToTracker(testResult, this.array);
            System.out.println("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
        } catch (Exception e){
            System.out.print("-->Unable to screen capture");
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Running Test -> "+result.getMethod().getMethodName());
        this.array = AndroidSetup.array;
    }

    @Override
    public void onTestSuccess(ITestResult testResult){
        driver = AndroidSetup.getDriver();
        base = new BasePage(driver);
        try {
            System.out.println("***** Success Execution for "+testResult.getName()+" *****");
            request.goToTracker(testResult, this.array);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
