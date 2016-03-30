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
    private String loginLink ="com.app.tokobagus.betterb:id/log_in";
    private String emailInput="Email";

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
     
    @Step("Input Email")
    public void inputEmail(){
    	waitForVisibilityOf(getEditTextLocator(emailInput));
    	driver.findElement(getEditTextLocator(emailInput)).clear();
    	driver.findElement(getEditTextLocator(emailInput)).sendKeys("bravo@olx.co.id");	
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
