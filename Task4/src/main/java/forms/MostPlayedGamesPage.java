package forms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.Browser;
import elements.Element;
import elements.Table;
import models.Game;
import waits.ExplicitWait;

public class MostPlayedGamesPage extends BaseForm {

	private final Table mostPlayedGames = new Table(
			By.xpath("//table[contains(@class,'weeklytopsellers_ChartTable')]"));

	public MostPlayedGamesPage() {
		super(new Element(By.xpath("//div[contains(@class,'weeklytopsellers_ChartPlaceholder')]")));
	}

	public int getCurrentPlayersFor1stGame() {
		return getCurrentPlayersForGame(1);
	}

	public int getCurrentPlayersFor2ndGame() {
		return getCurrentPlayersForGame(2);
	}

	public int getCurrentPlayersFor3rdGame() {
		return getCurrentPlayersForGame(3);
	}

	public int getCurrentPlayersForGame(int gameNumber) {
		List<Game> gamesList = getMostPlayedGameDetailsFromTable();

		// Check if there's enough data to retrieve for the specified game
		if (gamesList.size() >= gameNumber) {
			// Access the specified game
			Game game = gamesList.get(gameNumber - 1);
			return game.getCurrentPlayers();
		} else {
			// Handle the case where there's insufficient data
			throw new IllegalStateException("Insufficient data to retrieve for game " + gameNumber + ".");
		}
	}

	public List<Game> getMostPlayedGameDetailsFromTable() {
		WebDriver driver = Browser.getDriver();
		List<Game> games = new ArrayList<>();
		ExplicitWait.presenceOfElementLocated(mostPlayedGames.getLocator());
		WebElement tbody = driver.findElement(By.tagName("tbody"));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			WebElement nameCell = row.findElement(By.xpath(".//div[contains(@class,'weeklytopsellers_GameName')]"));
			WebElement concurrentCell = row
					.findElement(By.xpath(".//td[contains(@class,'weeklytopsellers_ConcurrentCell')]"));

			String name = nameCell.getText();
			String concurrentCellText = concurrentCell.getText().replaceAll(",", ""); // Remove commas from the number

			try {
				int currentPlayers = Integer.parseInt(concurrentCellText);
				Game game = new Game(name, currentPlayers);
				games.add(game);
				// System.out.println(game.toString());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				// Handle parsing errors if needed
			}
		}
		// System.out.println("Number of games: " + games.size());
		return games;
	}

}
