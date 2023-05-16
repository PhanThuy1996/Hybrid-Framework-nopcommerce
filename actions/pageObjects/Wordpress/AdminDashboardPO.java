package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;
	public AdminDashboardPO(WebDriver driver) {
		this.driver=driver;
	}
	public AdminPostAddNewPO clickToPostMenuLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);	
		
	}
}
