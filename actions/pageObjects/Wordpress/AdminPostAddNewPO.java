package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Wordpress.AdminComonPageUI;
import pageUI.Wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage{
	WebDriver driver;
	public AdminPostAddNewPO(WebDriver driver) {
		this.driver =driver;
	}
	public void inputPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTBOX);
		sendKeyToElement(driver,  AdminPostAddNewPageUI.ADD_TITLE_TEXTBOX, postTitle);	
	}
	public void inputPostBody(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_ADD_BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_ADD_BODY_TEXTBOX);
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_BODY_TEXTBOX);
		sendKeyToElement(driver,  AdminPostAddNewPageUI.ADD_BODY_TEXTBOX, postBody);	
	}
	public void clickToPulishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);	
	}
	public void clickToPrePulishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);	
	}
	public boolean isMessagePostPublishOrUpdateDisplayed(String string) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISH_MESSAGE);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.POST_PUBLISH_MESSAGE);
	}
	public AdminPostListPO openPostListPage() {
		waitForElementClickable(driver, AdminComonPageUI.logoPage);
		clickToElement(driver, AdminComonPageUI.logoPage);
		return PageGeneratorManager.getAdminPostListPage(driver);
	}


}
