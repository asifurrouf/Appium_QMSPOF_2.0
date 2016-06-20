package scenarios;
import org.testng.annotations.*;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MobilPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({ScreenshootsListener.class})
@Features ("Homepage Feature")
public class HomePageTest extends AndroidSetup {
	HomePage homepage;
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_001_001")
   	@Title("Verify All Link Available")
   	@Test
   	public void verifyAllCategoryAndLink(){
		homepage = new HomePage(driver);
		homepage.clickLocationNotif();
		homepage.getTextMobilLink();
		homepage.getTextMotorLink();
		homepage.getTextPropertyLink();
		homepage.getTextKeperluanPribadiLink();
		homepage.getTextElectronicLink();
		homepage.getTextHobiLink();
		homepage.getTextRumahTanggaLink();
		homepage.getTextPerlengkapanBayiLink();
		homepage.getPostAdsLink();
		homepage.getLokasiLink();
		homepage.getImageDrawer();
	}
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_002")
   	@Title("Verify Motor Link Available")
   	//@Test
   	public void verifyMotorLink(){
		homepage.getTextMotorLink();
	}
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_003")
   	@Title("Verify Property Link Available")
   	//@Test
   	public void verifyPropertyLink(){
		homepage.getTextPropertyLink();
	}
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_004")
   	@Title("Verify Keperluan Pribadi Link Available")
   	//@Test
   	public void verifyKeperluanPribadiLink(){
		homepage.getTextKeperluanPribadiLink();
	}

	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_005")
   	@Title("Verify Electronic Available")
   	//@Test
   	public void verifyElectronicLink(){
		homepage.getTextElectronicLink();
	}
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_006")
   	@Title("Verify Hobi Available")
   	//@Test
   	public void verifyHobiLink(){
		homepage.getTextHobiLink();
	}
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_007")
   	@Title("Verify Hobi Available")
   	//@Test
   	public void verifyRumahTanggaLink(){
		homepage.getTextRumahTanggaLink();
	}
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_008")
   	@Title("Verify Perlengkapan Bayi Available")
   	//@Test
   	public void verifyPerlengkapanBayiLink(){
		homepage.getTextPerlengkapanBayiLink();
	}
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_009")
   	@Title("Verify PostAds Link Available")
   	//@Test
   	public void verifyPostAdsLink(){
		homepage.getPostAdsLink();
	}
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_010")
   	@Title("Verify PostAds Link Available")
   	//@Test
   	public void verifyLokasiLink(){
		homepage.getLokasiLink();
	}
	
	@Stories("As A User I Want to be Able to Go to Verify Homepage Menu")
   	@TestCaseId("TC_ADR_002_011")
   	@Title("Verify Image Drawer Link Available")
   	//@Test
   	public void verifyImageDrawerLink(){
		homepage.getImageDrawer();
	}
}
