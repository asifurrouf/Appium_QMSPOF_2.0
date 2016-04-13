package pages;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListener implements ITestListener {
    
	//Capture test only on Fail
    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	try {
    	   // getAttachment(methodName);
    		System.out.print("-->Able to screen capture "+methodName);
    	} catch (Exception e){
    		System.out.print("-->Unable to screen capture");
    	}
    }
    
    public void onFinish(ITestContext context) {}
    
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }

}
