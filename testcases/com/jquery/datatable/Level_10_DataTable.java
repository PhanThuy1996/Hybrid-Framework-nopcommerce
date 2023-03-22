package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Jquery.HomePageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_10_DataTable extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;

	@Parameters({ "browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName,url);	
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	//@Test
	public void DataTable_01_Click_On_Paging() {
		homePage.clickToPagingByNumber(20);
		homePage.sleepInSecond(1);
		homePage.verifyPageSelected(20);
		homePage.clickToPagingByNumber(10);
		homePage.sleepInSecond(1);
		homePage.verifyPageSelected(10);
		homePage.clickToPagingByNumber(5);
		homePage.sleepInSecond(1);
		homePage.verifyPageSelected(5);
	}  
	  
	 @Test
	 public void DataTable_02_Filter() {
		homePage.refreshCurrentPage(driver);
		homePage.sendkeysToTextboxByValue("Females","60456");
		homePage.sendkeysToTextboxByValue("Country","Belgium");
		homePage.sendkeysToTextboxByValue("Males","63391");
		homePage.sendkeysToTextboxByValue("Total","123847");
		homePage.sleepInSecond(3);
	  }
	 
	//@Test
	 public void DataTable_03_getDataFromPage() {	
		//lấy data so sánh....
		homePage.getDataAllPage();
	  }
	 
	 
	  
	@AfterClass
	public void afterClass() {
	}
	


}
