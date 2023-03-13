package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;
import pageOjects.Admin.AdminDashBoardPageObject;
import pageOjects.Admin.AdminLoginPageObject;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userEmailAdress,userPassword, adminEmailAdress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardPageObject adminDashBoardPage;
	//private UserCustomerInfoPageObject userCustomerInfoPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		userHomePage= PageGeneratorManager.getUserHomePage(driver);

		userEmailAdress ="ThuyPhan96@gmail.com";
		userPassword ="123456";
		adminEmailAdress="admin@yourstore.com";
		adminPassword="admin";
		
	}
	@Test
	public void Role_01_User_To_Admin() {
		  userLoginPage = userHomePage.openLoginPage();
		  userHomePage= userLoginPage.loginAtUserPage(userEmailAdress,userPassword);
		  Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		  userHomePage.clickLogoutAtUserPage(driver);
		  userHomePage.openPageUrl(driver,GlobalConstants.ADMIN_URL);
		  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		  adminDashBoardPage = adminLoginPage.loginAtAdminPage(adminEmailAdress,adminPassword);	  
		  adminDashBoardPage.isDashBoardHeaderDisplayed();
		  adminLoginPage= adminDashBoardPage.clickLogoutAtAdminPage(driver);
	}
	  
	 @Test
	 public void Role_02_Admin_To_User() {
		  adminLoginPage.openPageUrl(driver,GlobalConstants.USER_URL); 		
		  userHomePage = PageGeneratorManager.getUserHomePage(driver);
		  userLoginPage = userHomePage.openLoginPage();
		  userHomePage= userLoginPage.loginAtUserPage(userEmailAdress,userPassword);
	  }

	@AfterClass
	public void afterClass() {
	}
	


}
