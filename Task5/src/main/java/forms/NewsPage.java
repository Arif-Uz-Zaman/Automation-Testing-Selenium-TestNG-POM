package forms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import elements.Button;
import elements.Element;
import elements.Label;
import waits.ExplicitWait;

public class NewsPage extends BaseForm {

	private final Button optionsAndFiltersButton = new Button(
			By.xpath("//div[contains(@class,'eventcalendar_FilterLink') and contains(text(),'Options and Filters')]"));
	private final Element showTheseTypesOfPostsCheckboxes = new Element(
			By.xpath("//div[contains(text(),'Show these types of posts')]/parent::div"));
	private final Label noPostFoundMessage = new Label(By.xpath("//div[ contains(@class,'eventcalendar_EndOfRows')]"));

	public NewsPage() {
		super(new Element(By.xpath(
				"//div[contains(@class,'eventcalendar_NewsChannelListTitle') and contains(text(),'Your News & Events')]")));
	}

	public void clickOnOptionsAndFilters() {
		ExplicitWait.elementToBeClickable(optionsAndFiltersButton.getLocator());
		optionsAndFiltersButton.click();
	}

	public void untickAllCheckboxesForShowTheseTypesOfPosts() {
		WebElement checkboxesContainer = showTheseTypesOfPostsCheckboxes.getElement();
		List<WebElement> checkboxes = checkboxesContainer.findElements(By.className("DialogCheckbox"));

		// Untick all checkboxes
		for (WebElement checkbox : checkboxes) {
			if (checkbox.getAttribute("class").contains("Active")) {
				checkbox.click();
			}
		}

	}

	public boolean noPostFoundMessageIsDisplayed() {
		ExplicitWait.presenceOfElementLocated(noPostFoundMessage.getLocator());
		return noPostFoundMessage.isDisplayed();
	}

}
