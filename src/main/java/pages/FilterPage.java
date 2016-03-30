package pages;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class FilterPage extends BasePage{
    private String keywordInputText="Cari...";
    private String chooseButtonText="Semua Indonesia Iklan";
	private String chooseRangeHarga="Harga (Rp)";
	private String buttonFilterSubmitID="com.app.tokobagus.betterb:id/btnSubmit";
    private String uncheckCariDalamDeskripsiID="com.app.tokobagus.betterb:id/checkbox";
	
	public FilterPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Fill Keyword {0}")
	public void fillKeyword(String keys){
		sendKeysElement(getEditTextLocator(keywordInputText), keys);
	}
	
	@Step("Uncheck Cari Dalam Deskripsi Options")
	public void uncheckCariDalamDeskripsi(){
		clickElement(getIdLocator(uncheckCariDalamDeskripsiID));
	}
	
	@Step("Choose Location")
	public PilihLokasiPage chooseLocation(){
		clickElement(getTextLocator(chooseButtonText));
		return new PilihLokasiPage(driver);
	}
	
	@Step("Choose Category")
	public MobilKategoriPage chooseCategory(){
		return new MobilKategoriPage(driver);
	}
	
	@Step("Choose Harga")
	public void chooseHarga(){
		
	}

	public void clickFilterKeyword(){
		clickElement(getEditTextLocator(keywordInputText));
	}
	
	@Step("Click Filter Submit Button")
	public ListingPage clickFilterSubmitButton(){
        clickElement(getIdLocator(buttonFilterSubmitID));
        return new ListingPage(driver);
	}
}
