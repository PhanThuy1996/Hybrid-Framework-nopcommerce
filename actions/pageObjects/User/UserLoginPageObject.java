package pageObjects.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUI.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	WebDriver driver;
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Get Error Message in Email ")
	public String getTextEmailError() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	@Step("Click To Login button}")
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);				
	}
	@Step("Enter to Email Textbox with value: {0}")
	public void sendTextToEmailTextBox(String emailText) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailText);
	}
	@Step("Enter to Password Textbox with value: {0}")
	public void sendTextPasswordTextBox(String passwordText) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, passwordText);
	}
	@Step("Get Validate Error Message")
	public String getValidateErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.VALIDATE_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.VALIDATE_ERROR_MESSAGE);
	}
	@Step("Login Page")
	public UserHomePageObject loginAtUserPage(String emailText,String passwordText) {
		sendTextToEmailTextBox(emailText);
		sendTextPasswordTextBox(passwordText);
		clickToLoginButton();
		return PageGeneratorManager.getUserHomePage(driver);	
	}

}
