package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Wordpress.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{
	WebDriver driver;
	
	public AdminLoginPO(WebDriver driver) {
		this.driver=driver;
	}

	public void inputUserNameTextBox(String adminUsername) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUsername);	
	}

	public void inputPasswordTextBox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);		
	}

	public AdminDashboardPO clickLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);	
	}
	 
}
