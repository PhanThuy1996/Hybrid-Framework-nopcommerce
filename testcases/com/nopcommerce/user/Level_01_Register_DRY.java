package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_DRY {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAdress;
  @BeforeClass
  public void beforeClass() {
	    System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		emailAdress ="ThuyPhan96"+ generalFakeNumber()+"@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
  }
  @Test
  public void TC_01_Register_With_Empty_Data() {
	  driver.findElement(By.xpath("//a[@class ='ico-register']")).click();
	  driver.findElement(By.xpath("//button[@id ='register-button']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id ='FirstName-error']")).getText(),"First name is required.");
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id ='LastName-error']")).getText(),"Last name is required.");
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id ='Email-error']")).getText(),"Email is required.");
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id ='Password-error']")).getText(),"Password is required.");
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id ='ConfirmPassword-error']")).getText(),"Password is required.");
	  
  }
  @Test
  public void TC_02_Register_With_Wrong_Email() {
	  driver.findElement(By.xpath("//input[@id ='FirstName']")).sendKeys("Automation");
	  driver.findElement(By.xpath("//input[@id ='LastName']")).sendKeys("Testing");
	  driver.findElement(By.xpath("//input[@id ='Email']")).sendKeys("Automation@123.");
	  driver.findElement(By.xpath("//input[@id ='Password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//input[@id ='ConfirmPassword']")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[@id ='register-button']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id ='Email-error']")).getText(),"Wrong email");
	  
  }
  @Test
  public void TC_03_Register_With_Valid_Data() {
	  driver.findElement(By.xpath("//input[@id ='FirstName']")).clear();
	  driver.findElement(By.xpath("//input[@id ='LastName']")).clear();
	  driver.findElement(By.xpath("//input[@id ='Email']")).clear();
	  driver.findElement(By.xpath("//input[@id ='Password']")).clear();
	  driver.findElement(By.xpath("//input[@id ='ConfirmPassword']")).clear();
	  
	  driver.findElement(By.xpath("//input[@id ='FirstName']")).sendKeys("Automation");
	  driver.findElement(By.xpath("//input[@id ='LastName']")).sendKeys("Testing");
	  driver.findElement(By.xpath("//input[@id ='Email']")).sendKeys(emailAdress);
	  driver.findElement(By.xpath("//input[@id ='Password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//input[@id ='ConfirmPassword']")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[@id ='register-button']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class ='result']")).getText(),"Your registration completed");
  }
  
  @Test
  public void TC_04_Register_With_Exist_Email() {
	  driver.findElement(By.xpath("//a[@class ='ico-register']")).click();
	  driver.findElement(By.xpath("//input[@id ='FirstName']")).clear();
	  driver.findElement(By.xpath("//input[@id ='LastName']")).clear();
	  driver.findElement(By.xpath("//input[@id ='Email']")).clear();
	  driver.findElement(By.xpath("//input[@id ='Password']")).clear();
	  driver.findElement(By.xpath("//input[@id ='ConfirmPassword']")).clear();
	  
	  driver.findElement(By.xpath("//input[@id ='FirstName']")).sendKeys("Automation");
	  driver.findElement(By.xpath("//input[@id ='LastName']")).sendKeys("Testing");
	  driver.findElement(By.xpath("//input[@id ='Email']")).sendKeys("thuyphan961234@gmail.com");
	  driver.findElement(By.xpath("//input[@id ='Password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//input[@id ='ConfirmPassword']")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[@id ='register-button']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'message-error')]//li")).getText(),"The specified email already exists");
	  
  }
  @Test
  public void TC_05_Register_With_Password_Less_6_Characters() {
	  driver.findElement(By.xpath("//input[@id ='FirstName']")).clear();
	  driver.findElement(By.xpath("//input[@id ='LastName']")).clear();
	  driver.findElement(By.xpath("//input[@id ='Email']")).clear();
	  driver.findElement(By.xpath("//input[@id ='Password']")).clear();
	  driver.findElement(By.xpath("//input[@id ='ConfirmPassword']")).clear();
	  
	  driver.findElement(By.xpath("//input[@id ='FirstName']")).sendKeys("Automation");
	  driver.findElement(By.xpath("//input[@id ='LastName']")).sendKeys("Testing");
	  driver.findElement(By.xpath("//input[@id ='Email']")).sendKeys(emailAdress);
	  driver.findElement(By.xpath("//input[@id ='Password']")).sendKeys("12345");
	  driver.findElement(By.xpath("//input[@id ='ConfirmPassword']")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[@id ='register-button']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id ='Password-error']")).getText(),"Password must meet the following rules:"+"\nmust have at least 6 characters");
	  
  }
  
  @Test
  public void TC_06_Register_With_ConfirmPassword_Different_Password() {
	  driver.findElement(By.xpath("//input[@id ='FirstName']")).clear();
	  driver.findElement(By.xpath("//input[@id ='LastName']")).clear();
	  driver.findElement(By.xpath("//input[@id ='Email']")).clear();
	  driver.findElement(By.xpath("//input[@id ='Password']")).clear();
	  driver.findElement(By.xpath("//input[@id ='ConfirmPassword']")).clear();
	  
	  driver.findElement(By.xpath("//input[@id ='FirstName']")).sendKeys("Automation");
	  driver.findElement(By.xpath("//input[@id ='LastName']")).sendKeys("Testing");
	  driver.findElement(By.xpath("//input[@id ='Email']")).sendKeys(emailAdress);
	  driver.findElement(By.xpath("//input[@id ='Password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//input[@id ='ConfirmPassword']")).sendKeys("123457");
	  driver.findElement(By.xpath("//button[@id ='register-button']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id ='ConfirmPassword-error']")).getText(),"The password and confirmation password do not match.");
	  
  }
  
  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }
  
  public int generalFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt(9999);
  }

}
