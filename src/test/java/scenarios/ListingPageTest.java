package scenarios;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
  @TestCaseId("TC_ADR_003_003")
  @Title("Verify Filter On Listing Page - Uncheck Cari Dalam Deskripsi - Input Keyword")
  public void setFilterOnListingPageKeyword() throws Exception{
	  System.out.println("--Verify Filter On Listing Page");
	  FilterPage filter = listing.clickFilter();
	  filter.uncheckCariDalamDeskripsi();
	  filter.fillKeyword(mobilKeyword);
	  Thread.sleep(2000);//wait autocomplete form appear
	  listing.clickActionBar();//choose filter from input not autocomplete module
	  listing = filter.clickFilterSubmitButton();//click submit button
	  listing.verifyResultFilterByKeyword(mobilKeyword);
  }
  
  @DataProvider(name = "DataRangeHarga")
  public Object[][] createData() {
      Object[][] retObjArr={{50000000,100000000},
                            {75000000,75000000},
                            {100000000,75000000},
                            {0,0}
                           };
      return(retObjArr);
  }
  
  //@Test(priority=4,dataProvider="DataRangeHarga")
  @Stories("As A User I want to be able to set Filter on Listing Page")
  @TestCaseId("TC_ADR_003_004")
  @Title("Verify Filter On Listing Page - Set Range Harga")
  public void setFilterOnListingPagePrice(int fromHarga, int toHarga) throws Exception{
	  System.out.println("Verify Filter On Listing Page - Set Range Harga");
	  FilterPage filter = listing.clickFilter();
	  //filter.clickClearFilter();
	  filter.fillKeyword("");
	  filter.clickHargaButtonFromElements();
	  filter.setFromHargaFromElements(String.valueOf(fromHarga));
	  filter.setToHargaFromElements(String.valueOf(toHarga));
	  filter.clickSelesaiChooseHarga();
	  filter.clickFilterSubmitButton();
	  listing.verifyResultFilterByPriceRange(fromHarga, toHarga);
  }
  
  @Test(priority=5)
  @Stories("As A User I want to be able to Sort Price Product")
  @TestCaseId("TC_ADR_003_005")
  @Title("Verify Price Sort Cheapest")
  public void verifyPriceSortCheapest()throws Exception{
     listing.chooseHargaTermurah();
     listing.verifySort("Termurah");
  }
  
  @Test(priority=6)
  @Stories("As A User I want to be able to Sort Price Product")
  @TestCaseId("TC_ADR_003_006")
  @Title("Verify Price Sort Most Expensive")
  public void verifyPriceSortExpensive()throws Exception{
     listing.chooseHargaTermahal();
     listing.verifySort("Termahal");
  }
  
}
