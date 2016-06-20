package scenarios;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.BasePage;
import tracking.NetClient;


public class TestListener
        implements ITestListener {

    WebDriver driver;
    BasePage base;
    NetClient request;
    
	//Capture test only on Fail
    @Override
    public void onTestFailure(ITestResult testResult) {
        driver = AndroidSetup.getDriver();
        base = new BasePage(driver);
        request = new NetClient(driver);
    	try {
    	   System.out.println("***** Error "+testResult.getName()+" test has failed *****");
            base.getAttachment("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
            request.create(testResult);
            System.out.println("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
    	} catch (Exception e){
    		System.out.print("-->Unable to screen capture");
            e.printStackTrace();
    	}
    }
    
    public void onFinish(ITestContext context) {}
    
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }

}
