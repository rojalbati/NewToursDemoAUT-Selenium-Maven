package uiPackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageClass {
	
	public WebDriver myDriver;
	
	public WebDriverWait myWait;
	
	public BasePageClass(WebDriver driver, WebDriverWait wait) {
		this.myDriver = driver;
		this.myWait= wait;
		PageFactory.initElements(myDriver, this);	
	}
	
	public String getPageTitle() {
		String pageTitle ="";
		if(myDriver.getTitle()!= "") {
			pageTitle= myDriver.getTitle();
		}
		else {
			pageTitle = "Not Valid Page";
		}
		return pageTitle;
	}
	
	public void writeTextInWebElement(WebElement element , String textToWrite) {
		element.sendKeys(textToWrite);
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}
	public void clearElement(WebElement element) {
		element.clear();
	}
	public void waitForPageLoad(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(myDriver, time );		
		//check the element to be visible by WebElement
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
