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
@Features("Motor Advertising Nexus Two")
public class AppiumTest2 extends AndroidSetup {
    protected HomePage homepage;
    
    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        homepage=new HomePage(driver);
        System.out.println("Running on Appium 2");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("Appium 2 Quit");
        Thread.sleep(2000);
    }
    
   	@Stories("As A User I Want to be Able to Go to Motor Nexus Link")
   	@TestCaseId("TC_ADR_002_001")
   	@Title("Click Nexus and Go Back Again 1")
   	@Test
    public void clickMotorPage(){
    	homepage.clickMotorLink();
    	System.out.println("Appium2-1");
    }
    
    @Test
   	@Stories("As A User I Want to be Able to Go to Motor Nexus Link")
   	@TestCaseId("TC_ADR_002_002")
   	@Title("Click Nexus and Go Back Again 2")
    public void clickMotorPage2(){
    	homepage.clickMotorLink();
    	System.out.println("Appium2-2");
    }
    
    @Test
   	@Stories("As A User I Want to be Able to Go to Motor Nexus Link")
   	@TestCaseId("TC_ADR_002_003")
   	@Title("Click Nexus and Go Back Again 3")
    public void clickMotorPage3(){
    	homepage.clickMotorLink();
    	System.out.println("Appium2-3");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Motor Nexus Link")
   	@TestCaseId("TC_ADR_002_004")
   	@Title("Click Nexus and Go Back Again 4")
    public void clickMotorPage4(){
    	homepage.getTextMotorLink();
    	homepage.clickBackButton();
    	System.out.println("Appium2-4");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Motor Nexus Link")
   	@TestCaseId("TC_ADR_002_005")
   	@Title("Click Nexus and Go Back Again 5")
    public void clickMotorPage5(){
    	homepage.getTextMotorLink();
    	homepage.clickBackButton();
    	System.out.println("Appium2-5");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Motor Nexus Link")
   	@TestCaseId("TC_ADR_002_006")
   	@Title("Click Nexus and Go Back Again 6")
    public void clickMotorPage6(){
    	homepage.getTextMotorLink();
    	homepage.clickBackButton();
    	System.out.println("Appium2-6");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Motor Nexus Link")
   	@TestCaseId("TC_ADR_002_007")
   	@Title("Click Nexus and Go Back Again 7")
    public void clickMotorPage7(){
    	homepage.getTextMotorLink();
    	homepage.clickBackButton();
    	System.out.println("Appium2-7");
    }
    
    //@Test
   	@Stories("As A User I Want to be Able to Go to Motor Nexus Link")
   	@TestCaseId("TC_ADR_002_008")
   	@Title("Click Nexus and Go Back Again 8")
    public void clickMotorPage8(){
    	homepage.getTextMotorLink();
    	homepage.clickBackButton();
    	System.out.println("Appium2-8");
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

