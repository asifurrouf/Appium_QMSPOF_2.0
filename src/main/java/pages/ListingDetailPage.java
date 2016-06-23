package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Iterator;
import java.util.List;

/**
 * Created by buddyarifin on 6/23/16.
 */
public class ListingDetailPage extends BasePage{
    protected static String priceId = "com.app.tokobagus.betterb:id/price";
    protected static String titleId = "com.app.tokobagus.betterb:id/title";
    protected static String adViewsText = "com.app.tokobagus.betterb:id/adViewsText";
    protected static String listAdSeller = "com.app.tokobagus.betterb:id/linkUserAds";
    protected static String reportAd = "com.app.tokobagus.betterb:id/btnReport";
    protected static String listContact = "com.app.tokobagus.betterb:id/contactBtnsContainer";

    public ListingDetailPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify All Details Ad page ")
    public void verifyAllDetailsAds(String title){
        verifyTitleDisplay(title);
        verifyPriceDisplay();
        verifyAdViewsCount();
        verifyReportAd();
        verifyListContact();

    }

    @Step("Verify Title display")
    public void verifyTitleDisplay(String title) {
        System.out.println("Veriy Title display");
        Assert.assertTrue(getStringText(getIdLocator(titleId)).equalsIgnoreCase(title));
    }

    @Step("Verify Price display")
    public void verifyPriceDisplay() {
        System.out.println("Veriy Price display");
        Assert.assertTrue(isElementPresent(getIdLocator(priceId)));
    }

    @Step("Verify Dilihat : display")
    public void verifyAdViewsCount() {
        System.out.println("Veriy AdViewCount display");
        ((AndroidDriver)driver).scrollTo("Laporkan");
        Assert.assertTrue(isElementPresent(getIdLocator(adViewsText)));

    }

    @Step("Verify Laporkan display")
    public void verifyReportAd() {
        System.out.println("Veriy Laportkan display");
        ((AndroidDriver)driver).scrollTo("Laporkan");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(reportAd)));

    }

    @Step("Verify List Ads for Current Seller display")
    public ListingDetailPage clickListAdsCurrentSeller() {
        return new ListingDetailPage(driver);
    }

    @Step("Verify Contact available of Seller display")
    public void verifyListContact() {
        List<WebElement> contactList = getListElements(getIdLocator(listContact)).iterator().next()
                .findElements(By.className("android.widget.LinearLayout"));
        System.out.print("Contact Available : ");
        for( int i=0 ;i < contactList.size(); i++) {
            String contact = contactList.get(i).findElement(By.className("android.widget.TextView")).getText();
            System.out.print(contact+" ");
            Assert.assertNotNull(contact);
        }
    }
}
