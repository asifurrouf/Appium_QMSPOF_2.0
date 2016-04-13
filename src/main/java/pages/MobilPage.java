package pages;

import org.openqa.selenium.WebDriver;

import pages.ListingPage;

import ru.yandex.qatools.allure.annotations.Step;


public class MobilPage extends BasePage {

	private String semuaMobilLink="Semua di Mobil";
	private String mobilBekasLink="Mobil Bekas";
	private String aksesorisLink="Aksesoris";
	private String audioMobilLink="Audio Mobil";
	private String sparepartLink="Sparepart";
	private String velgDanBanLink="Velg dan Ban";
	
	
	public MobilPage(WebDriver driver) {
		super(driver);
	}
    
	@Step("Verify Semua Mobil Link")
	public void getSemuaMobilLink(){
		isWaitElementPresent(getTextLocator(semuaMobilLink));
	}
	
	@Step("Verify Mobil Bekas Link")
	public void getMobilBekasLink(){
		isWaitElementPresent(getTextLocator(mobilBekasLink));
	}
	
	@Step("Verify Aksesoris Link")
	public void getAksesorisLink(){
		isWaitElementPresent(getTextLocator(aksesorisLink));
	}
	
	@Step("Verify Audio Mobil Link")
	public void getAudioMobilLink(){
		isWaitElementPresent(getTextLocator(audioMobilLink));
	}
	
	@Step("Verify SparePart Link")
	public void getSparepartLink(){
		isWaitElementPresent(getTextLocator(sparepartLink));
	}
	
	@Step("Verify Velg Dan Ban Link")
	public void getVelgDanBanLink(){
		isWaitElementPresent(getTextLocator(velgDanBanLink));
	}	
	
	@Step("Click Semua Mobil Link")
	public ListingPage clickSemuaMobilLink(){
		System.out.println("Click Semua Mobil Link");
		clickElement(getTextLocator(semuaMobilLink));
		return new ListingPage(driver);
	}
	
	@Step("Clik Semua Mobil Link")
	public void chooseSemuaMobilLink(){
		clickElement(getTextLocator(semuaMobilLink));
	}
	
}
