package uiPackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPageClass extends BasePageClass {

	public FlightConfirmationPageClass(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

//body
	@FindBy(how = How.XPATH, using = "//img[@src='/images/forms/backtoflights.gif']")
	@CacheLookup
	WebElement BackToFlightsButton;

	@FindBy(how = How.XPATH, using = "//img[@src='/images/forms/home.gif']")
	@CacheLookup
	WebElement BackToHomeButton;

	@FindBy(how = How.XPATH, using = "//img[@src='/images/forms/Logout.gif']")
	@CacheLookup
	WebElement LogOut;

//body
	private void clickBackToFlightsButton() {
		this.clickElement(BackToFlightsButton);
	}

	private void clickBackToHomeButton() {
		this.clickElement(BackToHomeButton);
	}

	private void clickLogOut() {
		this.clickElement(LogOut);
	}

//body
	public FlightConfirmationPageClass BackToFlights() {
		this.clickBackToFlightsButton();
		return new FlightConfirmationPageClass(myDriver, myWait);

	}

	public HomePageClass BackToHome() {
		this.clickBackToHomeButton();
		return new HomePageClass(myDriver, myWait);
	}

	public MenuSignOnPageClass Logout() {
		this.clickLogOut();
		return new MenuSignOnPageClass(myDriver, myWait);
	}
}
