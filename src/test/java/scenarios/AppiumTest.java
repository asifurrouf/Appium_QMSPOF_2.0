package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;


//Represent Homepage initial test, click mobile and back three times
public class AppiumTest extends AndroidSetup {
    HomePage homepage;
    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        homepage=new HomePage(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
    
    @Test
    public void clickMobilPage(){
    	homepage.clickMobilLink();
    }
    
    @Test
    public void clickMobilPage2(){
    	homepage.clickMobilLink();
    }
    
    @Test
    public void clickMobilPage3(){
    	homepage.clickMobilLink();
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

