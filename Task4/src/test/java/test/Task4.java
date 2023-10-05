package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.Browser;
import forms.MainPage;
import forms.MostPlayedGamesPage;
import utility.DataReader;

public class Task4 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Browser.initialize();
		driver.manage().window().maximize();
		driver.get(DataReader.getStringValue("url", "config"));
	}

	@Test
	public void testMostPlayedGames() {
		MainPage mainpage = new MainPage();
		MostPlayedGamesPage mostplayedgamepage = new MostPlayedGamesPage();

		// Main page Validation
		boolean isHomePageDisplayed = mainpage.isFormOpen();
		Assert.assertTrue(isHomePageDisplayed, "Main page is Not open");

		// step-2 Move cursor to New & Noteworthy and click 'Most Played' in a dropdown
		mainpage.moveCursorToNewAndNoteworthy();
		mainpage.clickOnMostPlayed();

		// Most Played page Validation
		boolean isMostPlayedPageDisplayed = mostplayedgamepage.isFormOpen();
		Assert.assertTrue(isMostPlayedPageDisplayed, "Most Played page is Not open");

		// step-3 Retrieve number of Current players for 1st and 2nd game
		int firstGameCurrentPlayers = mostplayedgamepage.getCurrentPlayersFor1stGame();
		int secondGameCurrentPlayers = mostplayedgamepage.getCurrentPlayersFor2ndGame();

		// 1st game in the list has more Current Players than 2nd Validation
		boolean firstGameHasMoreCurrentPlayers = firstGameCurrentPlayers > secondGameCurrentPlayers;
		Assert.assertTrue(firstGameHasMoreCurrentPlayers, "1st game should have more Current Players than 2nd game");

		// step-4 Retrieve number of Current players for 3rd game
		int thirdGameCurrentPlayers = mostplayedgamepage.getCurrentPlayersFor3rdGame();

		// 2nd game in the list has more Current Players than 3rd Validation
		boolean secondGameHasMoreCurrentPlayers = secondGameCurrentPlayers > thirdGameCurrentPlayers;
		Assert.assertTrue(secondGameHasMoreCurrentPlayers, "2nd game should have more Current Players than 3rd game");

	}

	@AfterMethod
	public void teardown() {
		Browser.quitDriver();
	}
}
