package uiPackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountSuccessPageClass extends BasePageClass{

	public CreateAccountSuccessPageClass(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a[1]")
	@CacheLookup
	WebElement signin;
	
	private void clickSignIn() {
		this.clickElement(signin);
	}
	public MenuSignOnPageClass SignIn() {
		this.clickSignIn();
		return new MenuSignOnPageClass(myDriver, myWait);
	}
	public void waitForPageLoad(int time) {
		this.waitForPageLoad(time, signin);

	}
}
