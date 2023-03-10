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
import pageObjects.User.UserRegisterPageObject;

public class Level_03_PageObject_01_Register extends BasePage {
	private WebDriver driver;
	private String firstName,lastName,emailAdress,password;
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage= new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		firstName="Automation";
		lastName ="Testing";
		emailAdress ="ThuyPhan96"+ generalFakeNumber()+"@gmail.com";
		password ="123456";
	}
	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01: Step 1: Click to Register Link");
		homePage.openRegisterPage();
		System.out.println("Register_01: Step 2: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_01: Step 3: Verify required error message");
		Assert.assertEquals(registerPage.getTextFirstNameError(),"First name is required.");
		Assert.assertEquals(registerPage.getTextLastNameError(),"Last name is required.");
		Assert.assertEquals(registerPage.getTextEmailError(),"Email is required.");
		Assert.assertEquals(registerPage.getTextPasswordError(),"Password is required.");
		Assert.assertEquals(registerPage.getTextConfirmPasswordError(),"Password is required.");
	
	}
	@Test
	 public void Register_02_Invalid_Email() {
		System.out.println("Register_02: Step 1: Click to Register Link");
		homePage.openRegisterPage();
		System.out.println("Register_02: Step 2: Input data to textbox");
		registerPage.sendTextToFirstNameTextBox(firstName);
		registerPage.sendTextToLastNameTextBox(lastName);
		registerPage.sendTextToEmailTextBox("abc@1232.");
		registerPage.sendTextPasswordTextBox(password);
		registerPage.sendTextToConfirmPasswordTextBox(password);
		System.out.println("Register_02: Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_02: Step 4: Verify Error message"); 
		Assert.assertEquals(registerPage.getTextEmailError(),"Wrong email");
  
	  }
	  @Test
	  public void Register_03_Valid_Data() {
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
		 // registerPage.clickLogoutLink();
	  }
	  
	  @Test
	  public void Register_04_Exist_Email() {
		  System.out.println("Register_04: Step 1: Click to Register Link");
		  homePage.openRegisterPage();
		  System.out.println("Register_04: Step 2: Input data to textbox");
		  registerPage.sendTextToFirstNameTextBox(firstName);
		  registerPage.sendTextToLastNameTextBox(lastName);
		  registerPage.sendTextToEmailTextBox(emailAdress);
		  registerPage.sendTextPasswordTextBox(password);
		  registerPage.sendTextToConfirmPasswordTextBox(password);
		  System.out.println("Register_04: Step 3: Click to Register Button");
		  registerPage.clickToRegisterButton();
		  System.out.println("Register_04: Step 4: Verify Error message"); 
		  Assert.assertEquals(registerPage.getExistEmailErrorMessage(),"The specified email already exists");
		  
	  }
	  @Test
	  public void Register_05_Password_Less_6_Characters() {
		  System.out.println("Register_05: Step 1: Click to Register Link");
		  homePage.openRegisterPage();
		  System.out.println("Register_05: Step 2: Input data to textbox");
		  registerPage.sendTextToFirstNameTextBox(firstName);
		  registerPage.sendTextToLastNameTextBox(lastName);
		  registerPage.sendTextToEmailTextBox(emailAdress);
		  registerPage.sendTextPasswordTextBox("123");
		  registerPage.sendTextToConfirmPasswordTextBox(password);
		  System.out.println("Register_05: Step 3: Click to Register Button");
		  registerPage.clickToRegisterButton();
		  System.out.println("Register_05: Step 4: Verify Error message"); 
		  Assert.assertEquals(registerPage.getTextPasswordError(),"Password must meet the following rules:"+"\nmust have at least 6 characters");	 		  
	  }
	  
	 @Test
	  public void Register_06_ConfirmPassword_Different_Password() {
		 System.out.println("Register_06: Step 1: Click to Register Link");
		 homePage.openRegisterPage();
		 System.out.println("Register_06: Step 2: Input data to textbox");
		 registerPage.sendTextToFirstNameTextBox(firstName);
		 registerPage.sendTextToLastNameTextBox(lastName);
		 registerPage.sendTextToEmailTextBox(emailAdress);
		 registerPage.sendTextPasswordTextBox(password);
		 registerPage.sendTextToConfirmPasswordTextBox(emailAdress);
		 System.out.println("Register_06: Step 3: Click to Register Button");
		 registerPage.clickToRegisterButton();
		 System.out.println("Register_06: Step 4: Verify Error message"); 
		 Assert.assertEquals(registerPage.getTextConfirmPasswordError(),"The password and confirmation password do not match.");	 	

		  
	  }
	  
	@AfterClass
	public void afterClass() {
	}
	
	public int generalFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }

}
