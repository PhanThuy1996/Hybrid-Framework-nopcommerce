package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import JavaOOP.BrowserLists;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	// private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserLists browserList = BrowserLists.valueOf(browserName.toUpperCase());
		if (browserList == BrowserLists.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserList == BrowserLists.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox = new FirefoxOptions();
			optionFirefox.addArguments("--headless");
			optionFirefox.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(optionFirefox);
		} else if (browserList == BrowserLists.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserList == BrowserLists.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionChrome = new ChromeOptions();
			optionChrome.addArguments("--headless");
			optionChrome.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(optionChrome);
		} else if (browserList == BrowserLists.EDGE) {
			WebDriverManager.edgedriver().setup();
			;
			driver = new EdgeDriver();
		} else if (browserList == BrowserLists.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserList == BrowserLists.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("109.0.5414.74").setup();
			ChromeOptions optionsCocCoc = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				optionsCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				optionsCocCoc.setBinary("...");
			}
			driver = new ChromeDriver(optionsCocCoc);

		} else if (browserList == BrowserLists.BRAVE) {
			WebDriverManager.chromedriver().driverVersion("111.0.5563.64").setup();
			ChromeOptions optionsBrave = new ChromeOptions();
			optionsBrave.setBinary("C:\\Program Files\\Brave\\Browser\\Application\browser.exe");
			driver = new ChromeDriver(optionsBrave);
		} else
			throw new RuntimeException("Please input with correct browser name. ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}
	
	protected WebDriver getBrowserDriver(String browserName,String url) {
		BrowserLists browserList = BrowserLists.valueOf(browserName.toUpperCase());
		if (browserList == BrowserLists.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserList == BrowserLists.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox = new FirefoxOptions();
			optionFirefox.addArguments("--headless");
			optionFirefox.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(optionFirefox);
		} else if (browserList == BrowserLists.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserList == BrowserLists.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionChrome = new ChromeOptions();
			optionChrome.addArguments("--headless");
			optionChrome.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(optionChrome);
		} else if (browserList == BrowserLists.EDGE) {
			WebDriverManager.edgedriver().setup();
			;
			driver = new EdgeDriver();
		} else if (browserList == BrowserLists.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserList == BrowserLists.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("109.0.5414.74").setup();
			ChromeOptions optionsCocCoc = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				optionsCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				optionsCocCoc.setBinary("...");
			}
			driver = new ChromeDriver(optionsCocCoc);

		} else if (browserList == BrowserLists.BRAVE) {
			WebDriverManager.chromedriver().driverVersion("111.0.5563.64").setup();
			ChromeOptions optionsBrave = new ChromeOptions();
			optionsBrave.setBinary("C:\\Program Files\\Brave\\Browser\\Application\browser.exe");
			driver = new ChromeDriver(optionsBrave);
		} else
			throw new RuntimeException("Please input with correct browser name. ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;

	}

	protected int generalFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
