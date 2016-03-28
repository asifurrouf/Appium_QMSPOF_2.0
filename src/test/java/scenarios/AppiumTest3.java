package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;


//Represent Homepage initial test, click mobile and back three times
@Features("Property Advertising Nexus Two")
public class AppiumTest3 extends AndroidSetup {
    protected HomePage homepage;
    
    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        homepage=new HomePage(driver);
        System.out.println("Running on Appium 3");
    }
  //clickPropertyLink()
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("Appium 3 Quit");
        Thread.sleep(2000);
    }
    
   	@Stories("As A User I Want to be Able to Go to Property Nexus Link")
   	@TestCaseId("TC_ADR_003_001")
   	@Title("Click Nexus and Go Back Again 1")
   	@Test
    public void clickPropertyPage(){
    	homepage.clickPropertyLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium3-1");
    }
    
    @Test
   	@Stories("As A User I Want to be Able to Go to Property Nexus Link")
   	@TestCaseId("TC_ADR_003_002")
   	@Title("Click Nexus and Go Back Again 2")
    public void clickPropertyPage2(){
    	homepage.clickPropertyLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium3-2");
    }
    
    @Test
   	@Stories("As A User I Want to be Able to Go to Property Nexus Link")
   	@TestCaseId("TC_ADR_003_003")
   	@Title("Click Nexus and Go Back Again 3")
    public void clickPropertyPage3(){
    	homepage.clickPropertyLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium3-3");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Property Nexus Link")
   	@TestCaseId("TC_ADR_003_004")
   	@Title("Click Nexus and Go Back Again 4")
    public void clickPropertyPage4(){
    	homepage.clickPropertyLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium3-4");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Property Nexus Link")
   	@TestCaseId("TC_ADR_003_005")
   	@Title("Click Nexus and Go Back Again 5")
    public void clickPropertyPage5(){
    	homepage.clickPropertyLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium3-5");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Property Nexus Link")
   	@TestCaseId("TC_ADR_003_006")
   	@Title("Click Nexus and Go Back Again 6")
    public void clickPropertyPage6(){
    	homepage.clickPropertyLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium3-6");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Property Nexus Link")
   	@TestCaseId("TC_ADR_003_007")
   	@Title("Click Nexus and Go Back Again 7")
    public void clickPropertyPage7(){
    	homepage.clickPropertyLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium3-7");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Property Nexus Link")
   	@TestCaseId("TC_ADR_003_008")
   	@Title("Click Nexus and Go Back Again 8")
    public void clickPropertyPage8(){
    	homepage.clickPropertyLink();
    	//homepage.clickBackButton();
    	System.out.println("Appium3-8");
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

