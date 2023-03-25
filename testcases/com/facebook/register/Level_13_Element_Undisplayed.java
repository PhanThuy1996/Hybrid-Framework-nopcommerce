package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.loginPageObject;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private loginPageObject loginPage;
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_verify_Element_Displayed() {
		loginPage.clickRegisterNewButton();
		verifyTrue(loginPage.verifyEmailTextboxDisplayed());
		loginPage.inputEmailTextboxByValue("thuykara34@gmail.com");
		verifyTrue(loginPage.verifyConfirmTextboxDisplayed());
	}

	@Test
	public void TC_02_verify_Element_Undisplayed_InDOM() {
		loginPage.clearTextInTextbox();
		sleepInSecond(3);
		verifyTrue(loginPage.verifyConfirmTextboxUnDisplayed());
	}
	@Test
	public void TC_03_verify_Element_Undisplayed_NotInDOM() {
		loginPage.clickToClosePopup();
		sleepInSecond(3);
		verifyTrue(loginPage.verifyConfirmTextboxUnDisplayed());
	}

	@AfterClass
	public void afterClass() {
	}
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
