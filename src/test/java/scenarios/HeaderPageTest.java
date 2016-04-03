package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HeaderPage;
import pages.HomePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
@Features("Header / Top Search Feature")
public class HeaderPageTest extends AndroidSetup{
	private HeaderPage headerPage;

	private String keyword="Ertiga";
	
	@BeforeClass
	public void setUp() throws Exception{
		prepareAndroidForAppium();
        System.out.println("Header Page Running on ...");
	}
	
	@AfterClass
	 public void tearDown() throws Exception {
	    	System.out.println("Header Page Quit");
	        driver.quit();
	 }
	
	 @Test(priority=1)
	 @Stories("As A User I Want to Be Able to Search in Header Page")
	 @TestCaseId("TC_ADR_005_001")
	 @Title("Verify User Able to Search in Header Page")
	 public void searchWithLocation() throws Exception{
		 HomePage homepage = new HomePage(driver);
		 headerPage = homepage.clickLocationChooser();
		 headerPage.clickKotaL1();//Bogor
		 headerPage.clickKotaL2();//Bogor Kota
		 headerPage = homepage.clickSearchButton();
		 headerPage.fillSearchKeyword(keyword);
		 headerPage.verifyChooseKota();
	 }
	
}
