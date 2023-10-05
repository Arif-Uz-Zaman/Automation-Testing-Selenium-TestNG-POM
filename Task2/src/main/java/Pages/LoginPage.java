package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Browser;
import Utility.ExplicitWait;

public class LoginPage {

	private WebDriver driver;
	
	private By username = By.xpath("//input[contains(@class,'newlogindialog_TextInput_2eKVn') and @type='text']");
	private By password = By.xpath("//input[contains(@class,'newlogindialog_TextInput_2eKVn') and @type='password']");
	private By signInButton = By.xpath("//button[@type='submit' and contains(text(),'Sign in')]");
	private By errorMessage = By.xpath("//div[contains(@class,'newlogindialog_FormError_1Mcy9')]");
	private By loadingElement = By.xpath("//button[contains(@class,'newlogindialog_SubmitButton_2QgFE newlogindialog_Loading_i9MK3')]");
	
	
	public LoginPage() {
		this.driver = Browser.initialize(); // Access the WebDriver instance
	}
	
	private WebElement getUsernameField() {
		return driver.findElement(username);
	}
	
	private WebElement getPasswordField() {
		return driver.findElement(password);
	}
	
	private WebElement getSigninButton() {
		return driver.findElement(signInButton);
	}
	
	public boolean loginPageIsDisplayed() {
		ExplicitWait.presenceOfElementLocated(driver, username, 5);
		return getUsernameField().isDisplayed();
	}
	public void sentTextInUsername(String text) {
		driver.findElement(username).sendKeys(text);
	}
	
	public void sentTextInPassword(String text) {
		getPasswordField().sendKeys(text);
	}
	
	public void clickOnSignInButton() {
		getSigninButton().click();
	}
	
	public boolean erormessageIsDisplayed() {
		ExplicitWait.presenceOfElementLocated(driver, errorMessage, 5);
		return driver.findElement(errorMessage).isDisplayed();
	}
	
	public boolean loadingElementIsDisplayed() {
		ExplicitWait.presenceOfElementLocated(driver, loadingElement, 5);
		return driver.findElement(loadingElement).isDisplayed();
	}
	
	
}
