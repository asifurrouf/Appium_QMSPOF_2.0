package pages;

import java.util.Iterator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class HeaderPage extends BasePage{
    private String kotaL1Text="Bogor";
    private String kotaL2Text="Bogor Kota";
    private String kotaListingID="com.app.tokobagus.betterb:id/location";
    private String searchTextAreaID="com.app.tokobagus.betterb:id/search_src_text";
  
	
	public HeaderPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@Step("Choose Kota")
	public void clickKotaL1(){
	   clickElement(getTextLocator(kotaL1Text));	
	}
	
	@Step("Choose Sub Kota")
	public HomePage clickKotaL2(){
		clickElement(getTextLocator(kotaL2Text));
		return new HomePage(driver);
	}
	
	@Step("Fill Search Keyword")
	public void fillSearchKeyword(String keyword){
		sendKeysElement(getIdLocator(searchTextAreaID), keyword+"\n");
	}

	
	@Step("Verify Pilih Kota")
	public void verifyChooseKota() throws Exception{
		System.out.println("Verify Pilih Kota");
		Iterator<WebElement> elements = getListElements(getIdLocator(kotaListingID)).iterator();
		boolean status=true;
		while (elements.hasNext()) {
			 String kota = elements.next().getText();
			 if (!kota.contains(kotaL2Text)){
				 status=false;
			 }
		}
		if (!status){
			getAttachment("verifyChooseKota.png");
			Assert.fail("Please check file verifyChooseKota.png");
		}else{
			getAttachment("verifyChooseKota.png");
			Assert.assertTrue(status);
		}
	}
	
	
}
