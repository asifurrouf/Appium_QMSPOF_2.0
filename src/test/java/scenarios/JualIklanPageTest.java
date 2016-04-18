package scenarios;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.JualIklanPage;
import pages.KategoriPage;
import pages.LocationPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Features("Jual Iklan Features")
public class JualIklanPageTest extends AndroidSetup{
    private JualIklanPage jualIklan;
    private String titleIklan="BMW 325i Silver 2013 Tiptronic";
    private String descIklan="BMW 325i warna silver tahun 2013. Tiptronic. Kondisi Mulus. Tanpa PR. Bensin selalu Shell";
    private String namaPengiklan="Frengky Sheeran";
    private String categoryL1="Mobil";
    private String categoryL2="Mobil Bekas";
    private String categoryL3="BMW";
    private String locationL1="Jawa Barat";
    private String locationL2="Bandung Kota";
	private String emailIklanRegistered="frengky.sheeran@gmail.com";
    private String telpIklan="081122334455";
    private String telpIklanInvalid="--------";
    private String hargaProduct="325000000";
    private String transmisi="Triptonic";
    private String emailIklanNotRegistered="frengky.orlend@gmail.com";
    private String passValid="frengky123.,";
    
    @Parameters({"udid"})
	@BeforeClass
	public void setUp(String udid) throws Exception{
		prepareAndroidForAppium(udid);
        System.out.println("Daftar Page Running on ...");
	}
	
	@AfterClass
	 public void tearDown() throws Exception {
	    	System.out.println("Jual Iklan Page Page Quit");
	        driver.quit();
	 }
	
	@AfterMethod
    public void onTestFailure(ITestResult testResult) throws IOException, Exception {
		//System.out.println("onTestFailure "+testResult.getStatus());
		BasePage bp =  new BasePage(driver);
      if(testResult.getStatus() == ITestResult.FAILURE){
    	  System.out.println("test result fail");
          bp.getAttachment("FailedOn_JualIklanPageTest."+testResult.getMethod().getMethodName()+".png");
          System.out.println("--FailedOn_JualIklanPageTest."+testResult.getMethod().getMethodName()+".png");
      }else{
    	  System.out.println("test result success");
    	  bp.getAttachment("SuccessOn_JualIklanPageTest."+testResult.getMethod().getMethodName()+".png");
    	  System.out.println("--SuccessOn_JualIklanPageTest."+testResult.getMethod().getMethodName()+".png");
      }
	}
	
	 @Test(priority=1)
	 @Stories("As A User I Wont Be Able to Sell Product")
	 @TestCaseId("TC_ADR_006_001")
	 @Title("Verify User Not Able to Post An Ads If All Field Blank")
	 public void verifyUserNotAbleToPostAnAdsIfAllFieldBlank() throws Exception{
		System.out.println("Verify User Not Able to Post An Ads If All Field Blank");
		HomePage homepage = new HomePage(driver);
		jualIklan = homepage.clickJualIklan();
		jualIklan.checkKembaliKePasangIklan();
        jualIklan.setElementJualIklan();
        driver.scrollTo("Nama");
        jualIklan.clickPasangIklanButton();
        jualIklan.verifyAllErrorNotification();
        driver.navigate().back();//back to homepage
	 }
	
	 @Test(priority=2)
	 @Stories("As A User I Wont Be Able to Sell Product")
	 @TestCaseId("TC_ADR_006_002")
	 @Title("Verify User Not Able to Post An Ads If Title Length Less Than 15, Description Less than 20, Email wrong Format, Phone Wrong Format")
	 public void verifyUserNotAbleToPostAnAdsIfElementsNotMeetCriteria() throws Exception{
		System.out.println("Verify User Not Able to Post An Ads If Title Length Less Than 15");
		HomePage homepage = new HomePage(driver);
		jualIklan = homepage.clickJualIklan();
		jualIklan.checkKembaliKePasangIklan();
        jualIklan.setElementJualIklan();
        KategoriPage kategori = jualIklan.clickCategoryMobil();
        kategori.clickCategory(categoryL1);
        kategori.clickCategory(categoryL2);
        kategori.clickCategory(categoryL3);
        jualIklan.setTitleJualIklan(titleIklan.substring(0,14));//Iklan Title Less Than 15
        jualIklan.setDescription(descIklan.substring(0,19));//Iklan deskripsi Less Than 20
        jualIklan.setElementJualIklanKedua();
        jualIklan.clickHargaChooserButton();
        jualIklan.fillHargaProduct(hargaProduct);
        jualIklan.selesaiSetHargaProduct();
        jualIklan.clickTipeKendaraanButton();
        jualIklan.setTipeKendaraan();
        //Page automatically scroll on Tipe Kendaraan Position
        jualIklan.setElementJualIklanKetiga();
        jualIklan.clickTransmisi();
        jualIklan.chooseTransmisi(transmisi);
        jualIklan.clickTahunPembuatan();
        jualIklan.setTahunPembuatan();//latest tahun pembuatan
        LocationPage location = jualIklan.clickLocation();
        location.clickLocation(locationL1);
        location.clickLocation(locationL2);
        driver.scrollTo("Telepon");
        jualIklan.setNama(namaPengiklan);
        jualIklan.setElementTelpPengiklan();
        jualIklan.setEmail(emailIklanRegistered.replace("@gmail.com", ""));//wrong email format
        jualIklan.setTelp(telpIklanInvalid);
        driver.scrollTo("Pasang iklan");
        jualIklan.clickPasangIklanButton();
        driver.scrollTo("Ambil foto");
        jualIklan.verifyErrorOnTitle();
        jualIklan.verifyErrorOnDesc();
        driver.scrollTo("Pasang iklan");
        jualIklan.verifyErrorPhone();
        driver.navigate().back();//back to homepage
	 }
	 	
	 @Test(priority=3)
	 @Stories("As A User I Want to Be Able to Sell Product")
	 @TestCaseId("TC_ADR_006_003")
	 @Title("Verify User Able to Post An Ads  - Email not Registered Before")
	 public void verifyUserAbleToPostAnAdsUnRegisteredUser() throws Exception{
		System.out.println("Verify User Able to Post An Ads  - Email UnRegistered Before");
		HomePage homepage = new HomePage(driver);
		jualIklan = homepage.clickJualIklan();
		jualIklan.checkKembaliKePasangIklan();
        jualIklan.setElementJualIklan();
	    KategoriPage kategori = jualIklan.clickCategoryMobil();
	    kategori.clickCategory(categoryL1);
	    kategori.clickCategory(categoryL2);
	    kategori.clickCategory(categoryL3);
	    jualIklan.setTitleJualIklan(titleIklan);
	    jualIklan.setDescription(descIklan);
	    jualIklan.setElementJualIklanKedua();
	    jualIklan.clickHargaChooserButton();
	    jualIklan.fillHargaProduct(hargaProduct);
	    jualIklan.selesaiSetHargaProduct();
	    jualIklan.clickTipeKendaraanButton();
	    jualIklan.setTipeKendaraan();
	        //Page automatically scroll on Tipe Kendaraan Position
	    jualIklan.setElementJualIklanKetiga();
	    jualIklan.clickTransmisi();
	    jualIklan.chooseTransmisi(transmisi);
	    jualIklan.clickTahunPembuatan();
	    jualIklan.setTahunPembuatan();//latest tahun pembuatan
	    LocationPage location = jualIklan.clickLocation();
	    location.clickLocation(locationL1);
	    location.clickLocation(locationL2);
	    driver.scrollTo("Telepon");
	    jualIklan.setNama(namaPengiklan);
	    jualIklan.setElementTelpPengiklan();
	    jualIklan.setEmail(emailIklanNotRegistered);//email not registered
	    jualIklan.setTelp(telpIklan);
	    driver.scrollTo("Pasang iklan");
	    jualIklan.clickPasangIklanButton();
	    jualIklan.verifySuccessPostingAds();
	    jualIklan.clickBacktoHomePage();
	 }
	 
	 @Test(priority=4)
	 @Stories("As A User I Want to Be Able to Sell Product")
	 @TestCaseId("TC_ADR_006_003")
	 @Title("Verify User Able to Post An Ads  - Email not Registered Before")
	 public void verifyUserAbleToPostAnAdsRegisteredUser() throws Exception{
		System.out.println("Verify User Able to Post An Ads  - Email Registered");
		HomePage homepage = new HomePage(driver);
		jualIklan = homepage.clickJualIklan();
		jualIklan.checkKembaliKePasangIklan();
        jualIklan.setElementJualIklan();
	    KategoriPage kategori = jualIklan.clickCategoryMobil();
	    kategori.clickCategory(categoryL1);
	    kategori.clickCategory(categoryL2);
	    kategori.clickCategory(categoryL3);
	    jualIklan.setTitleJualIklan(titleIklan);
	    jualIklan.setDescription(descIklan);
	    jualIklan.setElementJualIklanKedua();
	    jualIklan.clickHargaChooserButton();
	    jualIklan.fillHargaProduct(hargaProduct);
	    jualIklan.selesaiSetHargaProduct();
	    jualIklan.clickTipeKendaraanButton();
	    jualIklan.setTipeKendaraan();
	        //Page automatically scroll on Tipe Kendaraan Position
	    jualIklan.setElementJualIklanKetiga();
	    jualIklan.clickTransmisi();
	    jualIklan.chooseTransmisi(transmisi);
	    jualIklan.clickTahunPembuatan();
	    jualIklan.setTahunPembuatan();//latest tahun pembuatan
	    LocationPage location = jualIklan.clickLocation();
	    location.clickLocation(locationL1);
	    location.clickLocation(locationL2);
	    driver.scrollTo("Telepon");
	    jualIklan.setNama(namaPengiklan);
	    jualIklan.setElementTelpPengiklan();
	    jualIklan.setEmail(emailIklanRegistered);//email not registered
	    jualIklan.setTelp(telpIklan);
	    driver.scrollTo("Pasang iklan");
	    jualIklan.clickPasangIklanButton();
	    if (jualIklan.verifyIsEmailRegistered()){
	    	LoginPage loginP = jualIklan.clickLanjutLogin();	
	    	loginP.inputPassword(passValid);
		    loginP.clickSubmitLoginButton();
	    }
	    jualIklan.verifySuccessPostingAds();
	    jualIklan.clickBacktoHomePage();
	 }
}
