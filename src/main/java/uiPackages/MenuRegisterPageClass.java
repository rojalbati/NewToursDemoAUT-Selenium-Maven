package uiPackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuRegisterPageClass extends BasePageClass {

	public MenuRegisterPageClass(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	/* List of all the Web Elements */

	// Headers
	@FindBy(how = How.LINK_TEXT, using = "SIGN-ON")
	private WebElement signon;
	// @FindBy(how = How.LINK_TEXT, using = "REGISTER")
	// private WebElement register;
	@FindBy(how = How.LINK_TEXT, using = "SUPPORT")
	private WebElement support;
	@FindBy(how = How.LINK_TEXT, using = "CONTACT")
	private WebElement contact;

	// Body
	@FindBy(how = How.NAME, using = "firstName")
	private WebElement firstName;
	@FindBy(how = How.NAME, using = "lastName")
	private WebElement lastName;
	@FindBy(how = How.NAME, using = "phone")
	private WebElement phone;
	@FindBy(how = How.NAME, using = "userName")
	private WebElement userName;
	@FindBy(how = How.NAME, using = "address1")
	private WebElement address1;
	@FindBy(how = How.NAME, using = "address2")
	private WebElement address2;
	@FindBy(how = How.NAME, using = "city")
	private WebElement city;
	@FindBy(how = How.NAME, using = "state")
	private WebElement state;
	@FindBy(how = How.NAME, using = "postalCode")
	private WebElement postalCode;
	@FindBy(how = How.NAME, using = "country")
	private WebElement country;
	@FindBy(how = How.NAME, using = "email")
	private WebElement email;
	@FindBy(how = How.NAME, using = "password")
	private WebElement password;
	@FindBy(how = How.NAME, using = "confirmPassword")
	private WebElement confirmPassword;
	@FindBy(how = How.NAME, using = "register")
	private WebElement register;

	private void enterfirstName(String a) {
		this.writeTextInWebElement(firstName, a);
	}

	private void enterlastName(String b) {
		this.writeTextInWebElement(lastName, b);
	}

	private void enterPhone(String c) {
		this.writeTextInWebElement(phone, c);
	}

	private void enterUserName(String d) {
		this.writeTextInWebElement(userName, d);
	}

	private void enterAddress1(String e) {
		this.writeTextInWebElement(address1, e);
	}

	private void enterAddress2(String f) {
		this.writeTextInWebElement(address2, f);
	}

	private void enterCity(String g) {
		this.writeTextInWebElement(city, g);
	}

	private void enterState(String h) {
		this.writeTextInWebElement(state, h);
	}

	private void enterPostalCode(String i) {
		this.writeTextInWebElement(postalCode, i);
	}

	private void enterCountry(String j) {
		this.writeTextInWebElement(country, j);
	}

	private void enterEmail(String k) {
		this.writeTextInWebElement(email, k);
	}

	private void enterPassword(String l) {
		this.writeTextInWebElement(password, l);
	}

	private void enterConfirmPassword(String m) {
		this.writeTextInWebElement(confirmPassword, m);
	}

	private void clickRegister() {
		this.clickElement(register);
	}
	
	
	
	
	public void waitForPageLoad(int time) {
		this.waitForPageLoad(time, register);

	}
	
	
	
	
	public CreateAccountSuccessPageClass Register(String FirstName, String LastName, String Phone, String Email,
			String Address1, String Address2, String City, String State, String PostalCode, String Country,
			String Username, String Password, String ConfirmPassword) {
		this.enterfirstName(FirstName);
		this.enterlastName(LastName);
		this.enterPhone(Phone);
		this.enterUserName(Email);
		this.enterAddress1(Address1);
		this.enterAddress2(Address2);
		this.enterCity(City);
		this.enterState(State);
		this.enterPostalCode(PostalCode);
		this.enterCountry(Country);
		this.enterEmail(Username);
		this.enterPassword(Password);
		this.enterConfirmPassword(ConfirmPassword);
		this.clickRegister();

		return new CreateAccountSuccessPageClass(myDriver, myWait);
	}

}
