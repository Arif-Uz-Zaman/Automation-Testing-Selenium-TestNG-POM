package pages;

import org.openqa.selenium.By;
import elements.Links;
import elements.Element;

public class HomePage {

	private final Element FeaturedAndRecommendedBanner = new Element(By.xpath("//div[contains(@id,'home_maincap')]"));
	private final Links PrivacyPolicy = new Links(By.xpath("//div[@id='footer_text']//a[contains(text(),'Privacy Policy')]"));

	public boolean FeaturedAndRecommendedBannerIsDisplayed() {
		return FeaturedAndRecommendedBanner.isDisplayed();
	}

	public void clickOnPrivacyPolicy() {
		PrivacyPolicy.click();
	}

	public void scrollDownToPrivacyPolicy() {
		PrivacyPolicy.scrollUntilEelementIsVisiable();
	}
}
