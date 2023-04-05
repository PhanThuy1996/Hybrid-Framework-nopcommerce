package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.User.UserCustomerInfoPageObject;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;
import pageObjects.User.UserRegisterPageObject;

public class Level_16_Page_Pattern extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAdress, password, gender, birthDay, birthMonth, birthYear;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Testing";
		emailAdress = "ThuyPhan96" + generalFakeNumber() + "@gmail.com";
		password = "123456";
		gender ="Male";
		birthDay="1";
		birthMonth="January";
		birthYear="1996";		
	}

	@Test
	public void User_01_Register() {
		log.info("Register- Step 01: Navigave to Resiter Page");
		registerPage = homePage.openRegisterPage();
		log.info("Register- Step 02: Select Gender ='"+gender+"'");
		registerPage.checkRadioButton(driver,gender);
		log.info("Register- Step 03: Enter to firstName textbox '" + firstName + "'");
		registerPage.inputTextBoxByID(driver, "FirstName", firstName);
		log.info("Register- Step 04: Enter to lastName textbox '" + lastName + "'");
		registerPage.inputTextBoxByID(driver, "LastName", lastName);
		log.info("Register- Step 05: Select Day/Month/Year ");
		registerPage.selectItemInDropdownByLabel(driver,"DateOfBirthDay",birthDay);
		registerPage.selectItemInDropdownByLabel(driver,"DateOfBirthMonth",birthMonth);
		registerPage.selectItemInDropdownByLabel(driver,"DateOfBirthYear",birthYear);
		log.info("Register- Step 06: Enter to emailAdress textbox '" + emailAdress + "'");
		registerPage.inputTextBoxByID(driver, "Email", emailAdress);
		log.info("Register- Step 07: Enter to password textbox '" + password + "'");
		registerPage.inputTextBoxByID(driver, "Password", password);
		log.info("Register- Step 08: Enter to ConfirmPassword textbox '" + password + "'");
		registerPage.inputTextBoxByID(driver, "ConfirmPassword", password);
		
		log.info("Register- Step 09: Click to Register button");
		registerPage.clickToButtonByText(driver, "Register");
		log.info("Register- Step 10: Verify messsage display");
		verifyEquals(registerPage.getTextRegisterResult(), "Your registration completed");

	}

	@Test
	public void User_02_Login() {
		log.info("Login- Step 01: Open Login Page");
		loginPage = homePage.openLoginPage();
		log.info("Login- Step 02: Enter to emailAdress textbox '" + emailAdress + "'");
		loginPage.inputTextBoxByID(driver, "Email", emailAdress);
		log.info("Login- Step 03: Enter to password textbox '" + password + "'");
		registerPage.inputTextBoxByID(driver, "Password", password);
		log.info("Login- Step 04: Click To Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Login- Step 05: Verify My Account Link displays");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
	}

	@Test
	public void User_03_Verify_Infomation_Registed() {
		log.info("Verify information registed- Step 01: Open My Account page");
		customerInfoPage = homePage.openMyAccountPage();
		log.info("Verify information registed- Step 02: Verify My Account page displayed");
		verifyTrue(customerInfoPage.isCustomerInfoPageDisplayed());
		log.info("Verify information registed- Step 03: Verify gender='"+gender+"'");
		verifyTrue(customerInfoPage.verifyRadioSelectedByLabel(driver,gender));
		log.info("Verify information registed- Step 04: Verify FirstName='"+firstName+"'");
		verifyEquals(customerInfoPage.getValueTextBoxByID(driver,"FirstName"),firstName);
		log.info("Verify information registed- Step 05: Verify LastName='"+lastName+"'");
		verifyEquals(customerInfoPage.getValueTextBoxByID(driver,"LastName"),lastName);
		log.info("Verify information registed- Step 06: Verify Email='"+emailAdress+"'");
		verifyEquals(customerInfoPage.getValueTextBoxByID(driver,"Email"),emailAdress);
		log.info("Verify information registed- Step 07: Verify birthday=");
		verifyEquals(customerInfoPage.getValueSelectInDropdownByName(driver,"DateOfBirthDay"),birthDay);
		verifyEquals(customerInfoPage.getValueSelectInDropdownByName(driver,"DateOfBirthMonth"),birthMonth);
		verifyEquals(customerInfoPage.getValueSelectInDropdownByName(driver,"DateOfBirthYear"),birthYear);
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}