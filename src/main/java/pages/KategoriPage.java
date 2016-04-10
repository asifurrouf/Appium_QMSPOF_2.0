package pages;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class KategoriPage extends BasePage{

	public KategoriPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Choose Category {0}")//FOR PASANG IKLAN KATEGORY
	public void clickCategory(String category){
	    clickElement(getTextLocator(category));
	}

}
