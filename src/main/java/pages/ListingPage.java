package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class ListingPage extends BasePage {
	private String filterResultSearchSemuaMobilID="com.app.tokobagus.betterb:id/categoryBottomText";
	private String filterButtonID="com.app.tokobagus.betterb:id/filter";
	private String sortButton="com.app.tokobagus.betterb:id/sort";
	private String filterTerbaru="Terbaru";
	private String filterTermurah="Termurah";
	private String filterTermahal="Termahal";
	private String filterText="Filter";
	private String brandTextTitleMobil="com.app.tokobagus.betterb:id/title";
	private String actionBarID="com.app.tokobagus.betterb:id/action_bar";
	
	public ListingPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Verify Filter on Mobil Bottom Result Page")
	public void getFilterOnMobilBottomResultPage(){
		waitForVisibilityOf(getIdLocator(filterResultSearchSemuaMobilID));
	}
	
	@Step("Verify openPage{0}")
	public void verifyOpenedPageSemuaMobilLink(String verifyText){
		System.out.println("Verify openPageSemuaMobilLink");
		Assert.assertEquals(verifyText,driver.findElement(getIdLocator(filterResultSearchSemuaMobilID)).getText());
	}
	
	@Step("Go To Filter Page")
	public FilterPage clickFilter(){
		clickElement(getIdLocator(filterButtonID));
		return new FilterPage(driver);
	}
	
	@Step("Go To Sort Mode")
	private void clickSortPage(){
		clickElement(getIdLocator(sortButton));
	}
	
	@Step("Choose Harga Termurah")
	public void chooseHargaTermurah(){
		clickSortPage();
		clickElement(getTextLocator(filterTermurah));
	}
	
	@Step("Choose Harga Termahal")
	public void chooseHargaTermahal(){
		clickSortPage();
		clickElement(getTextLocator(filterTermahal));
	}
	
	@Step("Choose Harga Terbaru")
	public void chooseHargaTerbaru(){
		clickSortPage();
		clickElement(getTextLocator(filterTerbaru));
	}
	
	@Step("Click Action Bar")
	public void clickActionBar(){
		clickElement(getIdLocator(actionBarID));
	}
	
	@Step("Iterate Value from Result Search = {0}")
	public void iterateValueFilter(String keyword) throws Exception{
		System.out.println("--Iterate value from search mobil keyword");
		Boolean status=true;
		 List<WebElement> elements = driver.findElements(getIdLocator(brandTextTitleMobil));
		 Iterator<WebElement> program = elements.iterator();
		 while (program.hasNext()) {
		        String values = program.next().getText();
		        System.out.println(values.toUpperCase());
		        if (!values.toUpperCase().contains(keyword.toUpperCase())){
		        	status=false;
		        }
		    }
		 if (!status){
			 takeScreenShotInFile("iterateValueFilter.png");
			 getAttachment("iterateValueFilter.png");
			 Assert.fail("Please check the result from the attachment : iterateValueFilter.png");
		 }
	}
	
	@Attachment(value = "{0}", type = "image/png")
	public byte[] getAttachment(String filename) throws Exception{
		return attachScreenShot(filename);
	}
	
	
}
