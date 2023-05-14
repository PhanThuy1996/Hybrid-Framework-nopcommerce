package com.wordpress.admin;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.Wordpress.Admin.AdminDashboardPO;
import pageObjects.Wordpress.Admin.AdminLoginPO;
import pageObjects.Wordpress.Admin.PageGeneratorManager;

public class Post_01_CRUD_Search extends BaseTest{
	private WebDriver driver;
	String adminUsername ="thuyphan96";
	String adminPassword ="Quynhthu@123";
	
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin) {
		log.info("Precondition-Step 01: Open Browser and Admin Url");
		driver = getBrowserDriver(browserName,urlAdmin);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		log.info("Precondition-Step 02: Input to UserName textbox with value"+adminUsername);
		adminLoginPage.inputUserNameTextBox(adminUsername);
		log.info("Precondition-Step 03: Input to Password textbox with value"+adminPassword);
		adminLoginPage.inputPasswordTextBox(adminPassword);
		log.info("Precondition-Step 04: Click Log in button");
		adminLoginPage.clickLoginButton();
		adminDashboardPage =PageGeneratorManager.getAdminDashboardPage(driver);
	
	} 

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Register- Step 01: Navigave to Resiter Page");
		

	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Login- Step 01: Open Login Page");
		
	}

	@Test
	public void Post_03_View_Post() {
		log.info("Verify information registed- Step 01: Open My Account page");
		
	}
	
	@Test
	public void Post_04_Edit_Post() {
		log.info("Verify information registed- Step 01: Open My Account page");
		
	}
	@Test
	public void Post_05_Delete_Post() {
		log.info("Verify information registed- Step 01: Open My Account page");
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
