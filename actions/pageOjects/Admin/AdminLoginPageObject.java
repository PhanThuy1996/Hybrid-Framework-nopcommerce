package pageOjects.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.user.UserLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminDashBoardPageObject clickToElement() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoardPage(driver);				
	}
	public void sendTextToEmailTextBox(String emailText) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailText);
	}
	public void sendTextPasswordTextBox(String passwordText) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, passwordText);
	}
	
	public AdminDashBoardPageObject loginAtAdminPage(String emailText,String passwordText) {
		sendTextToEmailTextBox(emailText);
		sendTextPasswordTextBox(passwordText);
		clickToElement();
		return PageGeneratorManager.getAdminDashBoardPage(driver);	
	}


}
