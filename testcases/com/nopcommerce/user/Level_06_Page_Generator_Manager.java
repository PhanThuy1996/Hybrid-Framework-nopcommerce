package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.User.UserCustomerInfoPageObject;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;
import pageObjects.User.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager extends BaseTest {
	private WebDriver driver;
	private String firstName,lastName,emailAdress,password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject myAccountPage;
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
		
		System.out.println("Register_03: Step 1: Click to Register Link");
		registerPage = homePage.openRegisterPage();
		System.out.println("Register_03: Step 2: Input data to textbox");
		registerPage.sendTextToFirstNameTextBox(firstName);
		registerPage.sendTextToLastNameTextBox(lastName);
		registerPage.sendTextToEmailTextBox(emailAdress);
		registerPage.sendTextPasswordTextBox(password);
		registerPage.sendTextToConfirmPasswordTextBox(password);
		System.out.println("Register_03: Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_03: Step 4: Verify Error message"); 
		Assert.assertEquals(registerPage.getTextRegisterResult(),"Your registration completed");
		//homePage = registerPage.clickLogoutLink();  		
	}
	@Test
	public void Login_01_Empty_Email() {
		System.out.println("Login_01: Step 1: Click to Login Link");
		loginPage = homePage.openLoginPage();
		System.out.println("Login_01: Step 2: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_01: Step 3: Verify Email error message");
		Assert.assertEquals(loginPage.getTextEmailError(),"Please enter your email");	
	}
	@Test
	 public void Login_02_Email_Invalid() {
		System.out.println("Login_02: Step 1: Click to Login Link");
		loginPage = homePage.openLoginPage();
		System.out.println("Login_02: Step 2: Input data to textbox");
		loginPage.sendTextToEmailTextBox("abc@1232.");
		System.out.println("Login_02: Step 3: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_02: Step 4: Verify Error message"); 
		Assert.assertEquals(registerPage.getTextEmailError(),"Wrong email");
 
	  }
	  
	  @Test
	  public void Login_03_Email_Not_Exist() {
		  System.out.println("Login_03: Step 1: Click to Login Link");
		  loginPage = homePage.openLoginPage();
		  System.out.println("Login_03: Step 2: Input data to textbox");
		  loginPage.sendTextToEmailTextBox("thuyphan@ott.com");
		  loginPage.sendTextPasswordTextBox(password);
		  System.out.println("Login_03: Step 3: Click to Login Button");
		  loginPage.clickToLoginButton();
		  System.out.println("Login_03: Step 4: Verify Error message"); 
		  Assert.assertEquals(loginPage.getValidateErrorMessage(),"Login was unsuccessful. Please correct the errors and try again."+"\nNo customer account found");
		  
	  }
	  @Test
	  public void Login_04_Password_Blank() {
		  System.out.println("Login_04: Step 1: Click to login Link");
		  loginPage = homePage.openLoginPage();
		  System.out.println("Login_04: Step 2: Input data to textbox");
		  loginPage.sendTextToEmailTextBox(emailAdress);
		  System.out.println("Login_04: Step 3: Click to Login Button");
		  loginPage.clickToLoginButton();
		  System.out.println("Login_04: Step 4: Verify Error message"); 
		  Assert.assertEquals(loginPage.getValidateErrorMessage(),"Login was unsuccessful. Please correct the errors and try again."+"\nThe credentials provided are incorrect");	 		  
	  }
	  
	 @Test
	  public void Login_05_Password_Not_Match_Email() {
		 System.out.println("Login_05: Step 1: Click to Login Link");
		 loginPage = homePage.openLoginPage();
		 System.out.println("Login_05: Step 2: Input data to textbox");
		 loginPage.sendTextToEmailTextBox(emailAdress);
		 loginPage.sendTextPasswordTextBox("099090");
		 System.out.println("Login_05: Step 3: Click to Login Button");
		 loginPage.clickToLoginButton();
		 System.out.println("Login_05: Step 4: Verify Error message"); 
		 Assert.assertEquals(loginPage.getValidateErrorMessage(),"Login was unsuccessful. Please correct the errors and try again."+"\nThe credentials provided are incorrect");		 		  
	  }

	  @Test
	  public void Login_06_Valid_Data() {
		  System.out.println("Login_06: Step 1: Click to Login Link");
		  loginPage = homePage.openLoginPage();
		  System.out.println("Login_06: Step 2: Input data to textbox");
		  loginPage.sendTextToEmailTextBox(emailAdress);
		  loginPage.sendTextPasswordTextBox(password);
		  System.out.println("Login_06: Step 3: Click to Login Button");
		  homePage = loginPage.clickToLoginButton();
		  System.out.println("Login_06: Step 4: Verify My Account Link display"); 
		 // Assert.assertEquals(homePage.getURLHomePage(),"https://demo.nopcommerce.com/");
		  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		  myAccountPage = homePage.openMyAccountPage();		  		  
	  }
	  
	@AfterClass
	public void afterClass() {
	}
	


}
