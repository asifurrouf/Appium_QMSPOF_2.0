package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends BasePage {

    By search_button_locator = By.id(app_package_name + "menu_search");
    By search_textbox_locator = By.id(app_package_name + "autoCompleteTextView");
    private String mobilLink = "Mobil";
    private String motorLink = "Motor";
    private String propertyLink = "Properti";
    private String keperluanPribadi = "Keperluan Pribadi";
    private String elektronic = "Elektronik & Gadget";
    private String hobi="Hobi & Olahraga";
    private String rumah="Rumah Tangga";
    private String perlengkapanBayi="Perlengkapan Bayi & Anak";
    private String postAdsLink="com.app.tokobagus.betterb:id/postAdButton";
    private String pilihLokasi="com.app.tokobagus.betterb:id/locationTop";   
    private String searchLink="com.app.tokobagus.betterb:id/action_search";
    private String imageIndex="0";
    private String navLogin="com.app.tokobagus.betterb:id/log_in";
    private String navDaftar="com.app.tokobagus.betterb:id/register";
    private String searchButtonID="com.app.tokobagus.betterb:id/action_search";
    private String locationChooserID="com.app.tokobagus.betterb:id/locationChooser";
    private String searchTextID="com.app.tokobagus.betterb:id/search_src_text";
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public LoginPage goToLoginPage(){
    	return new LoginPage(driver);
    }
    
    @Step("Locate Mobil Link")
    public void getTextMobilLink(){
    	 //waitForVisibilityOf(getTextLocator(mobilLink));
    	 isWaitElementPresent(getTextLocator(mobilLink));
    }
    
    @Step("Locate Motor Link")
    public void getTextMotorLink(){
    	//waitForVisibilityOf(getTextLocator(motorLink));
    	isWaitElementPresent(getTextLocator(motorLink));
    }
    
    @Step("Locate Property Link")
    public void getTextPropertyLink(){
    	//waitForVisibilityOf(getTextLocator(propertyLink));
    	isWaitElementPresent(getTextLocator(propertyLink));
    }
    
    @Step("Locate Keperluan Pribadi Link")
    public void getTextKeperluanPribadiLink(){
    	//waitForVisibilityOf(getTextLocator(keperluanPribadi));
    	isWaitElementPresent(getTextLocator(keperluanPribadi));
    }
    
    @Step("Locate Electronik Link")
    public void getTextElectronicLink(){
    	//waitForVisibilityOf(getTextLocator(elektronic));
    	isWaitElementPresent(getTextLocator(elektronic));
    }
    
    @Step("Locate Hobi Link")
    public void getTextHobiLink(){
    	//waitForVisibilityOf(getTextLocator(hobi));
    	isWaitElementPresent(getTextLocator(hobi));
    }
    
    @Step("Locate Rumah Link")
    public void getTextRumahTanggaLink(){
    	//waitForVisibilityOf(getTextLocator(rumah));
    	isWaitElementPresent(getTextLocator(rumah));
    }
    
    @Step("Locate Perlengkapan Bayi Link")
    public void getTextPerlengkapanBayiLink(){
    	//waitForVisibilityOf(getTextLocator(perlengkapanBayi));
    	isWaitElementPresent(getTextLocator(perlengkapanBayi));
    }
    
    @Step("Locate Post An Ads Button")
    public void getPostAdsLink(){
    	//waitForVisibilityOf(getIdLocator(postAdsLink));
    	isWaitElementPresent(getIdLocator(postAdsLink));
    }
    
    @Step("Locate Lokasi Link ")
    public void getLokasiLink(){
    	//waitForVisibilityOf(getIdLocator(pilihLokasi));
    	isWaitElementPresent(getIdLocator(pilihLokasi));
    }
    
    @Step("Locate Search Link ")
    public void getSearchLink(){
    	//waitForVisibilityOf(getIdLocator(searchLink));
    	isWaitElementPresent(getIdLocator(searchLink));
    }
    
    @Step("Locate Image Drawer Link")
    public void getImageDrawer(){
    	isWaitElementPresent(getImageLocator(imageIndex));
    }
    
    @Step("Go to Login Menu")
    public LoginPage clickLoginPage(){
    	clickElement(getImageLocator(imageIndex));
    	clickElement(getIdLocator(navLogin));
    	return new LoginPage(driver);
    }
    
    @Step("Go To Daftar Menu")
    public DaftarPage clickDaftarPage(){
    	clickElement(getImageLocator(imageIndex));
    	clickElement(getIdLocator(navDaftar));
    	return new DaftarPage(driver);
    }
    
    @Step("Go to Mobil Menu")
    public MobilPage clickMobilPage(){
    	clickElement(getTextLocator(mobilLink));
    	return new MobilPage(driver);
    }
    
    
    public ListingPage searchFor(String keyword) {
    	sendKeysElement(getIdLocator(searchTextID), keyword);
        clickElement(getIdLocator(searchLink));
        return new ListingPage(driver);
    }
    
    @Step("Click Back Button")
    public void clickBackButton(){
    	driver.navigate().back();
    }
    
    @Step("Click Mobil Link")
    public void clickMobilLink(){
    	clickBackButton();
    }

    @Step("Click Motor Link")
    public void clickMotorLink(){
    	clickBackButton();
    }
    
    @Step("Click Property Link")
    public void clickPropertyLink(){
    	clickBackButton();
    }
    
    @Step("Click Search")
	public HeaderPage clickSearchButton(){
		clickElement(getIdLocator(searchButtonID));
		return new HeaderPage(driver);
	}
    
    @Step("Input Search Keyword")
    public ListingPage inputSearchKeyword(String keys){
    	sendKeysElement(getIdLocator(searchTextID), keys+"\n");
    	return new ListingPage(driver);
    }
    
    @Step("Click Location Chooser")
	public HeaderPage clickLocationChooser(){
		clickElement(getIdLocator(locationChooserID));
		return new HeaderPage(driver);
	}
    
    @Step("Click Jual Iklan")
    public JualIklanPage clickJualIklan(){
    	clickElement(getIdLocator(postAdsLink));
    	return new JualIklanPage(driver);
    }
    
    
    public void clearText(WebElement elementToBeCleared) {
        elementToBeCleared.sendKeys("x");
        elementToBeCleared.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        elementToBeCleared.sendKeys(Keys.chord(Keys.BACK_SPACE));
    }

}
