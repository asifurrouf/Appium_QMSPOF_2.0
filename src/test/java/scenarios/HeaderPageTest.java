package scenarios;

import org.testng.annotations.*;

import pages.HeaderPage;
import pages.HomePage;
import pages.ListingPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({ScreenshootsListener.class})
@Features("Header / Top Search Feature")
public class HeaderPageTest extends AndroidSetup{
	private HeaderPage headerPage;

	private String keyword="Ertiga";
	private String kotaL1="Jakarta";
	private String kotaL2="Seluruh Jakarta";
	
	 @Test(priority=1)
	 @Stories("As A User I Want to Be Able to Search in Header Page")
	 @TestCaseId("TC_ADR_005_001")
	 @Title("Verify User Able to Search in Header Page")
	 public void searchWithLocation() throws Exception{
		 System.out.println("Verify User Able to Search in Header Page");
		 HomePage homepage = new HomePage(driver);
		 homepage.clickLocationNotif();
		 headerPage = homepage.clickLocationChooser();
		 headerPage.clickKotaL1(kotaL1);//Jakarta
		 headerPage.clickSubKotaL2(kotaL2);//Seluruh Jakarta
		 ListingPage listing = homepage.clickSearchButton();
		 headerPage.fillSearchKeyword(keyword);
		 listing.verifyChooseKota(kotaL1);
		 listing.verifyResultFilterByKeyword(keyword);
	 }
	
	 @Test(priority=1)
	 @Stories("As A User I Want to Be Able to Search in Header Page")
	 @TestCaseId("TC_ADR_005_002")
	 @Title("Verify User Able to Search in Header Page")
	 public void searchWithLocationAndProduct() throws Exception{
		 System.out.println("Verify User Able to Search in Header Page");
		 HomePage homepage = new HomePage(driver);
		 headerPage = homepage.clickLocationChooser();
		 headerPage.clickKotaL1(kotaL1);//Bogor
		 headerPage.clickKotaL2(kotaL2);//Bogor Kota
		 ListingPage listing = homepage.clickSearchButton();
		 headerPage.fillSearchKeyword(keyword);
		 listing.verifyChooseKota(kotaL2);
		 listing.verifyResultFilterByKeyword(keyword);
	 }
	 
}
