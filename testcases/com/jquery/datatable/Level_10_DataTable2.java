package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Jquery.HomePageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_10_DataTable2 extends BaseTest {
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
		homePage.sendKeysToDynamicTextboxByRowNumber("Company","2","Jackon Nguyen");
	}  
	  
	 
	  
	@AfterClass
	public void afterClass() {
	}
	


}
