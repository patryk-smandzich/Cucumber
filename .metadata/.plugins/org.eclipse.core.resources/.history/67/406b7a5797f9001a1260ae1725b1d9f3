package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.Wait;

public class ShoppingCartSummaryPage {

	WebDriver driver;

	public ShoppingCartSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".icon-minus")
	WebElement btn_Minus;
	@FindBy(css = ".icon-plus")
	WebElement btn_Plus;
	@FindBy(id = "total_product_price_2_7_0")
	WebElement totalBlousePrice;

	public void click_Minus() {
		btn_Minus.click();
	}

	public void click_Plus() {
		btn_Plus.click();
	}

	public void click_MinusXTimes(int howManyTimes) {
		for (int i = 0; i < howManyTimes; i++) {
			click_Minus();
			Wait.untilJqueryIsDone(driver);
		}
	}

	public void click_PlusXTimes(int howManyTimes) {
		for (int i = 0; i < howManyTimes; i++) {
			click_Plus();
			Wait.untilJqueryIsDone(driver);
		}
	}

	public String getTotalBlousePrice() {
		return totalBlousePrice.getText();
	}

}
