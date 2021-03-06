package uiPackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass extends BasePageClass {

	public HomePageClass(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	/* List of all the Web Elements */

	// Headers
	@FindBy(how = How.LINK_TEXT, using = "SIGN-ON")
	private WebElement signon;
	@FindBy(how = How.LINK_TEXT, using = "REGISTER")
	private WebElement register;
	@FindBy(how = How.LINK_TEXT, using = "SUPPORT")
	private WebElement support;
	@FindBy(how = How.LINK_TEXT, using = "CONTACT")
	private WebElement contact;

	// Body
	@FindBy(how = How.NAME, using = "userName")
	private WebElement userName;
	@FindBy(how = How.NAME, using = "password")
	private WebElement password;
	@FindBy(how = How.NAME, using = "login")
	private WebElement login;

	/* Action that can be Performed on the Elements */

	// Headers
	private void clickSignOn() {
		this.clickElement(signon);
	}

	private void clickRegister() {
		this.clickElement(register);
	}

	private void clickSupport() {
		this.clickElement(support);
	}

	private void clickContact() {
		this.clickElement(contact);
	}

	// Body
	private void enterUserName(String a) {
		this.clearElement(userName);
		this.writeTextInWebElement(userName, a);
	}

	private void enterPassword(String b) {
		this.clearElement(password);
		this.writeTextInWebElement(password, b);
	}

	private void clickLogin() {
		this.clickElement(login);
	}

	/* Functions that can be used in TestClass */
	
	// Headers
	public MenuSignOnPageClass navigateToSignOn() {
		this.clickSignOn();
		return new MenuSignOnPageClass(myDriver, myWait);
	}

	public MenuRegisterPageClass navigateToRegisterPage() {
		this.clickRegister();
		return new MenuRegisterPageClass(myDriver, myWait);
	}

	public MenuSupportPageClass navigateToSupportPage() {
		this.clickSupport();
		return new MenuSupportPageClass(myDriver, myWait);
	}

	public MenuContactPageClass navigateToContactUs() {
		this.clickContact();
		return new MenuContactPageClass(myDriver, myWait);
	}

	public void waitForPageLoad(int time) {
		this.waitForPageLoad(time, login);

	}

	// Body
	public HomePageClass InvalidLogin(String userName, String passWord) {
		this.enterUserName(userName);
		this.enterPassword(passWord);
		this.clickLogin();
		return new HomePageClass(myDriver, myWait);
	}

	public FlightFinderPageClass validLogin(String userName, String passWord) {
		this.enterUserName(userName);
		this.enterPassword(passWord);
		this.clickLogin();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new FlightFinderPageClass(myDriver, myWait);
	}

}
