package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Browser;

public class HomePage {
	
	private WebDriver driver;
	
	private By firstBigImage = By.xpath("//video[@class='fullscreen-bg__video']");
	private By loginButton = By.xpath("//a[@class='global_action_link' and contains(text(),'login')]");


	public HomePage() {
		this.driver = Browser.initialize(); // Access the WebDriver instance
	}
	
	public void clickOnTheLoginButton() {
		getLoginButton().click();
	}
	
	public boolean homepageFirstBigImageIsDisplayed() {
		return driver.findElement(firstBigImage).isDisplayed();
	}

	private WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
}
