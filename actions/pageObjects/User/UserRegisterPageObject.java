package pageObjects.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUI.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Get Error in FirstName")
	public String getTextFirstNameError() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	@Step("Get Error in LastName")
	public String getTextLastNameError() {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}
	@Step("Get Error in Email")
	public String getTextEmailError() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	@Step("Get Error in Password")
	public String getTextPasswordError() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	@Step("Get Error in ConfirmPassword")
	public String getTextConfirmPasswordError() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	@Step("Get Text Register Result")
	public String getTextRegisterResult() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_RESULT_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_RESULT_MESSAGE);
	}
	@Step("Click to Register button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		
	}
	@Step("Enter to FirstName Textbox with value: {0}")
	public void sendTextToFirstNameTextBox(String firstNameText) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstNameText);
	}
	@Step("Enter to LastName Textbox with value: {0}")
	public void sendTextToLastNameTextBox(String lastNameText) {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastNameText);
	}
	@Step("Enter to Email Address Textbox with value: {0}")
	public void sendTextToEmailTextBox(String emailAdressText) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAdressText);
		
	}
	@Step("Enter to Password Textbox with value: {0}")
	public void sendTextPasswordTextBox(String passwordText) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, passwordText);	
	}
	@Step("Enter to ConfirmPassword Textbox with value: {0}")
	public void sendTextToConfirmPasswordTextBox(String confirmPasswordText) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordText);	
	}
	@Step("Click Logout link")
	public UserHomePageObject clickLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOG_OUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}
	@Step("Get Error Message Exist Email ")
	public String getExistEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
	}





}
