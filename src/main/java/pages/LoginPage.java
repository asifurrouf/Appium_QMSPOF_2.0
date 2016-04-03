package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends BasePage {
    By userId = By.id(app_package_name + "user_id");
    By password = By.id(app_package_name + "user_password");
    By showPassword = By.id(app_package_name + "show_password");
    By login_Button = By.id(app_package_name + "btn_login");
    private String emailTextInput="Email";
    private String passwordTextInputID="com.app.tokobagus.betterb:id/value";
    private String submitLoginButtonID="com.app.tokobagus.betterb:id/btnLogInNew";
    private String errorMsgLoginID = "com.app.tokobagus.betterb:id/errorMsg";
    private String loginPageTitle ="Login";
    private String userLoginID = "com.app.tokobagus.betterb:id/user_login";
    private String logoutButtonText="Log out";

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
     
    @Step("Input Email")
    public void inputEmail(String email){
    	sendKeysElement(getEditTextLocator(emailTextInput),email);
    }
    
    @Step("Input Password")
    public void inputPassword(String password){
    	sendKeysElements(getIdLocator(passwordTextInputID), 1, password);
    }
    
    @Step("Click Submit Login Button")
    public void clickSubmitLoginButton(){
    	clickElement(getIdLocator(submitLoginButtonID));
    }
    
    @Step("Verify Email Login Format Wrong")
    public void verifyEmailLoginFormatWrong(){
    	Assert.assertTrue(getTextElements(getIdLocator(errorMsgLoginID), 0).getText().contains("Alamat Email salah"));
    }
    
    @Step("Verify Password Login Can't Be Blank")
    public void verifyPasswordLoginBlank(){
    	Assert.assertTrue(getTextElements(getIdLocator(errorMsgLoginID), 1).getText().contains("Wajib diisi"));
    }
    
    @Step("Verify Invalid Login Credential")
    public void verifyInvalidLogin() throws Exception{
     try{	
    	if(isElementPresent(getTextLocator(loginPageTitle))){
    		Assert.assertTrue(true);
    	}else{
    		Assert.fail("Invalid Credential Should Not Be Successfully Login");
    	}
     }catch(NoSuchElementException e){
    	    getAttachment("InvalidLoginCredential.png");
    	    Assert.fail("Invalid Credential Should Not Be Successfully Login");
     }
    }
    
    @Step("Verify Success Login")
    public void verifySuccessLogin(){   	
    	try{
    	  waitForVisibilityOf(getIdLocator(userLoginID));
    	  System.out.println("User Login Location : "+driver.findElement(getIdLocator(userLoginID)).getText());
    	}catch(NoSuchElementException e){
    		Assert.fail("Anda Gagal Login");
    	}

    }
    
    @Step("Click LogOut")
    public HomePage clickLogout(){
    	System.out.println("Click Logout");
    	clickElement(getTextLocator(logoutButtonText));
    	return new HomePage(driver);
    }
    
    public LoginPage invalidLogin() {
        waitForVisibilityOf(userId);
        driver.findElement(userId).sendKeys("someone@testvagrant.com");
        driver.findElement(password).sendKeys("testvagrant123");
        driver.findElement(showPassword).click();
        driver.findElement(login_Button).click();
        return new LoginPage(driver);
    }
}
