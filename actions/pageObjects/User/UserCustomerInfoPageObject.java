package pageObjects.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage{
	WebDriver driver;
	
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}



	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.TITLE_PAGE);
		return isElementDisplayed(driver, UserCustomerInfoPageUI.TITLE_PAGE);
	}

}