package uiPackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightFinderPageClass extends BasePageClass {

	public FlightFinderPageClass(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

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
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]")
	@CacheLookup
	WebElement roundTrip;
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")
	@CacheLookup
	WebElement onewayTrip;
	@FindBy(how = How.NAME, using = "passCount")
	@CacheLookup
	WebElement passCount;
	@FindBy(how = How.NAME, using = "fromPort")
	@CacheLookup
	WebElement fromPort;
	@FindBy(how = How.NAME, using = "fromMonth")
	@CacheLookup
	WebElement fromMonth;
	@FindBy(how = How.NAME, using = "fromDay")
	@CacheLookup
	WebElement fromDay;
	@FindBy(how = How.NAME, using = "toPort")
	@CacheLookup
	WebElement toPort;
	@FindBy(how = How.NAME, using = "toMonth")
	@CacheLookup
	WebElement toMonth;
	@FindBy(how = How.NAME, using = "toDay")
	@CacheLookup
	WebElement toDay;
	@FindBy(how = How.NAME, using = "airline")
	@CacheLookup
	WebElement airline;
	@FindBy(how = How.XPATH, using = ".//*[@value='Business']")
	@CacheLookup
	WebElement serviceClass;
	@FindBy(how = How.NAME, using = "findFlights")
	@CacheLookup
	WebElement findFlights;

	private void clickRoundTrip() {
		this.clickElement(roundTrip);
	}

	private void clickOnewayTrip() {
		this.clickElement(onewayTrip);
	}

	private void enterPassCount(String a) {
		this.writeTextInWebElement(passCount, a);
	}

	private void enterFromPort(String b) {
		this.writeTextInWebElement(fromPort, b);
	}

	private void enterFromMonth(String c) {
		this.writeTextInWebElement(fromMonth, c);
	}

	private void enterFromDay(String d) {
		this.writeTextInWebElement(fromDay, d);
	}

	private void enterToPort(String e) {
		this.writeTextInWebElement(toPort, e);
	}

	public void enterToMonth(String f) {
		this.writeTextInWebElement(toMonth, f);
	}

	private void enterToDay(String g) {
		this.writeTextInWebElement(toDay, g);
	}

	public void enterAirline(String h) {
		this.writeTextInWebElement(airline, h);
	}

	public void enterServiceClass(String i) {
		this.writeTextInWebElement(serviceClass, i);
	}

	private void clickFindFlights() {
		this.clickElement(findFlights);
	}

	public void waitForPageLoad(int time) {
		this.waitForPageLoad(time, findFlights);
	}

	public SelectFlightPageClass FlightFind(String triptype, String totalpass, String departureFrom, String arrivalTo,
			String departureMonth, String departureDay, String arrivalMonth, String arrivalDay, String airline) {

		this.enterPassCount(totalpass);
		if (triptype == "RoundTrip") {
			this.clickRoundTrip();
		} else {
			this.clickOnewayTrip();
		}
		this.enterFromPort(departureFrom);
		this.enterToPort(arrivalTo);
		this.enterFromDay(departureDay);
		this.enterFromMonth(departureMonth);
		this.enterToMonth(arrivalMonth);
		this.enterToDay(arrivalDay);
		this.enterAirline(airline);
		this.clickFindFlights();

		return new SelectFlightPageClass(myDriver, myWait);
	}


}
