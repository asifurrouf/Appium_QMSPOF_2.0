package pages;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class LocationPage extends BasePage{

	public LocationPage(WebDriver driver) {
		super(driver);
	}

	@Step("Choose Lokasi {0}")//FOR PASANG IKLAN KATEGORY
	public void clickLocation(String location){
	    clickElement(getTextLocator(location));
	}

}
