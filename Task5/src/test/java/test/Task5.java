package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.Browser;
import forms.NewsPage;
import forms.StorePage;
import utility.DataReader;

public class Task5 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Browser.initialize();
		driver.manage().window().maximize();
		driver.get(DataReader.getStringValue("url", "config"));
	}

	@Test
	public void testNewsFilters() {
		StorePage storePage = new StorePage();
		NewsPage newsPage = new NewsPage();

		// Main page Validation
		boolean isHomePageDisplayed = storePage.isFormOpen();
		Assert.assertTrue(isHomePageDisplayed, "Store page is Not open");

		// step-2 Click on News Button
		storePage.clickOnNews();

		// News page Validation
		boolean isNewsPageDisplayed = newsPage.isFormOpen();
		Assert.assertTrue(isNewsPageDisplayed, "News page is Not open");

		// step-3 Click Option and Filters
		newsPage.clickOnOptionsAndFilters();

		// step-4 Untick all options in 'Show these types of posts' part
		newsPage.untickAllCheckboxesForShowTheseTypesOfPosts();
		

		// No posts found message validation
		boolean isNoPostFoundMessageDisplayed = newsPage.noPostFoundMessageIsDisplayed();
		Assert.assertTrue(isNoPostFoundMessageDisplayed,
				"Message 'No posts found. Try selecting different search criteria in the sidebar.' is not displayed");

	}

	@AfterMethod
	public void teardown() {
		Browser.quitDriver();
	}
}
