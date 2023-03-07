package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_II extends BasePage {
	WebDriver driver;
	String emailAdress;
	String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		emailAdress ="ThuyPhan96"+ generalFakeNumber()+"@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");		
	}
	@Test
	public void TC_01_Register_With_Empty_Data() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver,"//span[@id ='FirstName-error']"),"First name is required.");
		Assert.assertEquals(getElementText(driver,"//span[@id ='LastName-error']"),"Last name is required.");
		Assert.assertEquals(getElementText(driver,"//span[@id ='Email-error']"),"Email is required.");
		Assert.assertEquals(getElementText(driver,"//span[@id ='Password-error']"),"Password is required.");
		Assert.assertEquals(getElementText(driver,"//span[@id ='ConfirmPassword-error']"),"Password is required.");
		
	}
	@Test
	  public void TC_02_Register_With_Wrong_Email() {
		  sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  sendKeyToElement(driver, "//input[@id ='Email']", "Automation@123.");
		  sendKeyToElement(driver, "//input[@id ='Password']", "123456");
		  sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123456");
		 
		  waitForElementClickable(driver, "//button[@id='register-button']");
		  clickToElement(driver, "//button[@id='register-button']");
		  Assert.assertEquals(getElementText(driver,"//span[@id ='Email-error']"),"Wrong email");	  
	  }
	  @Test
	  public void TC_03_Register_With_Valid_Data() {
		  
		  clearTextElement(driver, "//input[@id ='FirstName']");
		  clearTextElement(driver, "//input[@id ='LastName']");
		  clearTextElement(driver, "//input[@id ='Email']");
		  clearTextElement(driver, "//input[@id ='Password']");
		  clearTextElement(driver, "//input[@id ='ConfirmPassword']");
		
		  sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  sendKeyToElement(driver, "//input[@id ='Email']", emailAdress);
		  sendKeyToElement(driver, "//input[@id ='Password']", "123456");
		  sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123456");
		  
		  waitForElementClickable(driver, "//button[@id='register-button']");
		  clickToElement(driver, "//button[@id='register-button']");
		  Assert.assertEquals(getElementText(driver,"//div[@class ='result']"),"Your registration completed");	
	  }
	  
	  @Test
	  public void TC_04_Register_With_Exist_Email() {
		  
		  waitForElementClickable(driver, "//a[@class='ico-register']");
		  clickToElement(driver, "//a[@class='ico-register']");
		  clearTextElement(driver, "//input[@id ='FirstName']");
		  clearTextElement(driver, "//input[@id ='LastName']");
		  clearTextElement(driver, "//input[@id ='Email']");
		  clearTextElement(driver, "//input[@id ='Password']");
		  clearTextElement(driver, "//input[@id ='ConfirmPassword']");
		
		  sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  sendKeyToElement(driver, "//input[@id ='Email']",emailAdress);
		  sendKeyToElement(driver, "//input[@id ='Password']", "123456");
		  sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123456");
		  waitForElementClickable(driver, "//button[@id='register-button']");
		  clickToElement(driver, "//button[@id='register-button']");
		  
		  Assert.assertEquals(getElementText(driver,"//div[contains(@class,'message-error')]//li"),"The specified email already exists");
		  
	  }
	  @Test
	  public void TC_05_Register_With_Password_Less_6_Characters() {
		  clearTextElement(driver, "//input[@id ='FirstName']");
		  clearTextElement(driver, "//input[@id ='LastName']");
		  clearTextElement(driver, "//input[@id ='Email']");
		  clearTextElement(driver, "//input[@id ='Password']");
		  clearTextElement(driver, "//input[@id ='ConfirmPassword']");
		
		  sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  sendKeyToElement(driver, "//input[@id ='Email']",emailAdress);
		  sendKeyToElement(driver, "//input[@id ='Password']", "12345");
		  sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123456");
		  waitForElementClickable(driver, "//button[@id='register-button']");
		  clickToElement(driver, "//button[@id='register-button']");
		  Assert.assertEquals(getElementText(driver,"//span[@id ='Password-error']"),"Password must meet the following rules:"+"\nmust have at least 6 characters");	 		  
	  }
	  
	 @Test
	  public void TC_06_Register_With_ConfirmPassword_Different_Password() {
		  clearTextElement(driver, "//input[@id ='FirstName']");
		  clearTextElement(driver, "//input[@id ='LastName']");
		  clearTextElement(driver, "//input[@id ='Email']");
		  clearTextElement(driver, "//input[@id ='Password']");
		  clearTextElement(driver, "//input[@id ='ConfirmPassword']");
		
		  sendKeyToElement(driver, "//input[@id ='FirstName']", "Automation");
		  sendKeyToElement(driver, "//input[@id ='LastName']", "Testing");
		  sendKeyToElement(driver, "//input[@id ='Email']",emailAdress);
		  sendKeyToElement(driver, "//input[@id ='Password']", "123456");
		  sendKeyToElement(driver, "//input[@id ='ConfirmPassword']", "123457");
		  waitForElementClickable(driver, "//button[@id='register-button']");
		  clickToElement(driver, "//button[@id='register-button']");
		  Assert.assertEquals(getElementText(driver,"//span[@id ='ConfirmPassword-error']"),"The password and confirmation password do not match.");
		  
	  }
	  
	@AfterClass
	public void afterClass() {
	}
	
	public int generalFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }

}
