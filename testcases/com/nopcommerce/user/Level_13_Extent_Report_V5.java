package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.User.UserCustomerInfoPageObject;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;
import pageObjects.User.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_13_Extent_Report_V5 extends BaseTest {
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
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register- Step 01: Navigave to Resiter Page");
		registerPage = homePage.openRegisterPage();
		ExtentTestManager.getTest().log(Status.INFO,"Register- Step 02: Enter to firstName textbox '"+firstName+"'");
		registerPage.sendTextToFirstNameTextBox(firstName);
		ExtentTestManager.getTest().log(Status.INFO,"Register- Step 03: Enter to lastName textbox '"+lastName+"'");
		registerPage.sendTextToLastNameTextBox(lastName);
		ExtentTestManager.getTest().log(Status.INFO,"Register- Step 04: Enter to emailAdress textbox '"+emailAdress+"'");
		registerPage.sendTextToEmailTextBox(emailAdress);
		ExtentTestManager.getTest().log(Status.INFO,"Register- Step 05: Enter to password textbox '"+password+"'");
		registerPage.sendTextPasswordTextBox(password);
		ExtentTestManager.getTest().log(Status.INFO,"Register- Step 06: Enter to ConfirmPassword textbox '"+password+"'");
		registerPage.sendTextToConfirmPasswordTextBox(password);
		ExtentTestManager.getTest().log(Status.INFO,"Register- Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		ExtentTestManager.getTest().log(Status.INFO,"Register- Step 08: Verify messsage display");
		Assert.assertEquals(registerPage.getTextRegisterResult(), "Your registration completed.");

	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO,"Login- Step 01: Open Login Page");
		loginPage = homePage.openLoginPage();
		ExtentTestManager.getTest().log(Status.INFO,"Login- Step 02: Enter to emailAdress textbox '"+emailAdress+"'");
		loginPage.sendTextToEmailTextBox(emailAdress);
		ExtentTestManager.getTest().log(Status.INFO,"Login- Step 03: Enter to password textbox '"+password+"'");
		loginPage.sendTextPasswordTextBox(password);
		ExtentTestManager.getTest().log(Status.INFO,"Login- Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(Status.INFO,"Login- Step 05: Verify My Account Link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		ExtentTestManager.getTest().log(Status.INFO,"Login- Step 06: Open My Account Page");
		customerInfoPage = homePage.openMyAccountPage();
		ExtentTestManager.getTest().log(Status.INFO,"Login- Step 07: Verify navigation to Customer Info Page success");
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
	}
}