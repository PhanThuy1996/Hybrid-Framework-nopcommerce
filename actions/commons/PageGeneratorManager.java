package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.User.UserAddressesPageObject;
import pageObjects.User.UserBackInStockSubsciptionsPageObject;
import pageObjects.User.UserChangePasswordPageObject;
import pageObjects.User.UserCustomerInfoPageObject;
import pageObjects.User.UserDownloadableProductsPageObject;
import pageObjects.User.UserHomePageObject;
import pageObjects.User.UserLoginPageObject;
import pageObjects.User.UserMyProductReviewsPageObject;
import pageObjects.User.UserOrdersPageObject;
import pageObjects.User.UserRegisterPageObject;
import pageObjects.User.UserRewardPointsPageObject;
import pageOjects.Admin.AdminDashBoardPageObject;
import pageOjects.Admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserCustomerInfoPageObject getUserMyAccountPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressesPageObject getUserAddressPage(WebDriver driver) {	
		return new UserAddressesPageObject(driver);
	}
	
	public static UserBackInStockSubsciptionsPageObject getUserBackToStockSubscriptionPage(WebDriver driver) {	
		return new UserBackInStockSubsciptionsPageObject(driver);
	}
	
	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {	
		return new UserChangePasswordPageObject(driver);
	}
		
	public static UserDownloadableProductsPageObject getUserDownloadableProductsPage(WebDriver driver) {	
		return new UserDownloadableProductsPageObject(driver);
	}
		
	public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {	
		return new UserMyProductReviewsPageObject(driver);
	}
	
	public static UserOrdersPageObject getUserOdersPage(WebDriver driver) {	
		return new UserOrdersPageObject(driver);
	}
	
	public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {	
		return new UserRewardPointsPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashBoardPageObject getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}
	
}
