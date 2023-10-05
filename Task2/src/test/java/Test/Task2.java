package Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Browser;
import Pages.HomePage;
import Pages.LoginPage;
import Utility.RandomString;

public class Task2 {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = Browser.initialize();
		driver.get("https://store.steampowered.com/");
	}
	
	@Test
	public void TestInvalidLogin() {
		HomePage homepage = new HomePage();
		
		//Home page validation
		Assert.assertTrue(homepage.homepageFirstBigImageIsDisplayed(), "Home Page is Not Displayed");
		
		//step - 2 Click login button
		homepage.clickOnTheLoginButton();
		
		//Login page Validation
		LoginPage login = new LoginPage();
		Assert.assertTrue(login.loginPageIsDisplayed(), "Login Page is not Displayed");
		
		//Step - 3 input random strings as credentials then Click sign in button.
		login.sentTextInUsername(RandomString.generateRandomString(5));
		login.sentTextInPassword(RandomString.generateRandomString(6));
		login.clickOnSignInButton();
		
		// Loading Element Validation
		Assert.assertTrue(login.loadingElementIsDisplayed(),"Loading Element is Not Displayed");
		
		// Error text validation
		Assert.assertTrue(login.erormessageIsDisplayed()," Error Text is not Displayed");;
	}
	
	@AfterMethod 
	public void teardown() {
		Browser.quitDriver();
	}
}
