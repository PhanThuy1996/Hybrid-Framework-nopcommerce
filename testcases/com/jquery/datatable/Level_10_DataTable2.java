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
	@Test
	public void DataTable_01_Enter_Value_In_Table() {
		homePage.enterToTextBoxByColumnAtRowNumber("Company","2","Jackon Nguyen");
		homePage.enterToTextBoxByColumnAtRowNumber("Contact Person","2","Nguyen Tho");
		homePage.selectDropdownByColumnAtRowNumber("Country","2","Hong Kong");
		homePage.checkToCheckBoxByColumnAtRowNumber("NPO?","2");
		homePage.enterToTextBoxByColumnAtRowNumber("Order Placed","2","1");
			
	}  
	  
	 
	  
	@AfterClass
	public void afterClass() {
	}
	


}
