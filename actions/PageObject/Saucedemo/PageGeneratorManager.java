package PageObject.Saucedemo;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager extends BasePage {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	

	
}
