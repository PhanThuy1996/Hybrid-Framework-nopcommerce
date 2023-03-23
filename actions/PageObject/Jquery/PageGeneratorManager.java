package PageObject.Jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager extends BasePage {
	public static JqueryUploadFilePageObject getUserHomePage(WebDriver driver) {
		return new JqueryUploadFilePageObject(driver);
	}
	

	
}
