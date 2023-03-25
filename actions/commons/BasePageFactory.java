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

public class BasePageFactory {
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
		WebDriverWait explicitwait = new WebDriverWait(driver,30);
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
	protected List<WebElement> getListWebElement(WebDriver driver, String xpathLocator){
		return driver.findElements(getByXpath(xpathLocator));
	}
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	public void sendKeyToElement(WebDriver driver, WebElement element,String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, WebElement element, String textItem) {
		Select select = new Select(element);
		select.selectByValue(textItem);
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}
	public void selectItemDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(driver,parentXpath).click();
		sleepInSecond(1);
		WebDriverWait expliciWait = new WebDriverWait(driver,30);
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
	
	public String getElementAttribute(WebDriver driver ,WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	public String getElementText(WebDriver driver ,WebElement element) {
		return element.getText();
	}
	
	public String getElementCssValue(WebDriver driver ,WebElement element, String propertyName) {
		return element.getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex();
	}
	
	public int getElementSize(WebDriver driver ,List<WebElement> elements) {
		return elements.size();
	}
	
	public void checkToDefaultCheckboxRadio(WebDriver driver ,WebElement element) {
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckboxRadio(WebDriver driver ,WebElement element) {
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver ,WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver ,WebElement element) {
		return element.isEnabled();
	}
	public boolean isElementSelected(WebDriver driver ,WebElement element) {
		return element.isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver ,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToDefaultContent(WebDriver driver ) {
		driver.switchTo().defaultContent();
	}
	public void hoverMouseToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElementOnTop(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToElementOnDown(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, WebElement element, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",element);
	}

	public String getElementValidationMessage(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
	}

	public boolean isImageLoaded(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver,xpathLocator));
		return status;
	}
	public void waitForElementVisible(WebDriver driver,WebElement element) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAllElementVisible(WebDriver driver,List<WebElement> elements) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitForElementInVisible(WebDriver driver,WebElement element) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void waitForAllElementInVisible(WebDriver driver,List<WebElement> elements) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	
	public void waitForElementClickable(WebDriver driver,WebElement element) {
		WebDriverWait explicitwait = new WebDriverWait(driver,longTimeOut);
		explicitwait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clearTextElement(WebDriver driver,WebElement element) {
		element.clear();
	}
	public void sleepInSecond(long second) { 
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	private int longTimeOut =30;
}
