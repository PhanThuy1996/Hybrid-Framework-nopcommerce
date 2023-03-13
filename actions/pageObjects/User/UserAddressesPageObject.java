package pageObjects.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserAddressesPageObject extends BasePage{
	WebDriver driver;
	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
