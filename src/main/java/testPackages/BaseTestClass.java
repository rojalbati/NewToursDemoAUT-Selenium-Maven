package testPackages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTestClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String baseUrl = "http://newtours.demoaut.com/";

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite
	@Parameters({ "browser", "browserPath" })
	public void setUp(String browser, String browserPath) throws MalformedURLException {
		browser = browser.toLowerCase().trim();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", browserPath);
			/*Below Commented Codes are for Cross Browser Testing*/
			//DesiredCapabilities dc=new DesiredCapabilities();
			//dc.setBrowserName("chrome");
			//dc.setPlatform(Platform.LINUX);
			driver=new ChromeDriver();
			//driver=new RemoteWebDriver(new URL("http://192.168.88.62:4444/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to(baseUrl);
			System.out.println("Set Up Completed");
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", browserPath);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to(baseUrl);
			System.out.println("Set Up Completed");
			break;

		case "default":
			System.out.println("Driver Set Up Improper");
			break;

		}

	}

	@AfterSuite
	public void teardown() {
		driver.quit();
		System.out.println("Tear Down Completed ...");
	}

}
