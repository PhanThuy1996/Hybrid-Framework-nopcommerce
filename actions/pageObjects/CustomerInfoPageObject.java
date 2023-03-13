package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage{
	WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}



	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(driver, CustomerInfoPageUI.TITLE_PAGE);
		return isElementDisplayed(driver, CustomerInfoPageUI.TITLE_PAGE);
	}

}