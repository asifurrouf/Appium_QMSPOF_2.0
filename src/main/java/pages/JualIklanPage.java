package pages;

import java.util.List;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	private WebElement judulIklan;
	private WebElement deskripsiIklan;
	private WebElement namaPengiklan;
	private WebElement emailPengiklan;
	private WebElement pinBBPengiklan; 
	private WebElement telpPengiklan;
	private WebElement kategoriIklan;
	private WebElement lokasiIlkan;
	
	
	
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
		this.lokasiIlkan = elementsButtonPasang.get(1);
	}
	
	@Step("Set Element Jual Iklan Kedua")
	public void setElementJualIklanKedua(){
		List<WebElement> elementsTextPasang = getListElements(getIdLocator(textFieldID));
		this.emailPengiklan = elementsTextPasang.get(1);
		this.pinBBPengiklan = elementsTextPasang.get(2);
		this.telpPengiklan = elementsTextPasang.get(3);
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
	   clickElement(getIdLocator(cameraButtonDoneID));
	}
	
}
