package com.Jqueryuploadfiles;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Jquery.JqueryUploadFilePageObject;
import PageObject.Jquery.PageGeneratorManager;
import commons.BaseTest;

public class Upload_File extends BaseTest {
	private WebDriver driver;
	private JqueryUploadFilePageObject uploadPage;
	private String fileName1="F1.png";
	private String fileName2="F2.png";
	private String fileName3="F3.png";
	private String[] multipleFiles = {fileName1,fileName2,fileName3};

	@Parameters({ "browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName,url);	
		uploadPage = PageGeneratorManager.getUserHomePage(driver);
		
	}
	@Test
	public void upload_One_File_One_Time() {
		uploadPage.uploadOneFile(fileName1);
			
	}  
	@Test
	public void upload_Multiple_File_One_Time() {
		
		uploadPage.uploadMultipleFile(multipleFiles);
	}
	  
	 
	  
	@AfterClass
	public void afterClass() {
	}
	


}
