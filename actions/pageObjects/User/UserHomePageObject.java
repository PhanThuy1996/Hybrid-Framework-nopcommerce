package pageObjects.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUI.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Open Register Page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	@Step("Open Login Page")
	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	@Step("Get URL Home Page")
	public String getURLHomePage() {
		return getCurrentURL(driver);
	}
	@Step("Open My Account Page")
	public UserCustomerInfoPageObject openMyAccountPage() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}
	@Step("Verify My Account link displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}


}
