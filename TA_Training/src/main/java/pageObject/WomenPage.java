package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {

	WebDriver driver;

	public WomenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5//a[contains(text(),'Tops')]")
	WebElement btn_Tops;
	@FindBy(xpath = "//h5//a[contains(text(),'Dresses')]")
	WebElement btn_Dresses;

	public boolean isDisplayed_Tops() {
		return btn_Tops.isDisplayed();
	}

	public boolean isDisplayed_Dresses() {
		return btn_Dresses.isDisplayed();
	}

}
