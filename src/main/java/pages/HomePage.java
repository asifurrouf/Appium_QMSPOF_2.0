package pages;

import com.google.common.base.Function;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.asserts.Assertion;
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
    private String pilihLokasi="Mencari lokasi";
    private String searchLink="com.app.tokobagus.betterb:id/action_search";
    private String openNav="Buka navigasi";
    private String navLogin="com.app.tokobagus.betterb:id/log_in";
    private String navDaftar="com.app.tokobagus.betterb:id/register";
    private String searchButtonID="com.app.tokobagus.betterb:id/action_search";
    private String locationChooserID="com.app.tokobagus.betterb:id/btnChooseLocation";
    private String searchTextID="com.app.tokobagus.betterb:id/search_src_text";
    private String notifOpenAppsLocation="com.app.tokobagus.betterb:id/pager_title_strip";
    private String googlePlayServices="Get Google Play services";
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    protected Boolean checkAlertBeforeTest(final By locator){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                Boolean value = isElementPresent(locator);
                if (value){
                    System.out.println("WARNING: Google Play Service not Available... ");
                    clickElement(getButtonLocator(googlePlayServices));
                    return true;
                } else if (value != true ) {
                    clickElement(getIdLocator(notifOpenAppsLocation));
                    return true;
                }
            return true;
            }
        });
    }
    
    public LoginPage goToLoginPage(){
    	return new LoginPage(driver);
    }
    
    @Step("Click Petunjuk Lokasi")
    public void clickLocationNotif(){
        checkAlertBeforeTest(getTextLocator(googlePlayServices));
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
        //isWaitElementPresent(getTextLocator(perlengkapanBayi));
        Assert.assertTrue(isElementPresentAfterScroll(getTextLocator(perlengkapanBayi), perlengkapanBayi));
    }
    
    @Step("Locate Post An Ads Button")
    public void getPostAdsLink(){
    	//waitForVisibilityOf(getIdLocator(postAdsLink));
    	isWaitElementPresent(getIdLocator(postAdsLink));
    }
    
    @Step("Locate Lokasi Link ")
    public void getLokasiLink(){
    	//waitForVisibilityOf(getIdLocator(pilihLokasi));
    	isWaitElementPresent(getToogleTextLocator(pilihLokasi));
    }
    
    @Step("Locate Search Link ")
    public void getSearchLink(){
    	//waitForVisibilityOf(getIdLocator(searchLink));
    	isWaitElementPresent(getIdLocator(searchLink));
    }
    
    @Step("Locate Image Drawer Link")
    public void getImageDrawer(){
    	isWaitElementPresent(getContentLocator(openNav));
    }
    
    @Step("Go to Login Menu")
    public LoginPage clickLoginPage(){
    	clickElement(getContentLocator(openNav));
    	clickElement(getIdLocator(navLogin));
    	return new LoginPage(driver);
    }
    
    @Step("Go To Daftar Menu")
    public DaftarPage clickDaftarPage(){
    	clickElement(getContentLocator(openNav));
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
	public ListingPage clickSearchButton(){
		clickElement(getIdLocator(searchButtonID));
		return new ListingPage(driver);
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
