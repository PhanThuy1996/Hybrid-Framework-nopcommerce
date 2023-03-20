package PageObject.Jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Jquery.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToPagingByNumber(int pageNumber) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, Integer.toString(pageNumber));
		clickToElement(driver,HomePageUI.DYNAMIC_PAGE_LINK, Integer.toString(pageNumber));		
	}

	public void verifyPageSelected(int pageNumber) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_ACTIVE_PAGE_LINK, Integer.toString(pageNumber));
		clickToElement(driver,HomePageUI.DYNAMIC_ACTIVE_PAGE_LINK, Integer.toString(pageNumber));
		
	}

	public void sendkeysToTextboxByValue(String label, String textValue) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_FITLER_TEXTBOX, label);
		sendKeyToElement(driver, HomePageUI.DYNAMIC_FITLER_TEXTBOX, textValue, label);
		
	}
	
}
