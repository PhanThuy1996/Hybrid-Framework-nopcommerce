package PageObject.Jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.Jquery.AppendGridUI;
import pageUI.Jquery.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToPagingByNumber(int pageNumber) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, Integer.toString(pageNumber));
		clickToElement(driver,HomePageUI.DYNAMIC_PAGE_LINK, Integer.toString(pageNumber));		
	}

	public void verifyPageSelected(int pageNumber) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_ACTIVE_PAGE_LINK, Integer.toString(pageNumber));
		clickToElement(driver,HomePageUI.DYNAMIC_ACTIVE_PAGE_LINK, Integer.toString(pageNumber));
		
	}

	public void sendkeysToTextboxByValue(String label, String textValue) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_FITLER_TEXTBOX, label);
		sendKeyToElement(driver, HomePageUI.DYNAMIC_FITLER_TEXTBOX, textValue, label);
		
	}

	public void getDataAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.PAGE_LINK);
		System.out.println("Total page: "+totalPage);
		List<String> allRowValueAllPage= new ArrayList<String>();
		for(int page = 1;page<=totalPage;page++) {
			clickToElement(driver,HomePageUI.DYNAMIC_PAGE_LINK, Integer.toString(page));
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		
		for (String pageValue : allRowValueAllPage) {
			System.out.println("-----------------");
			System.out.println(pageValue);
		}
	
	}

	public void sendKeysToDynamicTextboxByRowNumber(String nameColumn, String numberRow, String ...paramValue) {
		int positionColumn = getElementSize(driver, AppendGridUI.DYNAMIC_COLUMN_PRECEDING);
		sendKeyToElement(driver, nameColumn, numberRow, paramValue);
		
	}
	
	
	// bài table khác
	
}
