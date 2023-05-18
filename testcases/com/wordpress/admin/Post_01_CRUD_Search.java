package com.wordpress.admin;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.Wordpress.AdminDashboardPO;
import pageObjects.Wordpress.AdminLoginPO;
import pageObjects.Wordpress.AdminPostAddNewPO;
import pageObjects.Wordpress.PageGeneratorManager;

public class Post_01_CRUD_Search extends BaseTest{
	private WebDriver driver;
	String adminUsername ="automationfc";
	String adminPassword ="Quynhthu@123";
	
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	int fakeNumber = generalFakeNumber();
	String postTitle = "Automation testing Title"+fakeNumber;
	String postBody = "Automation testing Body"+fakeNumber;
	String dateCurrent ="";

	@Parameters({"browser","urlAdmin"})
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
		log.info("Create New Post- Step 01: Open Add Post Page");
		adminDashboardPage.clickToPostMenuLink();
		adminPostAddNewPage = PageGeneratorManager.getAdminPostAddNewPage(driver);
		log.info("Create New Post- Step 02: Input Post Title with"+postTitle);
		adminPostAddNewPage.inputPostTitle(postTitle);
		log.info("Create New Post- Step 03: Input Post Title with"+postBody);
		adminPostAddNewPage.inputPostBody(postBody);
		log.info("Create New Post- Step 04: Click Publish button");
		adminPostAddNewPage.clickToPulishOrUpdateButton();
		log.info("Create New Post- Step 05: Click Pre-Publish button");
		adminPostAddNewPage.clickToPrePulishButton();
		log.info("Create New Post- Step 06: Verify message 'Post published' is displayed");	
		verifyTrue(adminPostAddNewPage.isMessagePostPublishOrUpdateDisplayed("Post published"));

	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Search Post- Step 01: Open Post List page");
		log.info("Search Post- Step 02: Input Post title into search textbox with value"+postTitle);
		log.info("Search Post- Step 03: Click Search Posts button");
		log.info("Search Post- Step 04: Verify Search results for with value"+postTitle);
		log.info("Search Post- Step 05: Verify Title result is displayed with value"+postTitle);
		log.info("Search Post- Step 06: Verify Author result is displayed with value"+adminUsername);
		log.info("Search Post- Step 07: Verify Date result is displayed with value"+dateCurrent);
		
	}

	@Test
	public void Post_03_View_Post() {
		log.info("View Post- Step 01: Open Home User page");
		log.info("View Post- Step 02: Input Title into search textbox");
		log.info("View Post- Step 03: Click Search button");
		log.info("View Post- Step 04: Verify Search results for with value"+postTitle);
		log.info("View Post- Step 05: Verify Title result is displayed with value"+postTitle);
		log.info("View Post- Step 06: Verify Body result is displayed with value"+postBody);
		log.info("View Post- Step 07: Verify Author result is displayed with value"+adminUsername);
		log.info("View Post- Step 08: Verify Date result is displayed with value"+dateCurrent);
		log.info("View Post- Step 09: Click Post Title (Open User Post Detail) ");
		log.info("View Post- Step 10: Verify Search results for with value"+postTitle);
		log.info("View Post- Step 11: Verify Title result is displayed with value"+postTitle);
		log.info("View Post- Step 12: Verify Body result is displayed with value"+postBody);
		log.info("View Post- Step 13: Verify Author result is displayed with value"+adminUsername);
		log.info("View Post- Step 14: Verify Date result is displayed with value"+dateCurrent);	
		
	}
	
	@Test
	public void Post_04_Edit_Post() {
		log.info("Edit Post- Step 01: Open Edit Post Page");
		log.info("Edit Post- Step 02: Input Post Title with"+postTitle);
		log.info("Edit Post- Step 03: Input Post Title with"+postBody);
		log.info("Edit Post- Step 04: Click Update button");
		log.info("Edit Post- Step 05: Verify message 'Post updated' is displayed");	
		log.info("Edit Post- Step 06: Open Post List page");
		log.info("Edit Post- Step 07: Input Post title into search textbox with value"+postTitle);
		log.info("Edit Post- Step 08: Click Search Posts button");
		log.info("Edit Post- Step 09: Verify Search results for with value"+postTitle);
		log.info("Edit Post- Step 10: Verify Title result is displayed with value"+postTitle);
		log.info("Edit Post- Step 11: Verify Author result is displayed with value"+adminUsername);
		log.info("Edit Post- Step 12: Verify Date result is displayed with value"+dateCurrent);
		log.info("Edit Post- Step 13: Open Home User page");
		log.info("Edit Post- Step 14: Input Title into search textbox");
		log.info("Edit Post- Step 15: Click Search button");
		log.info("Edit Post- Step 16: Verify Search results for with value"+postTitle);
		log.info("Edit Post- Step 17: Verify Title result is displayed with value"+postTitle);
		log.info("Edit Post- Step 18: Verify Body result is displayed with value"+postBody);
		log.info("Edit Post- Step 19: Verify Author result is displayed with value"+adminUsername);
		log.info("Edit Post- Step 20: Verify Date result is displayed with value"+dateCurrent);
		log.info("Edit Post- Step 21: Click Post Title (Open User Post Detail) ");
		log.info("Edit Post- Step 22: Verify Search results for with value"+postTitle);
		log.info("Edit Post- Step 23: Verify Title result is displayed with value"+postTitle);
		log.info("Edit Post- Step 24: Verify Body result is displayed with value"+postBody);
		log.info("Edit Post- Step 25: Verify Author result is displayed with value"+adminUsername);
		log.info("Edit Post- Step 26: Verify Date result is displayed with value"+dateCurrent);	
		
		
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
