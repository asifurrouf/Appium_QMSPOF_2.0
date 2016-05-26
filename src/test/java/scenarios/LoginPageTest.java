package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Features("Login Feature")
public class LoginPageTest extends AndroidSetup{
	private String emailValid="frengky.sheeran@gmail.com";
	private String passValid="frengky123.,";
	private String passInvalid="sheeran123";
	private String emailInvalidFormat="frengky";
	private String passBlank="";
	private LoginPage loginpage;
	
	@Parameters({"udid"})
	@BeforeClass
	public void setUp(String udid) throws Exception{
		prepareAndroidForAppium(udid);
        System.out.println("Login Page Running on ...");
	}
	
	 @AfterClass
	 public void tearDown() throws Exception {
	    	System.out.println("Login Page Quit");
	        driver.quit();
	 }
	 
	 @Test(priority=1)
	 @Stories("As A User I Will not be Able to Login")
	 @TestCaseId("TC_ADR_002_001")
	 @Title("Verify User Not Able to Login with InValid Email Format")
	 public void userNotAbleToLoginWithWrongEmailFormat(){
		 System.out.println("Verify User Not Able to Login with InValid Email Format");
		 HomePage homepage = new HomePage(driver);
		 homepage.clickLocationNotif();
		 loginpage = homepage.clickLoginPage();
		 loginpage.inputEmail(emailInvalidFormat);
		 loginpage.inputPassword(passBlank);
		 loginpage.clickSubmitLoginButton();
		 loginpage.verifyEmailLoginFormatWrong();
		 loginpage.verifyPasswordLoginBlank();
		 loginpage.clickBackButton();
	 }
	 
	 @Test(priority=2)
	 @Stories("As A User I Will not be Able to Login")
	 @TestCaseId("TC_ADR_002_002")
	 @Title("Verify User Not Able to Login with InValid Credential")
	 public void userNotAbleToLoginWithInvalidCredential() throws Exception{
		 System.out.println("Verify User Not Able to Login with InValid Credential");
		 HomePage homepage = new HomePage(driver);
		 loginpage = homepage.clickLoginPage();
		 loginpage.inputEmail(emailValid);
		 loginpage.inputPassword(passInvalid);
		 loginpage.clickSubmitLoginButton();
	     loginpage.verifyInvalidLogin();
	     loginpage.clickBackButton();
	 }
	 
	 @Test(priority=3)
	 @Stories("As A User I Want to be Able to Login with Valid Credential")
	 @TestCaseId("TC_ADR_002_003")
	 @Title("Verify User Able to Login with Valid Credential")
	 public void userAbleToLoginWithValidCredential(){
		 System.out.println("Verify User Able to Login with Valid Credential");
		 HomePage homepage = new HomePage(driver);
		 loginpage = homepage.clickLoginPage();
		 loginpage.inputEmail(emailValid);
		 loginpage.inputPassword(passValid);
		 loginpage.clickSubmitLoginButton();
		 loginpage.verifySuccessLogin();
	 }
	 
	 @Test(priority=4)
	 @Stories("As A User I Want to be Able to Logout")
	 @TestCaseId("TC_ADR_002_004")
	 @Title("Verify User Able to Logout")
	 public void userAbleToLogout(){
		 System.out.println("Verify User Able to Logout");
		 LoginPage loginpage = new LoginPage(driver);
		 HomePage homepage = loginpage.clickLogout();
		 homepage.clickLoginPage();
		 loginpage.verifyNotLogin();
	 }
}
