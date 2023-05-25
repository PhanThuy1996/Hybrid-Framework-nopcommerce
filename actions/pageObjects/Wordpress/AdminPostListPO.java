package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Wordpress.AdminPostListPageUI;

public class AdminPostListPO extends BasePage{
	WebDriver driver;

	public AdminPostListPO(WebDriver driver) {
		this.driver=driver;
	}

	public AdminPostAddNewPO clickAddNewButton() {
		waitForElementClickable(driver, AdminPostListPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostListPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void inputPostTitleInSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostListPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, AdminPostListPageUI.SEARCH_TEXTBOX, postTitle);	
	}

	public void clickToSearchPostButton() {
		waitForElementClickable(driver, AdminPostListPageUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver,  AdminPostListPageUI.SEARCH_POSTS_BUTTON);	
	}

	public boolean isResultMessageIsDisplayed(String postTitle) {
		waitForElementInVisible(driver, AdminPostListPageUI.RESULT_SEARCH_MESSAGE);
		String resultText= getElementText(driver, AdminPostListPageUI.RESULT_SEARCH_MESSAGE);
		if(resultText.equals(postTitle)){
			return true;
		}
		else
		return false;
	}

	public boolean isResultPostTilteIsDisplayed(String postTitle) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isResultPostAuthorIsDisplayed(String adminUsername) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isResultPostDateIsDisplayed(String dateCurrent) {
		// TODO Auto-generated method stub
		return true;
	}


}
