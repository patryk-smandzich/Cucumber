package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.Wait;
import testDataTypes.Informations;

public class CategoriesPages {

	WebDriver driver;

	public CategoriesPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Quick view')]")
	WebElement btn_quickView;
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement btn_AddToCart;
	@FindBy(css = "[title='Close window']")
	WebElement btn_CloseWindow;
	@FindBy(css = "[title='Proceed to checkout']")
	WebElement btn_ProceedToCheckout;

	public void click_QuickView() {
		btn_quickView.click();
	}

	public void click_Product1(Informations informations) {
		WebElement product = driver.findElement(
				By.cssSelector("[title='" + informations.product1 + "'] [title='" + informations.product1 + "']"));
		Actions action = new Actions(driver);
		action.moveToElement(product).moveToElement(btn_quickView).click().build().perform();
		Wait.until(driver, ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='fancybox-overlay fancybox-overlay-fixed']")));
		Wait.untilJqueryIsDone(driver);
	}

	public void click_Product2(Informations informations) {
		WebElement product = driver.findElement(
				By.cssSelector("[title='" + informations.product2 + "'] [title='" + informations.product2 + "']"));
		WebElement viev = driver
				.findElement(By.xpath("//a[@title='" + informations.product2 + "']//following-sibling::a"));
		Actions action = new Actions(driver);
		action.moveToElement(product).moveToElement(viev).click().build().perform();
		Wait.until(driver, ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='fancybox-overlay fancybox-overlay-fixed']")));
		Wait.untilJqueryIsDone(driver);
	}

	public void click_Product3(Informations informations) {
		WebElement product = driver.findElement(
				By.cssSelector("[title='" + informations.product3 + "'] [title='" + informations.product3 + "']"));
		WebElement viev = driver
				.findElement(By.xpath("//a[@title='" + informations.product3 + "']//following-sibling::a"));
		Actions action = new Actions(driver);
		action.moveToElement(product).moveToElement(viev).click().build().perform();
		Wait.until(driver, ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='fancybox-overlay fancybox-overlay-fixed']")));
		Wait.untilJqueryIsDone(driver);
	}

	public void click_AddToCart() {
		driver.switchTo().frame(0);
		btn_AddToCart.click();
		driver.switchTo().defaultContent();
	}

	public void click_CloseWindow() {
		btn_CloseWindow.click();
		Wait.untilJqueryIsDone(driver);
	}

	public void addToCartProduct() {
		click_AddToCart();
		click_CloseWindow();
	}

	public void click_ProceedToCheckout() {
		btn_ProceedToCheckout.click();
	}

}
