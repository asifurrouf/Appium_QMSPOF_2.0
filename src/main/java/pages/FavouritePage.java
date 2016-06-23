package pages;

import java.util.List;

import java.util.Arrays;

import java.util.Iterator;
import java.util.List;

//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import ru.yandex.qatools.allure.annotations.Step;

public class FavouritePage extends BasePage{
    private String title;
	private String brandTitleID="com.app.tokobagus.betterb:id/title";
	private String faveIconID="com.app.tokobagus.betterb:id/circle";
	private String faveAdsList="com.app.tokobagus.betterb:id/card_view";
	
	public FavouritePage(WebDriver driver) {
		super(driver);
	}
	
	private String getTitleAds(){
       return getStringText(getIdLocator(brandTitleID));
	}
	
    
	@Step("Verify Favourite Ads Is Listed Successfully")
	public void verifyFaveListed(){
		Assert.assertTrue(getSizeElements(getIdLocator(faveAdsList))>0);
	}
	
	@Step("Click UnFave Ads")
	public void clickUnFave(){
		clickElement(getIdLocator(faveIconID));
	}
	
	@Step("Verify Favourite Ads Is Removed Successfully")
	public void verifyFaveUnlisted(){
		Assert.assertEquals(0, getSizeElements(getIdLocator(faveAdsList)));
	}
	
}
