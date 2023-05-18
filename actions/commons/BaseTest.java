package commons;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import JavaOOP.BrowserLists;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllFileInFolder();
	}
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	// private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserLists browserList = BrowserLists.valueOf(browserName.toUpperCase());
		if (browserList == BrowserLists.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox = new FirefoxOptions();
			optionFirefox.setAcceptInsecureCerts(false);
			driver = new FirefoxDriver(optionFirefox);
		} else if (browserList == BrowserLists.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox = new FirefoxOptions();
			optionFirefox.addArguments("--headless");
			optionFirefox.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(optionFirefox);
		} else if (browserList == BrowserLists.CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionChrome = new ChromeOptions();
			optionChrome.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(optionChrome);
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

	protected WebDriver getBrowserDriver(String browserName, String url) {
		BrowserLists browserList = BrowserLists.valueOf(browserName.toUpperCase());
		if (browserList == BrowserLists.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox = new FirefoxOptions();
			optionFirefox.setAcceptInsecureCerts(false);
			driver = new FirefoxDriver(optionFirefox);
		} else if (browserList == BrowserLists.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox = new FirefoxOptions();
			optionFirefox.addArguments("--headless");
			optionFirefox.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(optionFirefox);
		} else if (browserList == BrowserLists.CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionChrome = new ChromeOptions();
			optionChrome.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(optionChrome);
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
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = GlobalConstants.OS_NAME;
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected int generalFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	public WebDriver getDriverInstance() {
		return this.driver;
	}

// Hàm verify custom base trên Hard Assert của TestNG
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("\" -------------------------- PASSED -------------------------- \"");

		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	// Ham xoa cac file trong folder
	public void deleteAllFileInFolder() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "\\allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for(int i = 0; i<listOfFiles.length;i++) {
				if(listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
