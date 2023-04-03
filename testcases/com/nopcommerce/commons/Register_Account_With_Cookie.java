package com.nopcommerce.commons;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;
import pageObjects.User.UserRegisterPageObject;

public class Register_Account_With_Cookie extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName;
	public static String emailAdress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static  Set<Cookie> loggedCookies;

	@Parameters("browser")
	@BeforeTest
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Testing";
		emailAdress = "ThuyPhan96" + generalFakeNumber() + "@gmail.com";
		password = "123456";
		log.info("Register to system with valid Email and Password");
		log.info( "Pre-condition- Step 01: Navigave to Resiter Page");
		registerPage = homePage.openRegisterPage();
		log.info( "Pre-condition- Step 02: Enter to firstName textbox '"+firstName+"'");
		registerPage.sendTextToFirstNameTextBox(firstName);
		log.info( "Pre-condition- Step 03: Enter to lastName textbox '"+lastName+"'");
		registerPage.sendTextToLastNameTextBox(lastName);
		log.info( "Pre-condition- Step- Step 04: Enter to emailAdress textbox '"+emailAdress+"'");
		registerPage.sendTextToEmailTextBox(emailAdress);
		log.info( "Pre-condition- Step 05: Enter to password textbox '"+password+"'");
		registerPage.sendTextPasswordTextBox(password);
		log.info( "Pre-condition- Step 06: Enter to ConfirmPassword textbox '"+password+"'");
		registerPage.sendTextToConfirmPasswordTextBox(password);
		log.info( "Pre-condition- Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info( "Pre-condition- Step- Step 08: Verify messsage display");
		Assert.assertEquals(registerPage.getTextRegisterResult(), "Your registration completed");
		log.info("Pre-condition - 9: Open Login Page");
		loginPage = homePage.openLoginPage();
		log.info("Pre-condition - 10: Enter Email Address");
		loginPage.sendTextToEmailTextBox(emailAdress);
		log.info("Pre-condition - 11: Enter Password");
		loginPage.sendTextPasswordTextBox(password);
		log.info("Pre-condition - 12: Click Login button");
		homePage = loginPage.clickToLoginButton();
		loggedCookies = homePage.getAllCookies(driver);

	}

}
