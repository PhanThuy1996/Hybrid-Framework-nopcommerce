package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String firstName,lastName,emailAdress,password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage= PageGeneratorManager.getHomePage(driver);

		firstName="Automation";
		lastName ="Testing";
		emailAdress ="ThuyPhan96"+ generalFakeNumber()+"@gmail.com";
		password ="123456";
		
	}
	@Test
	public void User_01_Register() {
		System.out.println("Step 1: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Step 2: Input data to textbox");
		registerPage.sendTextToFirstNameTextBox(firstName);
		registerPage.sendTextToLastNameTextBox(lastName);
		registerPage.sendTextToEmailTextBox(emailAdress);
		registerPage.sendTextPasswordTextBox(password);
		registerPage.sendTextToConfirmPasswordTextBox(password);
		System.out.println("Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Step 4: Verify Error message"); 
		Assert.assertEquals(registerPage.getTextRegisterResult(),"Your registration completed");		
	}
	  
	  @Test
	  public void User_02_Login() {
		  System.out.println("Step 1: Click to Login Link");
		  loginPage = homePage.clickToLoginLink();
		  System.out.println("Step 2: Input data to textbox");
		  loginPage.sendTextToEmailTextBox(emailAdress);
		  loginPage.sendTextPasswordTextBox(password);
		  System.out.println("Step 3: Click to Login Button");
		  homePage = loginPage.clickToLoginButton();
		  System.out.println("Step 4: Verify My Account Link display"); 
		 // Assert.assertEquals(homePage.getURLHomePage(),"https://demo.nopcommerce.com/");
		  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());			  		  
	  }
	  
	  @Test
	  public void User_03_Customer_Ifo() {
		 System.out.println("Step 1: Click to My Account Link");
		 customerInfoPage = homePage.clickToMyAccountLink();	
		 System.out.println("Step 2: Verify customer info page displayed");
		 Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	  }
	  
	  @Test
	  public void User_04_Switch_Page() {
		  
	  }
	  
	  @Test
	  public void User_05_Switch_Role() {
		  
	  }
	  
	@AfterClass
	public void afterClass() {
	}
	


}
