package frameworkPackages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	public static WebDriver driver;

	public BrowserFactory() {

	}

	public static WebDriver getDriver() {
		if (driver == null) {
			// Instantiate the ChromeDriver
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			//Decrease/limit the page load timeout of execution
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			System.setProperty("webdriver.chrome.driver", "./src/main/chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
//<a name="Login Page"</a>
			//deletes the cookies
			driver.manage().deleteAllCookies();
			//execution to wait for a certain time
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			//limiting the wait for loading a particular web page
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static WebDriver getDriver(String browserName) throws MalformedURLException {
		if (driver == null) {
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./src/main/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			} else if (browserName.equalsIgnoreCase("chrome")) {
				//DesiredCapabilities dc=new DesiredCapabilities();
				//dc.setBrowserName("chrome");
				//dc.setPlatform(Platform.LINUX);
				//WebDriver driver=new RemoteWebDriver(new URL("http://192.168.88.62:4444/wd/hub"),dc);
				System.out.println("in chrome");
				System.setProperty("webdriver.chrome.driver", "./src/main/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
//driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			}
		}
		return driver;
	}
}