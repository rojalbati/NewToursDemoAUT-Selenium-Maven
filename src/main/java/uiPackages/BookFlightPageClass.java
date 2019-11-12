package uiPackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlightPageClass extends BasePageClass {

	public BookFlightPageClass(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	// Body
	@FindBy(how = How.NAME, using = "passFirst0")
	@CacheLookup
	WebElement firstName;
	@FindBy(how = How.NAME, using = "passLast0")
	@CacheLookup
	WebElement lastName;
	@FindBy(how = How.NAME, using = "pass.0.meal")
	@CacheLookup
	WebElement meal;
	@FindBy(how = How.NAME, using = "creditCard")
	@CacheLookup
	WebElement cardType;
	@FindBy(how = How.NAME, using = "creditnumber")
	@CacheLookup
	WebElement cardNumber;
	@FindBy(how = How.NAME, using = "cc_exp_dt_mn")
	@CacheLookup
	WebElement expMonth;
	@FindBy(how = How.NAME, using = "cc_exp_dt_yr")
	@CacheLookup
	WebElement expYears;
	@FindBy(how = How.NAME, using = "cc_frst_name")
	@CacheLookup
	WebElement cardFirstNames;
	@FindBy(how = How.NAME, using = "cc_mid_name")
	@CacheLookup
	WebElement cardMidName;
	@FindBy(how = How.NAME, using = "cc_last_name")
	@CacheLookup
	WebElement cardLastName;
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[23]/td/input")
	@CacheLookup
	WebElement purchase;

	private void enterFirstName(String a) {
		this.writeTextInWebElement(firstName, a);
	}

	private void enterLastName(String b) {
		this.writeTextInWebElement(firstName, b);
	}

	private void enterMealType(String m) {
		this.writeTextInWebElement(meal, m);
	}

	private void enterCardType(String c) {
		this.writeTextInWebElement(cardType, c);
	}

	private void enterCardNumber(String d) {
		this.writeTextInWebElement(cardNumber, d);
	}

	private void enterCardExpMonth(String e) {
		this.writeTextInWebElement(expMonth, e);
	}

	private void enterCardExpYear(String f) {
		this.writeTextInWebElement(expYears, f);
	}

	private void enterCardFirstName(String g) {
		this.writeTextInWebElement(cardFirstNames, g);
	}

	private void enterCardMidName(String h) {
		this.writeTextInWebElement(cardMidName, h);
	}

	private void enterCardLastName(String i) {
		this.writeTextInWebElement(cardLastName, i);
	}

	private void clickPurchase() {
		clickElement(purchase);
	}

	public FlightConfirmationPageClass bookflight(String PassengerFirstName, String PassengerLastName, String MealType,
			String CreditCardType, String CreditCardNumber, String CreditCardExpirationMonth,
			String CreditCardExpirationYear, String CreditCardOwnerFirstName, String CreditCardOwnerMiddleName,
			String CreditCardOwnerLastName) {
		this.enterFirstName(PassengerFirstName);
		this.enterLastName(PassengerLastName);
		this.enterMealType(MealType);
		this.enterCardType(CreditCardType);
		this.enterCardNumber(CreditCardNumber);
		this.enterCardExpMonth(CreditCardExpirationMonth);
		this.enterCardExpYear(CreditCardExpirationYear);
		this.enterCardFirstName(CreditCardOwnerFirstName);
		this.enterCardMidName(CreditCardOwnerMiddleName);
		this.enterCardLastName(CreditCardOwnerLastName);
		this.clickPurchase();
		return new FlightConfirmationPageClass(myDriver, myWait);
	}

}
