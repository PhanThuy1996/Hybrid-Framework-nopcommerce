package PageObject.Jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.Jquery.JQueryUploadFileUI;

public class JqueryUploadFilePageObject extends BasePage {
	private WebDriver driver;

	public JqueryUploadFilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadOneFile(String fileName) {
		upLoadMultipleFiles(driver, fileName);		
	}

	public void uploadMultipleFile(String[] multipleFiles) {
		upLoadMultipleFiles(driver, multipleFiles);
		
	}

	public String verifyFileSent() {
		waitForElementInVisible(driver, JQueryUploadFileUI.PREVIEW_NAME);
		return getElementText(driver, JQueryUploadFileUI.PREVIEW_NAME);
	}

	public boolean verifyFilesUpload(WebDriver driver, String... fileNames) {
		boolean status = false;
		int number = fileNames.length;

		waitForAllElementInVisible(driver, JQueryUploadFileUI.PROGRESS_BAR);
		sleepInSecond(5);
		List<WebElement> elements = getListWebElement(driver, JQueryUploadFileUI.UPLOADED_IMAGE);
		List<String> imageValues = new ArrayList<String>();
		int i = 0;
		for (WebElement image : elements) {
			imageValues.add(image.getAttribute("src"));
			i++;
			if (i == number) {
				break;
			}
		}
		System.out.println("Number="+number);

		for (String fileName : fileNames) {
			String[] files = fileName.split("\\.");
			fileName = files[0].toUpperCase();
			System.out.println("File name:"+fileName);
			for (i = 0; i < imageValues.size(); i++) {
				if (!imageValues.get(i).contains(fileName)) {
					System.out.println(imageValues.get(i));
					status = false;
					if (i == imageValues.size() - 1) {
						return status;
					}
				} else {
					status = true;
					break;
				}
			}
		}
		return status;
	}
	public void clickToStartUpload() {
		waitForElementClickable(driver, JQueryUploadFileUI.START_UPLOAD_BUTTON);
		clickToElement(driver, JQueryUploadFileUI.START_UPLOAD_BUTTON);
		
	}


}
