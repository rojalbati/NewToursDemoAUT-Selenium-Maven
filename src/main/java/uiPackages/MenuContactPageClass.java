package uiPackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuContactPageClass extends BasePageClass{

	public MenuContactPageClass(WebDriver driver, WebDriverWait wait) {
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
}
