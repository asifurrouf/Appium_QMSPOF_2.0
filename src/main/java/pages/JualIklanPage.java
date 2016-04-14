package pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class JualIklanPage extends BasePage{
    
	private String imageViewerID="com.app.tokobagus.betterb:id/imageView";
	private String textFieldID="com.app.tokobagus.betterb:id/value";
	private String chooserButtonID="com.app.tokobagus.betterb:id/chooserBtn";
	private String chooseTextGaleryPic="Kamera";
	private String imageTextOpen="Gallery";
	private String alwaysWithGalleryID="android:id/button_always";
	private String shutterCameraButtonID="com.android.camera:id/shutter_button";
	private String cameraButtonDoneID="com.android.camera:id/btn_done";
	private String errorMessageID="com.app.tokobagus.betterb:id/errorMsg";
	private String postAnAdsButtonID="com.app.tokobagus.betterb:id/postAdBtn";
	private String selesaiInputHargaID="com.app.tokobagus.betterb:id/buttonDefaultPositive";
	private String tipeKendaraanID="android:id/text1";
	private String tahunPembuatanID="android:id/text1";
	private String spinnerButtonID="com.app.tokobagus.betterb:id/spinner";
	private String pesanEmailRegisteredID="android:id/message";
	private String buttonBatalPasangID="android:id/button2";
	private String buttonLanjutPasangID="android:id/button1";
    private String successPostingID="com.app.tokobagus.betterb:id/postadSuccessThanks";
	private String backToHomePageID="com.app.tokobagus.betterb:id/backToHP";
	private WebElement judulIklan;
	private WebElement deskripsiIklan;
	private WebElement namaPengiklan;
	private WebElement emailPengiklan;
	private WebElement pinBBPengiklan; 
	private WebElement telpPengiklan;
	private WebElement kategoriIklan;
	private WebElement lokasiIlkan;
	private WebElement hargaButton;
	private WebElement tipeKendaraanButton;
	private WebElement transmisiKendBtn;
	private WebElement tahunPembuatanBtn;
    
	
	
	
	public JualIklanPage(WebDriver driver) {
		super(driver);
	}
	
    
	@Step("Check Kembali ke Pasang Iklan")
	public void checkKembaliKePasangIklan(){
		try{
			clickElement(getTextLocator("Buat baru"));
		}catch(Exception e){
			System.out.println("-->Continue to Next Process");
			Assert.assertTrue(true);
		}
	}
	
	@Step("Set Element Jual Iklan Pertama")
	public void setElementJualIklan(){
		List<WebElement> elementsTextPasang = getListElements(getIdLocator(textFieldID));
		this.judulIklan = elementsTextPasang.get(0);
		this.deskripsiIklan = elementsTextPasang.get(1);
		this.namaPengiklan = elementsTextPasang.get(2);
		
		List<WebElement> elementsButtonPasang = getListElements(getIdLocator(chooserButtonID));
		this.kategoriIklan = elementsButtonPasang.get(0);
	}
	
	@Step("Set Element Jual Iklan Kedua")
	public void setElementJualIklanKedua(){ //after set judul, deskripsi dan kategori
		List<WebElement> elementsButtonPasang = getListElements(getIdLocator(chooserButtonID));
		this.hargaButton = elementsButtonPasang.get(1);
		List<WebElement> elementsSpinnerPasang = getListElements(getIdLocator(spinnerButtonID));
		this.tipeKendaraanButton = elementsSpinnerPasang.get(0);
	}
	
	@Step("Set Element Jual Iklan Ketiga")
	public void setElementJualIklanKetiga(){
		List<WebElement> elementsChooserBtn = getListElements(getIdLocator(chooserButtonID));
		this.lokasiIlkan = elementsChooserBtn.get(0);
		List<WebElement> elementsSpinnerBtn = getListElements(getIdLocator(spinnerButtonID));
		//element 0 still use by Tipe Kendaraan
		this.transmisiKendBtn = elementsSpinnerBtn.get(1);
		this.tahunPembuatanBtn = elementsSpinnerBtn.get(2);
		List<WebElement> elementsTextPasang = getListElements(getIdLocator(textFieldID));
		this.namaPengiklan = elementsTextPasang.get(0);
		this.emailPengiklan = elementsTextPasang.get(1);
		this.pinBBPengiklan = elementsTextPasang.get(2);
	}
	
	@Step("Set Element telpPengiklan")
	public void setElementTelpPengiklan(){
		List<WebElement> elementsTextPasang = getListElements(getIdLocator(textFieldID));
		this.telpPengiklan = elementsTextPasang.get(3);
	}

	@Step("Verify Error Notifcation on All Element")
	public void verifyAllErrorNotification() throws Exception{
		List<WebElement> elementsTextError = getListElements(getIdLocator(errorMessageID));
		Assert.assertTrue(elementsTextError.get(0).getText().toLowerCase().contains("judul"));
		Assert.assertTrue(elementsTextError.get(1).getText().toLowerCase().contains("kategori"));
		Assert.assertTrue(elementsTextError.get(2).getText().toLowerCase().contains("deskripsi"));
		//Assert.assertTrue(elementsTextError.get(3).getText().toLowerCase().contains("lokasi"));
		//Assert.assertTrue(elementsTextError.get(4).getText().toLowerCase().contains("nama"));
	}
	
	@Step("Verify Error Notification Title")
	public void verifyErrorOnTitle(){
		Assert.assertTrue(getListElements(getIdLocator(errorMessageID)).get(0).getText().toLowerCase().contains("tidak bisa kurang"));
	}
	
	@Step("Verify Error Notification Description")
	public void verifyErrorOnDesc(){
		Assert.assertTrue(getListElements(getIdLocator(errorMessageID)).get(1).getText().toLowerCase().contains("tidak bisa kurang"));
	}
	
	@Step("Verify Error Telp Invalid")
	public void verifyErrorPhone(){
		Assert.assertTrue(getListElements(getIdLocator(errorMessageID)).get(0).getText().toLowerCase().contains("telepon"));
	}
	
	@Step("Click Pasang Iklan Button")
	public void clickPasangIklanButton(){
		clickElement(getIdLocator(postAnAdsButtonID));
	}
	
	@Step("Click Image Button Iklan")
	public void clickImageButonIklan(){
		clickElement(getIdLocator(imageViewerID));
	}
	
	@Step("Choose Galery Image")
	public void chooseGaleryImage(){
		clickElement(getTextLocator(chooseTextGaleryPic));	
	}
	
	@Step("Choose Image Instead of Camera")
	public void clickChooseGallery(){
		clickElement(getTextLocator(imageTextOpen));
	}
	
	@Deprecated
	@Step("Choose Default Open Gallery Apps")
	public void clickDefaultOpenImage(){
      try{
	    clickElement(getIdLocator(alwaysWithGalleryID));	
	  }catch(NoSuchElementException e){
	    System.out.println("Default Open with Gallery");	
	   }
	}
	
	@Step("Pick First Image From Gallery")
	public void captureImageFromCamera(){
	   clickElement(getIdLocator(shutterCameraButtonID));
	  try {
	      clickElement(getIdLocator(cameraButtonDoneID));
	  } catch (NoSuchElementException e) {
		  driver.navigate().back();
		  System.out.println("Camera Button Automatically ");
	  }
	}
	
	@Step("Input Title Jual Iklan {0}")
	public void setTitleJualIklan(String keys){
		judulIklan.sendKeys(keys);
	}
	
	@Step("Input Deskripsi")
	public void setDescription(String keys){
		deskripsiIklan.sendKeys(keys);
	}
    
	@Step("Click Harga Chooser Button")
	public void clickHargaChooserButton(){
		hargaButton.click();
	}

	@Step("Input Harga Product {0}")
	public void fillHargaProduct(String harga){
		sendKeysElement(getIdLocator(textFieldID), harga);
	}
	
	@Step("Selesai set Harga Product")
	public void selesaiSetHargaProduct(){
		clickElement(getIdLocator(selesaiInputHargaID));
	}
	
	@Step("Click Tipe Kendaraan")
	public void clickTipeKendaraanButton(){
		tipeKendaraanButton.click();
	}
	
	@Step("Set Tipe Kendaraan")
	public void setTipeKendaraan(){
		getTextElements(getIdLocator(tipeKendaraanID), 0).click();
	}
	
	@Step("Choose Lokasi")
	public LocationPage clickLocation(){
		lokasiIlkan.click();
		return new LocationPage(driver);
	}
	
	@Step("Input Nama {0}")
	public void setNama(String keys){
		namaPengiklan.sendKeys(keys);
	}
	
	@Step("Input Telp {0}")
	public void setTelp(String keys){
	    telpPengiklan.sendKeys(keys);	
	}
	
	
	@Step("Choose Kategori Mobil")
	public KategoriPage clickCategoryMobil(){
		kategoriIklan.click();
		return new KategoriPage(driver);
	}
	
	@Step("Click Tipe Transmisi")
	public void clickTransmisi(){
		transmisiKendBtn.click();
	}
	
	@Step("Choose Transmisi Kendaraan {0}")
	public void chooseTransmisi(String transmisi){
		clickElement(getSpinnerLocator(transmisi));//tiptronic transmission
	}
	
	@Step("Click Tahun Pembuatan")
	public void clickTahunPembuatan(){
		tahunPembuatanBtn.click();
	}
	
	@Step("Set Tahun Pembuatan")
	public void setTahunPembuatan(){
		getTextElements(getIdLocator(tahunPembuatanID),0).click();//tahun pembuatan sekarang
	}
	
	@Step("Input Email {0}")
	public void setEmail(String keys){
	  if(emailPengiklan.isEnabled()){
		emailPengiklan.sendKeys(keys);
	  }
	}
	
	@Step("Input pinBB Pengiklan {0}")
	public void setPinBB(String keys){
		pinBBPengiklan.sendKeys(keys);
	}
	
	@Step("Verify Email Registered or Not")
	public boolean verifyIsEmailRegistered(){
		try{
			isWaitElementPresent(getIdLocator(pesanEmailRegisteredID));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@Step("Click Lanjut Login")
	public LoginPage clickLanjutLogin(){
		clickElement(getIdLocator(buttonLanjutPasangID));
		return new LoginPage(driver);
	}
	
	@Step("Verify User Success Posting an Ads")
	public void verifySuccessPostingAds() throws Exception{
	    try{
	    	Assert.assertTrue(driver.findElement(getIdLocator(successPostingID)).getText()
	    			.toLowerCase().contains("terima kasih"));
	    }catch(Exception e){
	    	getAttachment("FailedPostingAds.png");
	    	Assert.fail("Fail to Post an Ads");
	    }
	}
	
	@Step("Click Back to HomePage")
	public void clickBacktoHomePage(){
		clickElement(getIdLocator(backToHomePageID));
	}
	
}
