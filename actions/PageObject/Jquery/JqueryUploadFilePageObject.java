package PageObject.Jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class JqueryUploadFilePageObject extends BasePage {
	private WebDriver driver;

	public JqueryUploadFilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadOneFile(String fileName) {
		upLoadMultipleFiles(driver, fileName);		
	}

	public void uploadMultipleFile(String[] multipleFiles) {
		upLoadMultipleFiles(driver, multipleFiles);
		
	}



}
