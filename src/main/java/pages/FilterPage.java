package pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class FilterPage extends BasePage{
    private String keywordInputText="Cari...";
    private String chooseButtonText="Semua Indonesia Iklan";
	private String chooseRangeHargaText="Harga (Rp)";
	private String buttonFilterSubmitID="com.app.tokobagus.betterb:id/btnSubmit";
    private String uncheckCariDalamDeskripsiID="com.app.tokobagus.betterb:id/checkbox";
	public  String dariHargaText="dari";
	public  String sampaiHargaText="sampai";
    private String selesaiButtonText="Selesai";
    private String chooseElementsRangeHargaButtonID="com.app.tokobagus.betterb:id/chooserBtn";
    private String chooseElementsRangeHargaText="com.app.tokobagus.betterb:id/value";
    private String clearFilterID="com.app.tokobagus.betterb:id/action_clear";
    private String keywordFilterID="com.app.tokobagus.betterb:id/value";
    
	public FilterPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Fill Keyword = {0}")
	public void fillKeyword(String keys){
		//sendKeysElement(getEditTextLocator(keywordInputText), keys);
		sendKeysElement(getIdLocator(keywordFilterID),keys);
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
	
	@Step("Choose 'Harga' Filter")
	public ListingPage filterHarga(){
		clickHargaButton();
		sendKeysElement(getEditTextLocator(dariHargaText), "50000000");
		sendKeysElement(getEditTextLocator(sampaiHargaText), "100000000");
		clickSelesaiChooseHarga();
		clickFilterSubmitButton();
		return clickFilterSubmitButton();
	}
    
	@Step("Fill Filter 'Harga' dari ")
	public void fillHargaDari(){
		sendKeysElement(getEditTextLocator(dariHargaText), "50000000");	
	}
	
	@Step("Fill Filter 'Harga' sampai ")
	public void fillHargaSampai(){
		sendKeysElement(getEditTextLocator(sampaiHargaText), "100000000");
	}
	
	
	public void clickFilterKeyword(){
		clickElement(getEditTextLocator(keywordInputText));
	}
	
	@Step("Click Pilih 'Harga' Button Filter")
	public void clickHargaButton(){
		clickElement(getButtonLocator(chooseRangeHargaText));
	}
	
	@Step("Click Pilih 'Harga' Button Filter")
	public void clickHargaButtonFromElements(){
		getTextElements(chooseElementsRangeHargaButtonID, 2).click();
	}
	
	@Step("Fill Set From Harga")
	public void setFromHargaFromElements(String fromHarga){
        sendKeysElements(getIdLocator(chooseElementsRangeHargaText), 0, fromHarga);
	}
	
	@Step("Fill Set To Harga")
	public void setToHargaFromElements(String toHarga){
		sendKeysElements(getIdLocator(chooseElementsRangeHargaText), 1, toHarga);
	}
	
	@Step("Click 'Selesai' Choose Harga Filter")
	public void clickSelesaiChooseHarga(){
		clickElement(getTextLocator(selesaiButtonText));
	}
	
	@Step("Click 'Submit' Button Filter")
	public ListingPage clickFilterSubmitButton(){
        clickElement(getIdLocator(buttonFilterSubmitID));
        return new ListingPage(driver);
	}
	
	@Step("Clear Filter")
	public void clickClearFilter(){
		clickElement(getIdLocator(clearFilterID));
	}
}
