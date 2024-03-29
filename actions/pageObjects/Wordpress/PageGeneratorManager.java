package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static AdminLoginPO getAdminLoginPage (WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashboardPO getAdminDashboardPage (WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
	
	public static AdminPostAddNewPO getAdminPostAddNewPage (WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}
	public static AdminPostListPO getAdminPostListPage (WebDriver driver) {
		return new AdminPostListPO(driver);
	}

}
