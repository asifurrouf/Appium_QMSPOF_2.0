package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class DaftarPage extends BasePage {

	private String fieldLocatorDaftarID="com.app.tokobagus.betterb:id/value";
	private String checkPernyataanSetujuID="com.app.tokobagus.betterb:id/checkbox";
	private String registerButtonID="com.app.tokobagus.betterb:id/btnRegister";
	private WebElement emailElement;
	private WebElement passwordElement;
	private WebElement konfirmasiPasswordElement;
	private WebElement pernyataanSetujuElement;
	private WebElement newsletterOLXElement;
	private String errorMsgLoginID = "com.app.tokobagus.betterb:id/errorMsg";
	
	public DaftarPage(WebDriver driver) {
		super(driver);
	}

	@Step("Set Element Daftar")
	public void setElementDaftar(){
		List<WebElement> elementsDaftar = getListElements(getIdLocator(fieldLocatorDaftarID));
		this.emailElement = elementsDaftar.get(0);
		this.passwordElement = elementsDaftar.get(1);
		this.konfirmasiPasswordElement = elementsDaftar.get(2);
		
		List<WebElement> elementsPernyataan = getListElements(getIdLocator(checkPernyataanSetujuID));
		this.pernyataanSetujuElement = elementsPernyataan.get(0);
		this.newsletterOLXElement = elementsPernyataan.get(1);
	}
	
	@Step("Fill Email Daftar")
	public void setEmailDaftar(String email){
		sendKeysElements(emailElement, email);
	}
	
	@Step("Fill Password Daftar")
	public void setPasswordDaftar(String password){
		sendKeysElements(passwordElement,password);
	}
	
	@Step("Fill Konfirmasi Password Daftar")
	public void setKonfirmasiPasswordDaftar(String password){
		sendKeysElements(konfirmasiPasswordElement,password);
	}
	
	@Step("Click Setuju Pernyataan")
	public void clickSetuju(){
		pernyataanSetujuElement.click();
	}
	
	@Step("Click Success Submit Register Button")
	public SuccessDaftarPage clickSubmitRegister(){
		clickElement(getIdLocator(registerButtonID));
		return new SuccessDaftarPage(driver);
	}
	
	@Step("Verify Email Login Format Wrong")
	public void verifyEmailLoginFormatWrong(){
	    Assert.assertTrue(getTextElements(getIdLocator(errorMsgLoginID), 0).getText().contains("Alamat Email salah"));
	}
	 
	@Step("Verify Password Can't Be Blank")
	public void verifyPasswordCantBeBlank(){
		Assert.assertTrue(getTextElements(getIdLocator(errorMsgLoginID), 0).getText().contains("Wajib diisi"));
	}
	
	@Step("Verify Confirmation Password Can't Be Blank")
	public void verifyKonfirmasiPasswordCantBeBlank(){
		Assert.assertTrue(getTextElements(getIdLocator(errorMsgLoginID), 0).getText().contains("Wajib diisi"));
	}
	
	@Step("Verify Confirmation Password Not Same")
	public void verifyKonfirmasiPasswordNotSame(){
		Assert.assertTrue(getTextElements(getIdLocator(errorMsgLoginID), 0).getText().contains("Password tidak sama"));
	}
	
	@Step("Verify UnCheck Pernyataan Setuju")
	public void verifyUnCheckPernyataanSetuju(){
		Assert.assertTrue(getTextElements(getIdLocator(errorMsgLoginID), 0).getText().contains("Wajib diisi"));
	}
	
	@Step("Back to Homepage")
    public HomePage clickBackButton(){
    	driver.navigate().back();
    	driver.navigate().back();
    	return new HomePage(driver);
    }
	
}
