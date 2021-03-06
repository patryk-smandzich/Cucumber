package pageObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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
	@FindBy(css = ".first_item .cart_total .price")
	WebElement totalFirstProductPrice;
	@FindBy(linkText = "Faded Short Sleeve T-shirts")
	WebElement product1Name;
	@FindBy(linkText = "Printed Chiffon Dress")
	WebElement product2Name;
	@FindBy(xpath = "//td[@class='cart_description']//a[contains(text(),'Blouse')]")
	WebElement product3Name;
	@FindAll(@FindBy(xpath = "//td[@class='cart_total']//span[@class='price']"))
	List<WebElement> productPrice;
	@FindBy(css = ".cart_navigation [title='Proceed to checkout']")
	WebElement btn_ProceedToCheckout;
	@FindBy(css = "[name='processAddress']")
	WebElement btn_ProceedToCheckoutAddress;
	@FindBy(css = "[for='cgv']")
	WebElement chkbx_Terms;
	@FindBy(css = "[name='processCarrier']")
	WebElement btn_ProceedToCheckoutShipping;
	@FindBy(css = "[title='Pay by check.']")
	WebElement btn_PayViaCheck;
	@FindBy(css = "#cart_navigation .button")
	WebElement btn_CorfirmOrder;
	@FindBy(css = "#center_column > p.alert.alert-success")
	WebElement orderConfirmation;

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
		return totalFirstProductPrice.getText();
	}

	public String getProduct1Name() {
		return product1Name.getText();
	}

	public String getProduct2Name() {
		return product2Name.getText();
	}

	public String getProduct3Name() {
		return product3Name.getText();
	}

	public List<String> getProductNames() {
		List<String> productNames = new ArrayList<>();
		productNames.add(getProduct1Name());
		productNames.add(getProduct2Name());
		productNames.add(getProduct3Name());
		return productNames;
	}

	public List<String> getProductPrices() {
		List<String> prices = new ArrayList<>();
		for (WebElement price : productPrice) {
			prices.add(price.getText());
		}
		return prices;
	}

	public void saveProductNamesAndPrices() throws FileNotFoundException {
		try (PrintStream out = new PrintStream(new FileOutputStream("productNamesAndPrices.txt"))) {
			for (int i = 0; i < 3; i++) {
				out.println("Product: " + getProductNames().get(i) + "         Price: " + getProductPrices().get(i));
			}
			out.close();
		}
	}

	public void click_ProceedToCheckout() {
		btn_ProceedToCheckout.click();
	}

	public void click_ProceedToCheckoutAddress() {
		btn_ProceedToCheckoutAddress.click();
	}

	public void click_Terms() {
		chkbx_Terms.click();
	}

	public void click_ProceedToCheckoutShipping() {
		btn_ProceedToCheckoutShipping.click();
	}

	public void click_PayViaCheck() {
		btn_PayViaCheck.click();
	}

	public void click_ConfirmOrder() {
		btn_CorfirmOrder.click();
	}

	public String getOrderConfirmation() {
		return orderConfirmation.getText();
	}

}
