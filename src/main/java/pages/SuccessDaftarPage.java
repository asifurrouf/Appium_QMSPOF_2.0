package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class SuccessDaftarPage extends BasePage {
    private String messageContainerID="com.app.tokobagus.betterb:id/messageContainer";
    private String kembaliKeHalamanDepanID="com.app.tokobagus.betterb:id/backToHP";
    
	public SuccessDaftarPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Verify Success Daftar")
	public void verifySucessDaftar(){
		Assert.assertTrue(isWaitElementPresent(getIdLocator(messageContainerID)));
	}
	
	@Step("Click Back to HomePage")
    public HomePage clickBackToHomePages(){
    	clickElement(getIdLocator(kembaliKeHalamanDepanID));
    	return new HomePage(driver);
    }

}
