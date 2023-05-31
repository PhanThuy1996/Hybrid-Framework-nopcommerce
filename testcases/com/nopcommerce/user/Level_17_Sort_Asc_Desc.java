package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Saucedemo.LoginPageObject;
import PageObject.Saucedemo.ProductPageObject;
import commons.BaseTest;

public class Level_17_Sort_Asc_Desc extends BaseTest {
	private WebDriver driver;
	private String username, password;
	private ProductPageObject productPage;
	private LoginPageObject loginPage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://www.saucedemo.com/");
		loginPage = PageObject.Saucedemo.PageGeneratorManager.getLoginPage(driver);
		username="standard_user";
		password = "secret_sauce";
	
		log.info("Login- Step 01: Enter to Username textbox '" + username + "'");
		loginPage.inputTextBoxByID(driver, "user-name", username);
		log.info("Login- Step 02: Enter to password textbox '" + password + "'");
		loginPage.inputTextBoxByID(driver, "password", password);
		log.info("Login- Step 03: Click To Login button");
		productPage=loginPage.clickToButtonByText();
		
	}

	@Test
	public void Sort_01_By_Name() {
		productPage.selectSortByText("Name (A to Z)");
		Assert.assertTrue(productPage.isNameSortAcending());		
		productPage.selectSortByText("Name (Z to A)");
		Assert.assertTrue(productPage.isNameSortDescending());
	}

	@Test
	public void Sort_02_By_Price() {
		productPage.selectSortByText("Price (low to high)");
		Assert.assertTrue(productPage.isPriceSortAscending());
		productPage.selectSortByText("Price (high to low)");
		Assert.assertTrue(productPage.isPriceSortDescending());
	}

	
	@AfterClass
	public void afterClass() {
		//closeBrowserDriver();
	}
}