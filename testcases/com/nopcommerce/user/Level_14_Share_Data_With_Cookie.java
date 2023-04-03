package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Register_Account_With_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;

public class Level_14_Share_Data_With_Cookie extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - 1: Open Login Page");
		loginPage = homePage.openLoginPage();
		log.info("Pre-condition - 2: Set cookie and reload page");
		loginPage.setCookie(driver, Register_Account_With_Cookie.loggedCookies);
		log.info("Pre-condition - 3: Verify My Account Link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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

	@AfterClass
	public void afterClass() {
	}
}