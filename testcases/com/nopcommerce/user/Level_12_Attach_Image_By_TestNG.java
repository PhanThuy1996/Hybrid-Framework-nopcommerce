package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Level_12_Attach_Image_By_TestNG extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAdress, password;
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

	}

	@Test
	public void User_01_Register() {
		log.info("Register- Step 01: Navigave to Resiter Page");
		registerPage = homePage.openRegisterPage();
		log.info("Register- Step 02: Enter to firstName textbox '"+firstName+"'");
		registerPage.sendTextToFirstNameTextBox(firstName);
		log.info("Register- Step 03: Enter to lastName textbox '"+lastName+"'");
		registerPage.sendTextToLastNameTextBox(lastName);
		log.info("Register- Step 04: Enter to emailAdress textbox '"+emailAdress+"'");
		registerPage.sendTextToEmailTextBox(emailAdress);
		log.info("Register- Step 05: Enter to password textbox '"+password+"'");
		registerPage.sendTextPasswordTextBox(password);
		log.info("Register- Step 06: Enter to ConfirmPassword textbox '"+password+"'");
		registerPage.sendTextToConfirmPasswordTextBox(password);
		log.info("Register- Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Register- Step 08: Verify messsage display");
		Assert.assertEquals(registerPage.getTextRegisterResult(), "Your registration completed+++");

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();
		loginPage.sendTextToEmailTextBox(emailAdress);
		loginPage.sendTextPasswordTextBox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		customerInfoPage = homePage.openMyAccountPage();
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
	}
}