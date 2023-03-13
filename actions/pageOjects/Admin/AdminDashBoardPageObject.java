package pageOjects.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.admin.AdminDashBoardPageUI;

public class AdminDashBoardPageObject extends BasePage{
	WebDriver driver;
	
	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_TEXT);
		return isElementDisplayed(driver,AdminDashBoardPageUI.DASHBOARD_TEXT);
		
	}
}
