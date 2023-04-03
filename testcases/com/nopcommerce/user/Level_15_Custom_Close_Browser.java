package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Register_Account_With_EndUser;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;

public class Level_15_Custom_Close_Browser extends BaseTest {
	private WebDriver driver;
	private String emailAddress, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		emailAddress= Register_Account_With_EndUser.emailAdress;
		password = Register_Account_With_EndUser.password;
		
		log.info("Pre-condition - 1: Open Login Page");
		loginPage = homePage.openLoginPage();
		log.info("Pre-condition - 2: Enter Email Address");
		loginPage.sendTextToEmailTextBox(emailAddress);
		log.info("Pre-condition - 3: Enter Password");
		loginPage.sendTextPasswordTextBox(password);
		log.info("Pre-condition - 4: Click Login button");
		homePage = loginPage.clickToLoginButton();

	}

	@Test
	public void Search_01() {

	}
	
	@Test
	public void Search_02() {

	}
	
	@Test
	public void Search_03() {

	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}