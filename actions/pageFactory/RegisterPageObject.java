package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUI.user.UserRegisterPageUI;

public class RegisterPageObject extends BasePageFactory{
	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page UI
		@FindBy(how=How.XPATH,using="//input[@id ='FirstName']")
		private WebElement firstNameTextbox;
		
		@FindBy(xpath="//input[@id ='LastName']")
		private WebElement lastNameTextbox;
		
		@FindBy(xpath="//input[@id ='Email']")
		private WebElement emailTextBox;
		
		@FindBy(xpath="//input[@id ='Password']")
		private WebElement passwordTextbox;
		
		@FindBy(xpath="//input[@id ='ConfirmPassword']")
		private WebElement confirmTextbox;
		
		@FindBy(xpath="//button[@id='register-button']")
		private WebElement registerButton;
		
		@FindBy(xpath="//span[@id ='FirstName-error']")
		private WebElement firstNameErrorMessage;
		
		@FindBy(xpath="//span[@id ='LastName-error']")
		private WebElement lastNameErrorMessage;
		
		@FindBy(xpath="//span[@id ='Email-error']")
		private WebElement emailErrorMessage;
		
		@FindBy(xpath="//span[@id ='Password-error']")
		private WebElement passwordErrorMessage;
		
		@FindBy(xpath="//span[@id ='ConfirmPassword-error']")
		private WebElement confirmPasswordErrorMessage;
		
		@FindBy(xpath="//div[@class ='result']")
		private WebElement registerSucessMessage;
		
		@FindBy(xpath="//div[contains(@class,'message-error')]//li")
		private WebElement existingEmailErrorMessage;
		
		@FindBy(xpath="//a[@class='ico-logout']")
		private WebElement logoutLink;
		
		
		public String getTextFirstNameError() {
			waitForElementVisible(driver, firstNameErrorMessage);
			return getElementText(driver, firstNameErrorMessage);
		}
		
		public String getTextLastNameError() {
			waitForElementVisible(driver, lastNameErrorMessage);
			return getElementText(driver, lastNameErrorMessage);
		}
		
		public String getTextEmailError() {
			waitForElementVisible(driver, emailErrorMessage);
			return getElementText(driver, emailErrorMessage);
		}
		
		public String getTextPasswordError() {
			waitForElementVisible(driver, passwordErrorMessage);
			return getElementText(driver, passwordErrorMessage);
		}

		public String getTextConfirmPasswordError() {
			waitForElementVisible(driver, confirmPasswordErrorMessage);
			return getElementText(driver, confirmPasswordErrorMessage);
		}
		
		public String getTextRegisterResult() {
			waitForElementVisible(driver, registerSucessMessage);
			return getElementText(driver, registerSucessMessage);
		}

		public void clickToRegisterButton() {
			waitForElementClickable(driver, registerButton);
			clickToElement(driver, registerButton);
			
		}
		
		public void sendTextToFirstNameTextBox(String firstNameText) {
			waitForElementVisible(driver, firstNameTextbox);
			sendKeyToElement(driver, firstNameTextbox, firstNameText);
		}

		public void sendTextToLastNameTextBox(String lastNameText) {
			waitForElementVisible(driver, lastNameTextbox);
			sendKeyToElement(driver, lastNameTextbox, lastNameText);
		}

		public void sendTextToEmailTextBox(String emailAdressText) {
			waitForElementVisible(driver, emailTextBox);
			sendKeyToElement(driver, emailTextBox, emailAdressText);
			
		}

		public void sendTextPasswordTextBox(String passwordText) {
			waitForElementVisible(driver, passwordTextbox);
			sendKeyToElement(driver, passwordTextbox, passwordText);	
		}
		
		public void sendTextToConfirmPasswordTextBox(String confirmPasswordText) {
			waitForElementVisible(driver, confirmTextbox);
			sendKeyToElement(driver, confirmTextbox, confirmPasswordText);	
		}

		public void clickLogoutLink() {
			waitForElementClickable(driver, logoutLink);
			clickToElement(driver, logoutLink);
			
		}

		public String getExistEmailErrorMessage() {
			waitForElementVisible(driver, existingEmailErrorMessage);
			return getElementText(driver, existingEmailErrorMessage);
		}
}
