package scenarios;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ListingDetailPage;
import pages.ListingPage;
import pages.MobilPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 6/23/16.
 */

@Listeners({ScreenshootsListener.class})
@Features("Listing Details Page")
public class ListingDetailPageTest extends AndroidSetup {
    protected ListingPage listingPage;
    protected ListingDetailPage detailPage;
    protected String title;

    @Test(priority=1)
    @Stories("As A User I want to be able to browse specified choosen product")
    @TestCaseId("TC_AD_005_001")
    @Title("Verify Detail Page")
    public void verifyUserAbleToBrowseSpecifiedProduct() {
        System.out.println("Verify Detail Ads Page ");
        HomePage homepage = new HomePage(driver);
        homepage.clickLocationNotif();
        MobilPage mobil = homepage.clickMobilPage();
        this.listingPage = mobil.clickSemuaMobilLink();
        this.title = listingPage.getFirstAdsTitle();
        this.detailPage = listingPage.clickAdsDetail();
        detailPage.verifyAllDetailsAds(title);
    }
}
