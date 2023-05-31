package PageObject.Saucedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.Saucedemo.productPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSortByText(String optionValue) {
		//waitForElementSelected(driver, productPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, productPageUI.SORT_DROPDOWN, optionValue);
	}

	public boolean isNameSortAcending() {
		ArrayList<String> productNameList= new ArrayList<String>();
		List<WebElement> nameList= getListWebElement(driver, productPageUI.PRODUCT_NAME);
		for(WebElement nameproduct: nameList) {
			productNameList.add(nameproduct.getText());
		}
		
		ArrayList<String> sortedList= new ArrayList<String>();
		for(String child:productNameList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		return sortedList.equals(productNameList);		
	}

	public boolean isNameSortDescending() {
		ArrayList<String> productNameList= new ArrayList<String>();
		List<WebElement> nameList= getListWebElement(driver, productPageUI.PRODUCT_NAME);
		for(WebElement nameproduct: nameList) {
			productNameList.add(nameproduct.getText());
		}
		
		ArrayList<String> sortedList= new ArrayList<String>();
		for(String child:productNameList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList.equals(productNameList);	
	}

	public boolean isPriceSortAscending() {
		ArrayList<Float> productPriceList= new ArrayList<Float>();
		List<WebElement> priceList= getListWebElement(driver, productPageUI.PRODUCT_PRICE);
		for(WebElement priceProduct: priceList) {
			productPriceList.add(Float.parseFloat(priceProduct.getText().replace("$", "")));
		}
		
		ArrayList<Float> sortedList= new ArrayList<Float>();
		for(Float child:productPriceList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		return sortedList.equals(productPriceList);		
	}

	public boolean isPriceSortDescending() {
		ArrayList<Float> productPriceList= new ArrayList<Float>();
		List<WebElement> priceList= getListWebElement(driver, productPageUI.PRODUCT_PRICE);
		for(WebElement priceProduct: priceList) {
			productPriceList.add(Float.parseFloat(priceProduct.getText().replace("$", "")));
		}
		
		ArrayList<Float> sortedList= new ArrayList<Float>();
		for(Float child:productPriceList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList.equals(productPriceList);	
	}
	
}
