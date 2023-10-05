package forms;


import elements.Element;
import waits.ExplicitWait;

public abstract class BaseForm {
	private final Element uniqueElement;

	public BaseForm(Element uniqueElement) {
		this.uniqueElement = uniqueElement;
	}

	public boolean isFormOpen() {
		ExplicitWait.presenceOfElementLocated(uniqueElement.getLocator());
		return uniqueElement.isDisplayed();
	}
}