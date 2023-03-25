package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Facebook.LoginUI;

public class loginPageObject extends BasePage{
	WebDriver driver;
	public loginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickRegisterNewButton() {
		waitForElementClickable(driver, LoginUI.REGISTER_NEW_BUTTON);
		clickToElement(driver, LoginUI.REGISTER_NEW_BUTTON);	
	}
	public boolean verifyEmailTextboxDisplayed() {
		waitForElementVisible(driver, LoginUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver,  LoginUI.EMAIL_TEXTBOX);
	}
	public void inputEmailTextboxByValue(String textValue) {
		waitForElementVisible(driver, LoginUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginUI.EMAIL_TEXTBOX, textValue);
	}
	public boolean verifyConfirmTextboxDisplayed() {
		waitForElementVisible(driver, LoginUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplayed(driver,  LoginUI.CONFIRM_EMAIL_TEXTBOX);
	}
	public void clearTextInTextbox() {
		waitForElementVisible(driver, LoginUI.EMAIL_TEXTBOX);
		clearTextElement(driver, LoginUI.EMAIL_TEXTBOX);
		
	}
	public boolean verifyConfirmTextboxUnDisplayed() {
		return isElementUnDisplayed(driver, LoginUI.CONFIRM_EMAIL_TEXTBOX);
	}
	public void clickToClosePopup() {
		waitForElementVisible(driver, LoginUI.CLOSE_BUTTON);
		clickToElement(driver, LoginUI.CLOSE_BUTTON);
		
	}
}
