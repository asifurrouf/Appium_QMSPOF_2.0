package pages;

import java.util.Iterator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class HeaderPage extends BasePage{
    private String kotaListingID="com.app.tokobagus.betterb:id/location";
    private String searchTextAreaID="com.app.tokobagus.betterb:id/search_src_text";
  
	
	public HeaderPage(WebDriver driver) {
		super(driver);
	}
	
	
	@Step("Choose Kota")
	public void clickKotaL1(String kotaL1){
	   clickElement(getTextLocator(kotaL1));	
	}
	
	@Step("Choose Sub Kota")
	public HomePage clickKotaL2(String kotaL2){
		clickElement(getTextLocator(kotaL2));
		return new HomePage(driver);
	}
	
	@Step("Fill Search Keyword")
	public void fillSearchKeyword(String keyword){
		sendKeysElement(getIdLocator(searchTextAreaID), keyword+"\n");
	}

	@Deprecated // move to listingPage function
	@Step("Verify Pilih Kota")
	public void verifyChooseKota(String kotaL2) throws Exception{
		System.out.println("Verify Pilih Kota");
		Iterator<WebElement> elements = getListElements(getIdLocator(kotaListingID)).iterator();
		boolean status=true;
		while (elements.hasNext()) {
			 String kota = elements.next().getText();
			 System.out.println("Search Result : "+kota);
			 if (!kota.contains(kotaL2)){
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
