package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.JualIklanPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Features("Jual Iklan Features")
public class JualIklanPageTest extends AndroidSetup{
    private JualIklanPage jualIklan;
	
	@BeforeClass
	public void setUp() throws Exception{
		prepareAndroidForAppium();
        System.out.println("Jual Iklan Page Running on ...");
	}
	
	@AfterClass
	 public void tearDown() throws Exception {
	    	System.out.println("Jual Iklan Page Page Quit");
	        driver.quit();
	 }
	
	@Test(priority=1)
	 @Stories("As A User I Want to Be Able to Sell Product")
	 @TestCaseId("TC_ADR_006_001")
	 @Title("As A User I Want to Be Able to Sell Product")
	 public void postAnAds() throws Exception{
		 HomePage homepage = new HomePage(driver);
		 jualIklan = homepage.clickJualIklan();
         jualIklan.setElementJualIklan();
         jualIklan.clickImageButonIklan();
         jualIklan.chooseGaleryImage();
         jualIklan.captureImageFromCamera();
         driver.scrollTo("Nama");
         jualIklan.setElementJualIklanKedua();
	 }
}
