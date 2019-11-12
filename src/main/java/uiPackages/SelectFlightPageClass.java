package uiPackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightPageClass extends BasePageClass {

	public SelectFlightPageClass(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	// Body
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[1]/input")
	@CacheLookup
	WebElement BlueSkiesAirlines360_D;

	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")
	@CacheLookup
	WebElement BlueSkiesAirlines361_D;

	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input")
	@CacheLookup
	WebElement PangaeaAirlines362_D;

	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[9]/td[1]/input")
	@CacheLookup
	WebElement UnifiedAirlines363_D;

	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[3]/td[1]/input")
	@CacheLookup
	WebElement BlueSkiesAirlines630_T;

	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")
	@CacheLookup
	WebElement BlueSkiesAirlines631_T;

	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input")
	@CacheLookup
	WebElement PangaeaAirlines632_T;

	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input")
	@CacheLookup
	WebElement UnifiedAirlines633_T;

	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input")
	@CacheLookup
	WebElement con;

	private void clickDepartFlight(String departFlight) {
		if (departFlight == "BlueSkiesAirlines360_D") {
			this.clickElement(BlueSkiesAirlines360_D);
		} else if (departFlight == "BlueSkiesAirlines361_D") {
			this.clickElement(BlueSkiesAirlines361_D);
		} else if (departFlight == "PangaeaAirlines362_D") {
			this.clickElement(PangaeaAirlines362_D);
		} else if (departFlight == "UnifiedAirlines363_D") {
			this.clickElement(UnifiedAirlines363_D);
		}
	}

	private void clickArrivalFlight(String arrivalFlight) {
		if (arrivalFlight == "BlueSkiesAirlines630_T") {
			this.clickElement(BlueSkiesAirlines630_T);
		} else if (arrivalFlight == "BlueSkiesAirlines631_T") {
			this.clickElement(BlueSkiesAirlines631_T);
		} else if (arrivalFlight == "PangaeaAirlines632_T") {
			this.clickElement(PangaeaAirlines632_T);
		} else if (arrivalFlight == "UnifiedAirlines633_T") {
			this.clickElement(UnifiedAirlines633_T);
		}
	}

	private void clickContinue() {
		this.clickElement(con);
	}
	public BookFlightPageClass selectFlights(String DepartureFlight,String ArrivalFlight) {
		this.clickDepartFlight(DepartureFlight);
		this.clickArrivalFlight(ArrivalFlight);
		this.clickContinue();
		return new BookFlightPageClass(myDriver, myWait);
	}

	

}
