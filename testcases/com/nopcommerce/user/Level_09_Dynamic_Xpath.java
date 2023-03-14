package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.User.UserBackInStockSubsciptionsPageObject;
import pageObjects.User.UserChangePasswordPageObject;
import pageObjects.User.UserCustomerInfoPageObject;
import pageObjects.User.UserDownloadableProductsPageObject;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;
import pageObjects.User.UserMyProductReviewsPageObject;
import pageObjects.User.UserOrdersPageObject;
import pageObjects.User.UserRegisterPageObject;
import pageObjects.User.UserRewardPointsPageObject;

public class Level_09_Dynamic_Xpath extends BaseTest {
	private WebDriver driver;
	private String firstName,lastName,emailAdress,password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserDownloadableProductsPageObject downloadableProductsPage;
	private UserMyProductReviewsPageObject myProductReviewPage;
	private UserOrdersPageObject orderPage;
	private UserRewardPointsPageObject rewardPointsPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage= PageGeneratorManager.getUserHomePage(driver);

		firstName="Automation";
		lastName ="Testing";
		emailAdress ="ThuyPhan96"+ generalFakeNumber()+"@gmail.com";
		password ="123456";
		
	}
	@Test
	public void User_01_Register_Login() {
		registerPage = homePage.openRegisterPage();
		registerPage.sendTextToFirstNameTextBox(firstName);
		registerPage.sendTextToLastNameTextBox(lastName);
		registerPage.sendTextToEmailTextBox(emailAdress);
		registerPage.sendTextPasswordTextBox(password);
		registerPage.sendTextToConfirmPasswordTextBox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getTextRegisterResult(),"Your registration completed");		
		loginPage = homePage.openLoginPage();	
		loginPage.sendTextToEmailTextBox(emailAdress);
		loginPage.sendTextPasswordTextBox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		customerInfoPage = homePage.openMyAccountPage();	
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}  
	  
	 @Test
	 public void User_02_Dynamic_Xpath_1() {
		 downloadableProductsPage = (UserDownloadableProductsPageObject) customerInfoPage.openPagesAtMyAccountByName(driver,"downloadable-products");
		 orderPage = (UserOrdersPageObject) downloadableProductsPage.openPagesAtMyAccountByName(driver,"customer-orders");	
	  }
	 
	 @Test
	 public void User_03_Dynamic_Xpath_2() {
		 orderPage.openPagesAtMyAccountByPageName(driver, "customer-info");
		 customerInfoPage = PageGeneratorManager.getUserMyAccountPage(driver);
		 customerInfoPage.openPagesAtMyAccountByPageName(driver, "downloadable-products");
		 downloadableProductsPage = PageGeneratorManager.getUserDownloadableProductsPage(driver);
	  }
	 
	 
	  
	@AfterClass
	public void afterClass() {
	}
	


}
