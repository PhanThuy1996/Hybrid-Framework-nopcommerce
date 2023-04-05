package pageUI.user;

public class BasePageUI {
	public static final String CUSTOMER_INFO_LINK = "//li[contains(@class,'customer-info')]/a";
	public static final String ADDRESSES_LINK = "//li[contains(@class,'customer-addresses')]/a";
	public static final String ORDERS_LINK = "//li[contains(@class,'customer-orders')]/a";
	public static final String DOWNLOADABLE_PRODUCTS_LINK="//li[contains(@class,'downloadable-products')]/a";
	public static final String BACK_IN_STOCK_SUBSCIPTTIONS_LINK="//li[contains(@class,'back-in-stock-subscriptions')]/a";
	public static final String REWARD_POINTS_LINK="//li[contains(@class,'eward-points')]/a";
	public static final String CHANGE_PASSWORD_LINK="//li[contains(@class,'change-password')]/a";
	public static final String MY_PRODUCT_REVIEWS_LINK="//li[contains(@class,'customer-reviews')]/a";
	public static final String USER_LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String ADMIN_LOGOUT_LINK = "//a[text()='Logout']";
	
	public static final String DYNAMIC_XPATH_LINK ="//li[contains(@class,'%s')]/a";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID="//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT="//button[text()='%s']";	
	public static final String DYNAMIC_DROPDOWN_BY_NAME="//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BY_LABEL="//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL= "//label[contains(text(),'%s')]/following-sibling::input";
	
	
}
