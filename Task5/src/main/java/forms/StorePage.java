package forms;

import org.openqa.selenium.By;

import elements.Button;
import elements.Element;
import waits.ExplicitWait;

public class StorePage extends BaseForm {

	private final Button news = new Button(
			By.xpath("//a[contains(@class,'tab')]//span[contains(text(),'News')]"));

	public StorePage() {
		super(new Element(By.xpath("//div[contains(@id,'home_maincap')]")));
	}

	public void clickOnNews() {
		ExplicitWait.elementToBeClickable(news.getLocator());
		news.click();
	}
}
