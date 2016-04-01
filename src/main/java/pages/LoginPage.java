package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends BasePage {
    By userId = By.id(app_package_name + "user_id");
    By password = By.id(app_package_name + "user_password");
    By showPassword = By.id(app_package_name + "show_password");
    By login_Button = By.id(app_package_name + "btn_login");
    private String navigateImageLoc = "Buka navigasi";
    private String loginLinkID="com.app.tokobagus.betterb:id/log_in";
    private String emailTextInput="Email";
    private String passwordTextInputID="com.app.tokobagus.betterb:id/value";
    private String submitLoginButtonID="com.app.tokobagus.betterb:id/btnLogInNew";

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
    
    public LoginPage invalidLogin() {
        waitForVisibilityOf(userId);
        driver.findElement(userId).sendKeys("someone@testvagrant.com");
        driver.findElement(password).sendKeys("testvagrant123");
        driver.findElement(showPassword).click();
        driver.findElement(login_Button).click();
        return new LoginPage(driver);
    }
}
