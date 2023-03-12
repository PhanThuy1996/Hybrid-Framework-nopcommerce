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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest{
	private WebDriver driver ;
	//private String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {	
		switch (browserName) {
		case "firefox":			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		//case head-less: chay trinh duyet khong co UI
		case "h-firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionFirefox = new FirefoxOptions();
			optionFirefox.addArguments("--headless");
			optionFirefox.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(optionFirefox);
			break;
		case "chrome":			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "h-chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionChrome = new ChromeOptions();
			optionChrome.addArguments("--headless");
			optionChrome.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(optionChrome);
			break;
		case "egde":
			WebDriverManager.edgedriver().setup();;
			driver = new EdgeDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;			
		case "CocCoc":
			WebDriverManager.chromedriver().driverVersion("109.0.5414.74").setup();
			ChromeOptions optionsCocCoc = new ChromeOptions();
			optionsCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(optionsCocCoc);
			break;
		case "brave":
			WebDriverManager.chromedriver().driverVersion("111.0.5563.64").setup();
			ChromeOptions optionsBrave = new ChromeOptions();
			optionsBrave.setBinary("C:\\Program Files\\Brave\\Browser\\Application\browser.exe");
			driver = new ChromeDriver(optionsBrave);
		default:
			throw new RuntimeException("Please input with correct browser name. ");	
		}	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	protected int generalFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	}
}
