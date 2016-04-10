package pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
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
	private String imageGridGalleryID="com.android.gallery:id/grid";
	private String shutterCameraButtonID="com.android.camera:id/shutter_button";
	private String cameraButtonDoneID="com.android.camera:id/btn_done";
	private String errorMessageID="com.app.tokobagus.betterb:id/errorMsg";
	private String postAnAdsButtonID="com.app.tokobagus.betterb:id/postAdBtn";
	private String selesaiInputHargaID="com.app.tokobagus.betterb:id/buttonDefaultPositive";
	private String tipeKendaraanID="android:id/text1";
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
	
	
	
	public JualIklanPage(WebDriver driver) {
		super(driver);
	}
 
	@Step("Set Element Jual Iklan Pertama")
	public void setElementJualIklan(){
		List<WebElement> elementsTextPasang = getListElements(getIdLocator(textFieldID));
		this.judulIklan = elementsTextPasang.get(0);
		this.deskripsiIklan = elementsTextPasang.get(1);
		this.namaPengiklan = elementsTextPasang.get(2);
		//this.emailPengiklan = elementsTextPasang.get(3);
		//this.pinBBPengiklan = elementsTextPasang.get(4);
		//this.telpPengiklan = elementsTextPasang.get(5);
		
		List<WebElement> elementsButtonPasang = getListElements(getIdLocator(chooserButtonID));
		this.kategoriIklan = elementsButtonPasang.get(0);
		//this.lokasiIlkan = elementsButtonPasang.get(1);
	}
	
	@Step("Set Judul Iklan Kedua")
	public void setElementJualIklanKedua(){ //after set judul, deskripsi dan kategori
		List<WebElement> elementsButtonPasang = getListElements(getIdLocator(chooserButtonID));
		this.hargaButton = elementsButtonPasang.get(0);
		this.tipeKendaraanButton = elementsButtonPasang.get(1);
	}
	
	@Step("Set Element Jual Iklan Ketiga")
	public void setElementJualIklanKetiga(){
		List<WebElement> elementsChooserBtn = getListElements(getTextLocator(chooserButtonID));
		this.hargaButton = elementsChooserBtn.get(0);
		this.tipeKendaraanButton = elementsChooserBtn.get(1);
		List<WebElement> elementsTextPasang = getListElements(getIdLocator(textFieldID));
		this.emailPengiklan = elementsTextPasang.get(1);
		this.pinBBPengiklan = elementsTextPasang.get(2);
		this.telpPengiklan = elementsTextPasang.get(3);
	}

	@Step("Verify Error Notifcation on All Element")
	public void verifyAllErrorNotification(){
		List<WebElement> elementsTextError = getListElements(getIdLocator(errorMessageID));
		Assert.assertTrue(elementsTextError.get(0).getText().toLowerCase().contains("judul"));
		Assert.assertTrue(elementsTextError.get(1).getText().toLowerCase().contains("kategori"));
		Assert.assertTrue(elementsTextError.get(2).getText().toLowerCase().contains("deskripsi"));
		Assert.assertTrue(elementsTextError.get(3).getText().toLowerCase().contains("lokasi"));
		Assert.assertTrue(elementsTextError.get(4).getText().toLowerCase().contains("nama"));
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
	  }catch(NotFoundException e){
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
	
	@Step("Input Title Jual Iklan")
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

	@Step("Fill Harga Product")
	public void fillHargaProduct(){
		sendKeysElement(getIdLocator(textFieldID), "325000000");
	}
	
	@Step("Selesai set Harga Product")
	public void selesaiSetHargaProduct(){
		clickElement(getIdLocator(selesaiInputHargaID));
	}
	
	@Step("Set Tipe Kendaraan")
	public void setTipeKendaraan(){
		getTextElements(getIdLocator(tipeKendaraanID), 0).click();
	}
	
	@Step("Choose Lokasi")
	public LocationPage clickLocation(){
		lokasiIlkan.click();
		return new LocationPage(driver);
//		LocationPage locationPage = new LocationPage(driver);
//		locationPage.clickLocation("Jawa Barat");
//		locationPage.clickLocation("Bandung Kota");
	}
	
	@Step("Input Nama")
	public void setNama(String keys){
		namaPengiklan.sendKeys(keys);
	}
	
	@Step("Input Telp")
	public void setTelp(String keys){
	    telpPengiklan.sendKeys(keys);	
	}
	
	@Step("Choose Kategori Mobil")
	public KategoriPage clickCategoryMobil(){
		kategoriIklan.click();
		return new KategoriPage(driver);
//		KategoriPage mobilKat = new KategoriPage(driver);
//		mobilKat.clickCategory("Mobil");
//		mobilKat.clickCategory("Mobil Bekas");
//		mobilKat.clickCategory("BMW");
	}
	
}
