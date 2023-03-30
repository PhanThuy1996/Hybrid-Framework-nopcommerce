package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import pageObjects.User.UserCustomerInfoPageObject;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;
import pageObjects.User.UserRegisterPageObject;

public class Level_13_Allure_Report extends BaseTest {
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

	@Description("Register success with valid data")
	@Test
	public void User_01_Register(Method method) {

		registerPage = homePage.openRegisterPage();

		registerPage.sendTextToFirstNameTextBox(firstName);

		registerPage.sendTextToLastNameTextBox(lastName);

		registerPage.sendTextToEmailTextBox(emailAdress);

		registerPage.sendTextPasswordTextBox(password);

		registerPage.sendTextToConfirmPasswordTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getTextRegisterResult(), "Your registration completed.");

	}

	@Description("Login to system")
	@Test
	public void User_02_Login(Method method) {

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