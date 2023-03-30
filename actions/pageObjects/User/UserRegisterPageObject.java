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

	public String getTextConfirmPasswordError() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	
	public String getTextRegisterResult() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_RESULT_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_RESULT_MESSAGE);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		
	}
	
	public void sendTextToFirstNameTextBox(String firstNameText) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstNameText);
	}

	public void sendTextToLastNameTextBox(String lastNameText) {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastNameText);
	}

	public void sendTextToEmailTextBox(String emailAdressText) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAdressText);
		
	}

	public void sendTextPasswordTextBox(String passwordText) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, passwordText);	
	}
	
	public void sendTextToConfirmPasswordTextBox(String confirmPasswordText) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordText);	
	}

	public UserHomePageObject clickLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOG_OUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}

	public String getExistEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
	}


}
