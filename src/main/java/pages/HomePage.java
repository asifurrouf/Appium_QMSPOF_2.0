package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    //android.widget.ImageButton
    
    public By getTextLocator(String locator){
    	return By.xpath("//android.widget.TextView[@text='"+locator+"']");
    }
    
    public By getIdLocator(String locator){
    	return By.id(locator);
    }
    
    public By getImageLocator(String locator){
    	return By.xpath("//android.widget.ImageButton[@index='"+locator+"']");
    }
    
    public LoginPage goToLoginPage(){
    	return new LoginPage(driver);
    }
    
    @Step("Locate Mobil Link")
    public void getTextMobilLink(){
    	 waitForVisibilityOf(getTextLocator(mobilLink));
    	//isElementPresent(getTextLocator(mobilLink));
    }
    
    @Step("Locate Motor Link")
    public void getTextMotorLink(){
    	waitForVisibilityOf(getTextLocator(motorLink));
    }
    
    @Step("Locate Property Link")
    public void getTextPropertyLink(){
    	waitForVisibilityOf(getTextLocator(propertyLink));
    }
    
    @Step("Locate Keperluan Pribadi Link")
    public void getTextKeperluanPribadiLink(){
    	//return getTextLocator(keperluanPribadi);
    	waitForVisibilityOf(getTextLocator(keperluanPribadi));
    }
    
    @Step("Locate Electronik Link")
    public void getTextElectronicLink(){
    	//return getTextLocator(elektronic);
    	waitForVisibilityOf(getTextLocator(elektronic));
    }
    
    @Step("Locate Hobi Link")
    public void getTextHobiLink(){
    	waitForVisibilityOf(getTextLocator(hobi));
    	//return getTextLocator(hobi);
    }
    
    @Step("Locate Rumah Link")
    public void getTextRumahTanggaLink(){
    	waitForVisibilityOf(getTextLocator(rumah));
    	//return getTextLocator(rumah);
    }
    
    @Step("Locate Perlengkapan Bayi Link")
    public void getTextPerlengkapanBayiLink(){
    	waitForVisibilityOf(getTextLocator(perlengkapanBayi));
    	//return getTextLocator(perlengkapanBayi);
    }
    
    @Step("Locate Post An Ads Button")
    public void getPostAdsLink(){
    	waitForVisibilityOf(getIdLocator(postAdsLink));
    	//return getIdLocator(postAdsLink);
    }
    
    @Step("Locate Lokasi Link ")
    public void getLokasiLink(){
    	waitForVisibilityOf(getIdLocator(pilihLokasi));
    	//return getIdLocator(pilihLokasi);
    }
    
    @Step("Locate Search Link ")
    public void getSearchLink(){
    	waitForVisibilityOf(getIdLocator(searchLink));
    	//return getIdLocator(searchLink);
    }
    
    @Step("Locate Image Drawer Link")
    public void getImageDrawer(){
    	waitForVisibilityOf(getImageLocator(imageIndex));
    }
    
    @Step("Go to Login Menu")
    public LoginPage clickLoginPage(){
    	clickElement(getImageLocator(imageIndex));
    	clickElement(getIdLocator(navLogin));
    	return new LoginPage(driver);
    }
    
    
    
    
    public ResultPage searchFor(String keyword) {
        waitForClickabilityOf(search_button_locator);
        driver.findElement(search_button_locator).click();

        waitForVisibilityOf(search_textbox_locator);
        driver.findElement(search_textbox_locator).sendKeys(keyword);

        return new ResultPage(driver);
    }
    
    @Step("Click Back Button")
    public void clickBackButton(){
    	driver.navigate().back();
    }
    
    @Step("Click Mobil Link")
    public void clickMobilLink(){
    	//waitForVisibilityOf(getTextMobilLink());
    	//driver.findElement(getTextMobilLink()).click();
    	clickBackButton();
    	//System.out.println("Test");
    }

    @Step("Click Motor Link")
    public void clickMotorLink(){
    //	waitForVisibilityOf(getTextMotorLink());
   // 	driver.findElement(getTextMotorLink()).click();
    	clickBackButton();
    	//System.out.println("Test");
    }
    
    @Step("Click Property Link")
    public void clickPropertyLink(){
    //	waitForVisibilityOf(getTextPropertyLink());
    //	driver.findElement(getTextPropertyLink()).click();
    	clickBackButton();
    	//System.out.println("Test");
    }
    
    
    
    public void clearText(WebElement elementToBeCleared) {
        elementToBeCleared.sendKeys("x");
        elementToBeCleared.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        elementToBeCleared.sendKeys(Keys.chord(Keys.BACK_SPACE));
    }

}
