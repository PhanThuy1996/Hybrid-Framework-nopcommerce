package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;
import pageObjects.User.UserRegisterPageObject;

public class Level_03_PageObject_01_Login extends BasePage {
	private WebDriver driver;
	private String firstName,lastName,emailAdress,password;
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage= new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		loginPage = new UserLoginPageObject(driver);
		
		firstName="Automation";
		lastName ="Testing";
		emailAdress ="ThuyPhan96"+ generalFakeNumber()+"@gmail.com";
		password ="123456";
		
		System.out.println("Register_03: Step 1: Click to Register Link");
		homePage.openRegisterPage();
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
		  
		
	}
	@Test
	public void Login_01_Empty_Email() {
		System.out.println("Login_01: Step 1: Click to Login Link");
		homePage.openLoginPage();
		System.out.println("Login_01: Step 2: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_01: Step 3: Verify Email error message");
		Assert.assertEquals(loginPage.getTextEmailError(),"Please enter your email");
	
	}
	@Test
	 public void Login_02_Email_Invalid() {
		System.out.println("Login_02: Step 1: Click to Login Link");
		homePage.openLoginPage();
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
		  homePage.openLoginPage();
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
		  homePage.openLoginPage();
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
		 homePage.openLoginPage();
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
		  homePage.openLoginPage();
		  System.out.println("Login_06: Step 2: Input data to textbox");
		  loginPage.sendTextToEmailTextBox(emailAdress);
		  loginPage.sendTextPasswordTextBox(password);
		  System.out.println("Login_06: Step 3: Click to Login Button");
		  loginPage.clickToLoginButton();
		  System.out.println("Login_06: Step 4: Verify message"); 
		  Assert.assertEquals(homePage.getURLHomePage(),"https://demo.nopcommerce.com/");
	  }
	  
	@AfterClass
	public void afterClass() {
	}
	
	public int generalFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }

}
