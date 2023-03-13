package pageObjects.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	WebDriver driver;
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getTextEmailError() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);				
	}
	public void sendTextToEmailTextBox(String emailText) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailText);
	}
	public void sendTextPasswordTextBox(String passwordText) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, passwordText);
	}
	public String getValidateErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.VALIDATE_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.VALIDATE_ERROR_MESSAGE);
	}
	
	public UserHomePageObject loginAtUserPage(String emailText,String passwordText) {
		sendTextToEmailTextBox(emailText);
		sendTextPasswordTextBox(passwordText);
		clickToLoginButton();
		return PageGeneratorManager.getUserHomePage(driver);	
	}

}
