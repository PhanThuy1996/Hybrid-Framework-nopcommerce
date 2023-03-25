package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager extends BasePage {
	public static loginPageObject getUserHomePage(WebDriver driver) {
		return new loginPageObject(driver);
	}
	
	
}
