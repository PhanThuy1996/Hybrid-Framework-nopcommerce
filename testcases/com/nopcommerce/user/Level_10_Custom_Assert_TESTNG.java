package com.nopcommerce.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
//Có thể sử dụng listeners trong 1 class
//@Listeners(commons.MethodListener.class)
public class Level_10_Custom_Assert_TESTNG extends BaseTest {
	private WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void Verify_With_Custom_Assert() {
		System.out.println("Assert 01");
		String loginPageUrl = driver.getCurrentUrl();
		verifyEquals(loginPageUrl, "https://www.facebook.com/");
		
		System.out.println("Assert 02:Failed");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "Facebook");
		
		System.out.println("Assert 03:");
		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		
		System.out.println("Assert 04:Failed");
		verifyFalse(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		
		
		
		
	}

	@AfterClass
	public void afterClass() {
	}

}
