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
    
    public By getTextLocator(String locator){
    	return By.xpath("//android.widget.EditText[@text='"+locator+"']");
    	//return By.xpath("//android.widget.TextView[@text='"+locator+"']");
    }
     
    @Step("Input Email")
    public void inputEmail(){
    	waitForVisibilityOf(getTextLocator(emailInput));
    	driver.findElement(getTextLocator(emailInput)).clear();
    	driver.findElement(getTextLocator(emailInput)).sendKeys("bravo@olx.co.id");	
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
