package forms;

import org.openqa.selenium.By;

import elements.Element;
import elements.NavLinks;
import waits.ExplicitWait;

public class MainPage extends BaseForm {

	private final Element newAndNoteworthy = new Element(
			By.xpath("//a[@class='pulldown_desktop' and contains(text(),'New & Noteworthy')]"));
	private final NavLinks mostPlayed = new NavLinks(
			By.xpath("//a[@class='popup_menu_item' and contains(text(),'Most Played')]"));

	public MainPage() {
		super(new Element(By.xpath("//div[contains(@id,'home_maincap')]")));
	}

	public void moveCursorToNewAndNoteworthy() {
		newAndNoteworthy.moveToElement();
	}

	public void clickOnMostPlayed() {
		ExplicitWait.elementToBeClickable(mostPlayed.getLocator());
		mostPlayed.click();
	}
}
