package ide.tip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Topic_02_Debug {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@Test
	public void TC_01() {
		System.setProperty("webdriver.chrome.driver",projectPath + "\\browserDriver\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
