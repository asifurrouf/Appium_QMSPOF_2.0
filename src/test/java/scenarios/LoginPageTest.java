package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Features("LoginPage")
public class LoginPageTest extends AndroidSetup{
	@BeforeClass
	public void setUp() throws Exception{
		prepareAndroidForAppium();
        System.out.println("LoginPage Running on ...");
	}
	
	 @AfterClass
	 public void tearDown() throws Exception {
	    	System.out.println("LoginPage Quit");
	        driver.quit();
	 }
	 
	 @Test
	 @Stories("As A User I Want to be Able to Login")
	 @TestCaseId("TC_ADR_002_001")
	 @Title("Verify User Able to Login with Valid Credential")
	 public void userAbleToLoginWithValidCredential(){
		 HomePage homepage = new HomePage(driver);
		 LoginPage loginpage = homepage.clickLoginPage();
		 loginpage.inputEmail();
	 }
}
