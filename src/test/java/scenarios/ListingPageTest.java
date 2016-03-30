package scenarios;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FilterPage;
import pages.HomePage;
import pages.ListingPage;
import pages.MobilPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Features("Listing Page Feature")
public class ListingPageTest extends AndroidSetup{
  protected ListingPage listing;
  private String mobilKeyword="Ertiga";
  
  @BeforeClass
  public void setUp() throws Exception{
	  prepareAndroidForAppium();
      System.out.println("Listing Page Feature Running on ...");
  }
  
  @AfterClass
  public void tearDown() throws Exception {
  	System.out.println("MobilPage Quit");
      driver.quit();
  }
  
  @Test(priority=1)
  @Stories("As A User I Want to be Able to Verify Mobil Menu")
  @TestCaseId("TC_ADR_003_001")
  @Title("Verify All Mobil Link Available")
  public void verifyAllMobilLink(){
	  System.out.println("--Verify All Mobil Link Available");
	  HomePage homepage = new HomePage(driver);
	  MobilPage mobil = homepage.clickMobilPage();
	  mobil.getSemuaMobilLink();
	  mobil.getMobilBekasLink();
	  mobil.getAksesorisLink();
	  mobil.getAudioMobilLink();
	  mobil.getSparepartLink();
	  mobil.getVelgDanBanLink();
  }
  
  @Test(priority=2)
  @Stories("As A User I want to be able to go to see Semua Mobil Menu")
  @TestCaseId("TC_ADR_003_002")
  @Title("Verify Mobile Listing Page")
  public void verifySemuaMobilAppear(){
	  System.out.println("--Verify Mobile Listing Page");
	  MobilPage mobil = new MobilPage(driver);
	  this.listing = mobil.clickSemuaMobilLink();
	  listing.getFilterOnMobilBottomResultPage(); 
	  listing.verifyOpenedPageSemuaMobilLink("Semua di Mobil");
  }
  
  @Test(priority=3)
  @Stories("As A User I want to be able to set Filter on Listing Page")
  @TestCaseId("TC_ADR_003_002")
  @Title("Verify Filter On Listing Page - Uncheck Cari Dalam Deskripsi")
  public void setFilterOnListingPage() throws Exception{
	  System.out.println("--Verify Filter On Listing Page");
	  FilterPage filter = listing.clickFilter();
	  filter.uncheckCariDalamDeskripsi();
	  filter.fillKeyword(mobilKeyword);
	  listing.clickActionBar();//choose filter from input not autocomplete module
	  listing = filter.clickFilterSubmitButton();//click submit button
	  listing.iterateValueFilter(mobilKeyword);
  }
  
   
  //@Test - Sort Price is NAT = True (should be change by Dev)
  //@Test(priority=3)
  @Stories("As A User I want to be able to Sort Price Product")
  @TestCaseId("TC_ADR_003_00X")
  @Title("Verify Price Sort Cheapest")
  public void verifyPriceSortCheapest(){
     listing.chooseHargaTermurah();
  }
  
}
