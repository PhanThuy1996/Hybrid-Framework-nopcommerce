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

public class Level_02_Apply_BasePage_I {
	WebDriver driver;
	BasePage basePage; //Khai báo
	String emailAdress;
	String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();	
		basePage = new BasePage();//Khởi tạo
		driver.manage().window().maximize();
		emailAdress ="ThuyPhan96"+ generalFakeNumber()+"@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");		
	}
	@Test
	public void TC_01_Register_With_Empty_Data() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id ='FirstName-error']"),"First name is required.");
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id ='LastName-error']"),"Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id ='Email-error']"),"Email is required.");
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id ='Password-error']"),"Password is required.");
		Assert.assertEquals(basePage.getElementText(driver,"//span[@id ='ConfirmPassword-error']"),"Password is required.");
		
	}
	@Test
	  public void TC_02_Register_With_Wrong_Email() {
		  basePage.sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  basePage.sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  basePage.sendKeyToElement(driver, "//input[@id ='Email']", "Automation@123.");
		  basePage.sendKeyToElement(driver, "//input[@id ='Password']", "123456");
		  basePage.sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123456");
		 
		  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		  basePage.clickToElement(driver, "//button[@id='register-button']");
		  Assert.assertEquals(basePage.getElementText(driver,"//span[@id ='Email-error']"),"Wrong email");	  
	  }
	  @Test
	  public void TC_03_Register_With_Valid_Data() {
		  
		  basePage.clearTextElement(driver, "//input[@id ='FirstName']");
		  basePage.clearTextElement(driver, "//input[@id ='LastName']");
		  basePage.clearTextElement(driver, "//input[@id ='Email']");
		  basePage.clearTextElement(driver, "//input[@id ='Password']");
		  basePage.clearTextElement(driver, "//input[@id ='ConfirmPassword']");
		
		  basePage.sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  basePage.sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  basePage.sendKeyToElement(driver, "//input[@id ='Email']", emailAdress);
		  basePage.sendKeyToElement(driver, "//input[@id ='Password']", "123456");
		  basePage.sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123456");
		  
		  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		  basePage.clickToElement(driver, "//button[@id='register-button']");
		  Assert.assertEquals(basePage.getElementText(driver,"//div[@class ='result']"),"Your registration completed");	
	  }
	  
	  @Test
	  public void TC_04_Register_With_Exist_Email() {
		  
		  basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		  basePage.clickToElement(driver, "//a[@class='ico-register']");
		  basePage.clearTextElement(driver, "//input[@id ='FirstName']");
		  basePage.clearTextElement(driver, "//input[@id ='LastName']");
		  basePage.clearTextElement(driver, "//input[@id ='Email']");
		  basePage.clearTextElement(driver, "//input[@id ='Password']");
		  basePage.clearTextElement(driver, "//input[@id ='ConfirmPassword']");
		
		  basePage.sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  basePage.sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  basePage.sendKeyToElement(driver, "//input[@id ='Email']",emailAdress);
		  basePage.sendKeyToElement(driver, "//input[@id ='Password']", "123456");
		  basePage.sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123456");
		  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		  basePage.clickToElement(driver, "//button[@id='register-button']");
		  
		  Assert.assertEquals(basePage.getElementText(driver,"//div[contains(@class,'message-error')]//li"),"The specified email already exists");
		  
	  }
	  @Test
	  public void TC_05_Register_With_Password_Less_6_Characters() {
		  basePage.clearTextElement(driver, "//input[@id ='FirstName']");
		  basePage.clearTextElement(driver, "//input[@id ='LastName']");
		  basePage.clearTextElement(driver, "//input[@id ='Email']");
		  basePage.clearTextElement(driver, "//input[@id ='Password']");
		  basePage.clearTextElement(driver, "//input[@id ='ConfirmPassword']");
		
		  basePage.sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  basePage.sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  basePage.sendKeyToElement(driver, "//input[@id ='Email']",emailAdress);
		  basePage.sendKeyToElement(driver, "//input[@id ='Password']", "12345");
		  basePage.sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123456");
		  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		  basePage.clickToElement(driver, "//button[@id='register-button']");
		  Assert.assertEquals(basePage.getElementText(driver,"//span[@id ='Password-error']"),"Password must meet the following rules:"+"\nmust have at least 6 characters");	 		  
	  }
	  
	 @Test
	  public void TC_06_Register_With_ConfirmPassword_Different_Password() {
		  basePage.clearTextElement(driver, "//input[@id ='FirstName']");
		  basePage.clearTextElement(driver, "//input[@id ='LastName']");
		  basePage.clearTextElement(driver, "//input[@id ='Email']");
		  basePage.clearTextElement(driver, "//input[@id ='Password']");
		  basePage.clearTextElement(driver, "//input[@id ='ConfirmPassword']");
		
		  basePage.sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  basePage.sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  basePage.sendKeyToElement(driver, "//input[@id ='Email']",emailAdress);
		  basePage.sendKeyToElement(driver, "//input[@id ='Password']", "123456");
		  basePage.sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123457");
		  basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		  basePage.clickToElement(driver, "//button[@id='register-button']");
		  Assert.assertEquals(basePage.getElementText(driver,"//span[@id ='ConfirmPassword-error']"),"The password and confirmation password do not match.");
		  
	  }
	  
	@AfterClass
	public void afterClass() {
	}
	
	public int generalFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }

}
