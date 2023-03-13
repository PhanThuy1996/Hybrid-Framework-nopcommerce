package javaBasic;

public class Topic_13_String_Format {
	public static String REGISTER_BUTTON = "//button[@id='register-button']";
	public static String FIRST_NAME_TEXTBOX = "//input[@id ='FirstName']";
	public static String LASTNAME_TEXTBOX = "//input[@id ='LastName']";
	public static String EMAIL_TEXTBOX = "//input[@id ='Email']";
	public static String PASSWORD_TEXTBOX = "//input[@id ='Password']";
	public static String CONFIRM_PASSWORD_TEXTBOX = "//input[@id ='ConfirmPassword']";
	public static String FIRST_NAME_ERROR_MESSAGE = "//span[@id ='FirstName-error']";
	public static String LASTNAME_ERROR_MESSAGE = "//span[@id ='LastName-error']";
	public static String EMAIL_ERROR_MESSAGE = "//span[@id ='Email-error']";
	public static String PASSWORD_ERROR_MESSAGE = "//span[@id ='Password-error']";
	public static String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id ='ConfirmPassword-error']";
	public static String EXIST_EMAIL_ERROR_MESSAGE = "//div[contains(@class,'message-error')]//li";
	public static String REGISTER_RESULT_MESSAGE = "//div[@class ='result']";
	public static String LOG_OUT_LINK = "//a[@class='ico-logout']";
	public static String DYNAMIC_TEXTBOX = "//input[@id ='%s']";	
	public static String DYNAMIC_LOCATOR = "//%s[@%s ='%s']";
	
	public static void main(String[] args) {
		System.out.println(FIRST_NAME_TEXTBOX);
		sendKeyTextBox(DYNAMIC_TEXTBOX,"FirstName");
		getLinkLocator(DYNAMIC_LOCATOR,"input","id","FirstName");
		
	}
	
	public static void sendKeyTextBox(String dynamicTextbox, String nameTextbox) {
		String locator = String.format(dynamicTextbox, nameTextbox);
		System.out.println(locator);
	}
	
	public static void getLinkLocator(String dynamicLocator, String... parameter ) {
		String locator = String.format(dynamicLocator, parameter);
		System.out.println(locator);
	}
	
}
