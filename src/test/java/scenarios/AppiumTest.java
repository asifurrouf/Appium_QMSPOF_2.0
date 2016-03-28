package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.*;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;


//Represent Homepage initial test, click mobile and back three times
@Features("Mobil Advertising Nexus One")
public class AppiumTest extends AndroidSetup {
    protected HomePage homepage;
    
    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        homepage=new HomePage(driver);
        System.out.println("Running on Appium 1");
    }

    @AfterClass
    public void tearDown() throws Exception {
    	//driver.closeApp();
    	System.out.println("Appium 1 Quit");
        driver.quit();
        //prepareAndroidForAppium();
        //Thread.sleep(10000);
    }
    
    @Test
	@Stories("As A User I Want to be Able to Go to Mobile Nexus Link")
	@TestCaseId("TC_ADR_001_001")
	@Title("Click Mobile and Go Back Again")
    public void clickMobilPage(){
    	homepage.clickMobilLink();
    	System.out.println("Appium1-1");
    }
    
    @Test
   	@Stories("As A User I Want to be Able to Go to Mobile Nexus Link")
   	@TestCaseId("TC_ADR_001_002")
   	@Title("Click Mobile and Go Back Again")
    public void clickMobilPage2(){
    	homepage.clickMobilLink();
    	System.out.println("Appium1-2");
    }
    
    @Test
   	@Stories("As A User I Want to be Able to Go to Mobile Nexus Link")
   	@TestCaseId("TC_ADR_001_003")
   	@Title("Click Mobile and Go Back Again")
    public void clickMobilPage3(){
    	homepage.clickMobilLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium1-3");
    }
    
   // @Test
   	@Stories("As A User I Want to be Able to Go to Mobile Nexus Link")
   	@TestCaseId("TC_ADR_001_004")
   	@Title("Click Mobile and Go Back Again")
    public void clickMobilPage4(){
    	homepage.clickMobilLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium1-4");
    }
    
  //  @Test
   	@Stories("As A User I Want to be Able to Go to Mobile Nexus Link")
   	@TestCaseId("TC_ADR_001_005")
   	@Title("Click Mobile and Go Back Again")
    public void clickMobilPage5(){
    	homepage.clickMobilLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium1-5");
    }
    
  //  @Test
   	@Stories("As A User I Want to be Able to Go to Mobile Nexus Link")
   	@TestCaseId("TC_ADR_001_006")
   	@Title("Click Mobile and Go Back Again")
    public void clickMobilPage6(){
    	homepage.clickMobilLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium1-6");
    }
    
   // @Test
   	@Stories("As A User I Want to be Able to Go to Mobile Nexus Link")
   	@TestCaseId("TC_ADR_001_007")
   	@Title("Click Mobile and Go Back Again")
    public void clickMobilPage7(){
    	homepage.clickMobilLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium1-7");
    }
    
   // @Test
   	@Stories("As A User I Want to be Able to Go to Mobile Nexus Link")
   	@TestCaseId("TC_ADR_001_008")
   	@Title("Click Mobile and Go Back Again")
    public void clickMobilPage8(){
    	homepage.clickMobilLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium1-8");
    }
    //@Test
    public void falseLoginTest() throws InterruptedException
    {
        new LoginPage(driver).invalidLogin();
    }

    //@Test
    public void testProductSearch(){

        new LandingPage(driver).chooseToBrowseItems()
                                .searchFor("iphone");
    }


    //@Test
    public void testAddToCart(){
        new LandingPage(driver).chooseToBrowseItems()
                .searchFor("iphone")
                .selectFirstResultFor("iphone")
                .addToCart("iphone")
                .verifyCartShowsTheCount();
    }

    //@Test
    public void testSwipeOnHomePage()  {
        new LandingPage(driver).swipeFromLeftToPullMenu();

    }

    //@Test
    public  void testScrollUponHomePageAndTapAction(){
        new LandingPage(driver).scrollPageUpAndClickOnRefrigerator();

    }
}

