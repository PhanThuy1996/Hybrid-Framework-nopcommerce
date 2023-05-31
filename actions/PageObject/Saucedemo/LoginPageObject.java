package PageObject.Saucedemo;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Saucedemo.loginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputTextBoxByID(WebDriver driver, String textboxName, String textValue) {
		waitForElementVisible(driver, loginPageUI.TEXTBOX_BY_ID, textboxName);
		sendKeyToElement(driver, loginPageUI.TEXTBOX_BY_ID, textValue, textboxName);	
	}

	public ProductPageObject clickToButtonByText() {
		waitForElementClickable(driver,loginPageUI.LOGIN_BUTTON);
		clickToElement(driver, loginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}
	
}
