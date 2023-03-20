package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.User.UserHomePageObject;
import pageOjects.Admin.AdminLoginPageObject;
import pageUI.user.BasePageUI;

public class BasePage {
	private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
	public void openPageUrl(WebDriver driver, String pageURL) {
		driver.get(pageURL);
	}
	public String getPageTitle(WebDriver driver){
		return driver.getTitle();
	}	
	public String getCurrentURL(WebDriver driver){
		return driver.getCurrentUrl();
	}	
	public String getPageSource(WebDriver driver){
		return driver.getPageSource();
	}
	public void backToPage(WebDriver driver){
		driver.navigate().back();
	}
	public void forwardToPage(WebDriver driver){
		driver.navigate().forward();
	}
	public void refreshCurrentPage(WebDriver driver){
		driver.navigate().refresh();
	}
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		return	explicitwait.until(ExpectedConditions.alertIsPresent());		
	}
	public void acceptAlert(WebDriver driver){
		waitForAlertPresence(driver).accept();
	}
	public void cancelAlert(WebDriver driver){
		waitForAlertPresence(driver).dismiss();
	}
	public String getAlertText(WebDriver driver){
		return waitForAlertPresence(driver).getText();
	}
	public void sendKeyToAlert(WebDriver driver, String textAlert ){
		waitForAlertPresence(driver).sendKeys(textAlert);
	}
	public void switchToWindowByID(WebDriver driver, String otherID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if(!id.equals(otherID)) {
				driver.switchTo().window(id);				
				break;
			}
		}
	}	
	
	public void switchToWindowByTitle(WebDriver driver, String expectTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			if(actualTitle.equals(expectTitle)) {
				break;
			}
		}
	}	
	
	public void closeAllWindowWithoutParentPage(WebDriver driver, String parentPage) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if(!id.equals(parentPage)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentPage);
	}

	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator));
	}
	private String getDynamicLocator(String xpathLocator, String ...paramValues) {
		return String.format(xpathLocator,(Object[]) paramValues);
	}
	public WebElement getWebElement(WebDriver driver, String xpathLocator, String... paramValues) {
		return driver.findElement(getByXpath(getDynamicLocator(xpathLocator, paramValues)));
	}
	public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator){
		return driver.findElements(getByXpath(xpathLocator));
	}
	public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator, String... paramValues){
		return driver.findElements(getByXpath(getDynamicLocator(xpathLocator, paramValues)));
	}
	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver,xpathLocator).click();
	}
	public void clickToElement(WebDriver driver, String xpathLocator,String... paramValues) {
		getWebElement(driver,getDynamicLocator(xpathLocator, paramValues)).click();
	}
	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver,xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue, String... paramValues) {
		WebElement element = getWebElement(driver,getDynamicLocator(xpathLocator, paramValues));
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}
	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem, String... paramValues) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(xpathLocator, paramValues)));
		select.selectByValue(textItem);
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	public String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator,String... paramValues) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(xpathLocator, paramValues)));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	public void selectItemDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(driver,parentXpath).click();
		sleepInSecond(1);
		WebDriverWait expliciWait = new WebDriverWait(driver,longTimeOut);
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		List<WebElement> speedDropdownItems = driver.findElements(By.xpath(childXpath));
		for (WebElement tempItem : speedDropdownItems) {
			if(tempItem.getText().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", tempItem);
				tempItem.click();
				break;	
			}
		}
	}
	
	public String getElementAttribute(WebDriver driver ,String xpathLocator, String attributeName, String... paramValues) {
		return getWebElement(driver,getDynamicLocator(xpathLocator, paramValues)).getAttribute(attributeName);
	}
	public String getElementAttribute(WebDriver driver ,String xpathLocator, String attributeName) {
		return getWebElement(driver,xpathLocator).getAttribute(attributeName);
	}
	public String getElementText(WebDriver driver ,String xpathLocator) {
		return getWebElement(driver,xpathLocator).getText();
	}
	public String getElementText(WebDriver driver ,String xpathLocator,String... paramValues) {
		return getWebElement(driver,getDynamicLocator(xpathLocator, paramValues)).getText();
	}
	
	public String getElementCssValue(WebDriver driver ,String xpathLocator, String propertyName) {
		return getWebElement(driver,xpathLocator).getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex();
	}
	
	public int getElementSize(WebDriver driver ,String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}
	public int getElementSize(WebDriver driver ,String xpathLocator,String... paramValues) {
		return getListWebElement(driver, getDynamicLocator(xpathLocator, paramValues)).size();
	}
	
	public void checkToDefaultCheckboxRadio(WebDriver driver ,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	public void checkToDefaultCheckboxRadio(WebDriver driver ,String xpathLocator, String... paramValues) {
		WebElement element = getWebElement(driver, getDynamicLocator(xpathLocator, paramValues));
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckboxRadio(WebDriver driver ,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	public void uncheckToDefaultCheckboxRadio(WebDriver driver ,String xpathLocator,String... paramValues) {
		WebElement element = getWebElement(driver, getDynamicLocator(xpathLocator, paramValues));
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver ,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	public boolean isElementDisplayed(WebDriver driver ,String xpathLocator,String... paramValues) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, paramValues)).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver ,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	public boolean isElementEnable(WebDriver driver ,String xpathLocator, String... paramValues) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, paramValues)).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver ,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	public boolean isElementSelected(WebDriver driver ,String xpathLocator, String... paramValues) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, paramValues)).isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver ,String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
	public void switchToDefaultContent(WebDriver driver ) {
		driver.switchTo().defaultContent();
	}
	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver,xpathLocator)).perform();
	}
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver,xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver,xpathLocator));
	}
	public void clickToElementByJS(WebDriver driver, String xpathLocator,String... paramValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver,getDynamicLocator(xpathLocator, paramValues)));
	}

	public void scrollToElementOnTop(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver,xpathLocator));
	}
	public void scrollToElementOnTop(WebDriver driver, String xpathLocator, String... paramValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver,getDynamicLocator(xpathLocator, paramValues)));
	}

	public void scrollToElementOnDown(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver,xpathLocator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathLocator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver,xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",getWebElement(driver,xpathLocator));
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver,xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver,xpathLocator));
		return status;
	}
	public void waitForElementVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	public void waitForElementVisible(WebDriver driver,String xpathLocator, String... paramValues) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, paramValues))));
	}
	
	public void waitForAllElementVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	public void waitForAllElementVisible(WebDriver driver,String xpathLocator, String... paramValues) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(getDynamicLocator(xpathLocator, paramValues))));
	}
	
	public void waitForElementInVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	public void waitForElementInVisible(WebDriver driver,String xpathLocator, String... paramValues) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, paramValues))));
	}
	public void waitForAllElementInVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}
	public void waitForAllElementInVisible(WebDriver driver,String xpathLocator, String... paramValues) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicLocator(xpathLocator, paramValues))));
	}
	
	public void waitForElementClickable(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	public void waitForElementClickable(WebDriver driver,String xpathLocator, String... paramValues) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(xpathLocator, paramValues))));
	}
	
	public void clearTextElement(WebDriver driver,String xpathLocator) {
		getWebElement(driver, xpathLocator).clear();
	}
	public void sleepInSecond(long second) { 
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

//	public UserAddressesPageObject openAddressPage(WebDriver driver) {
//		waitForElementVisible(driver, BasePageUI.ADDRESSES_LINK);
//		clickToElement(driver, BasePageUI.ADDRESSES_LINK);
//		return PageGeneratorManager.getUserAddressPage(driver);
//	}
//	
//	public UserBackInStockSubsciptionsPageObject openBackInStockSubscriptPage(WebDriver driver) {
//		waitForElementVisible(driver, BasePageUI.BACK_IN_STOCK_SUBSCIPTTIONS_LINK);
//		clickToElement(driver, BasePageUI.BACK_IN_STOCK_SUBSCIPTTIONS_LINK);
//		return PageGeneratorManager.getUserBackToStockSubscriptionPage(driver);
//	}
//	public UserChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
//		waitForElementVisible(driver, BasePageUI.CHANGE_PASSWORD_LINK);
//		clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
//		return PageGeneratorManager.getUserChangePasswordPage(driver);
//	}
//	public UserDownloadableProductsPageObject openDownloadableProductsPage(WebDriver driver) {
//		waitForElementVisible(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
//		clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
//		return PageGeneratorManager.getUserDownloadableProductsPage(driver);
//	}
//	public UserMyProductReviewsPageObject openMyProductReviewsPage(WebDriver driver) {
//		waitForElementVisible(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
//		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
//		return PageGeneratorManager.getUserMyProductReviewsPage(driver);
//	}
//	public UserOrdersPageObject openOrdersPage(WebDriver driver) {
//		waitForElementVisible(driver, BasePageUI.ORDERS_LINK);
//		clickToElement(driver, BasePageUI.ORDERS_LINK);
//		return PageGeneratorManager.getUserOdersPage(driver);
//	}
//	public UserRewardPointsPageObject openRewardPointsPage(WebDriver driver) {
//		waitForElementVisible(driver, BasePageUI.REWARD_POINTS_LINK);
//		clickToElement(driver, BasePageUI.REWARD_POINTS_LINK);
//		return PageGeneratorManager.getUserRewardPointsPage(driver);
//	}	
//	
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_XPATH_LINK,pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_XPATH_LINK,pageName);
		switch (pageName) {
		case "customer-info":
			return PageGeneratorManager.getUserMyAccountPage(driver);
		case "customer-orders":
			return PageGeneratorManager.getUserOdersPage(driver);
		case "downloadable-products":
			return PageGeneratorManager.getUserDownloadableProductsPage(driver);
		default:
			throw new RuntimeException("Wrong Page");
		}
		
	}
	
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_XPATH_LINK,pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_XPATH_LINK,pageName);	
	}
	public UserHomePageObject clickLogoutAtUserPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.USER_LOGOUT_LINK);
		clickToElement(driver, BasePageUI.USER_LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickLogoutAtAdminPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		clickToElement(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	
	
}
