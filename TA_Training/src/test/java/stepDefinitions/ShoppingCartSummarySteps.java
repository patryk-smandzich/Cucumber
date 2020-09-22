package stepDefinitions;

import java.io.FileNotFoundException;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ShoppingCartSummaryPage;

public class ShoppingCartSummarySteps {

	TestContext testContext;
	ShoppingCartSummaryPage shoppingCartSummaryPage;

	public ShoppingCartSummarySteps(TestContext context) {
		testContext = context;
		shoppingCartSummaryPage = testContext.getPageObjectManager().getShoppingCartSummaryPage();
	}

	@When("click the plus button {int} times")
	public void click_the_plus_button_times(Integer howManyTimes) {
		shoppingCartSummaryPage.click_PlusXTimes(howManyTimes);
	}

	@When("lick the minus button {int} times")
	public void lick_the_minus_button_times(Integer howManyTimes) {
		shoppingCartSummaryPage.click_MinusXTimes(howManyTimes);
	}

	@Then("the total price is {string}")
	public void the_total_price_is_$(String price) {
		Assert.assertEquals(price, shoppingCartSummaryPage.getTotalBlousePrice());
	}

	@When("save the product names and prices to a file")
	public void save_the_product_names_and_prices_to_a_file() throws FileNotFoundException, InterruptedException {
		shoppingCartSummaryPage.saveProductNamesAndPrices();
	}

	@When("proceed from cart summary to checkout")
	public void proceed_from_cart_summary_to_checkout() {
		shoppingCartSummaryPage.click_ProceedToCheckout();
	}

	@When("proceed from address to checkout")
	public void proceed_from_address_to_checkout() {
		shoppingCartSummaryPage.click_ProceedToCheckoutAddress();
	}

	@When("proceed from shipping to checkout")
	public void proceed_from_shipping_to_checkout() {
		shoppingCartSummaryPage.click_Terms();
		shoppingCartSummaryPage.click_ProceedToCheckoutShipping();
	}

	@When("pay via check")
	public void pay_via_check() throws InterruptedException {
		shoppingCartSummaryPage.click_PayViaCheck();
		shoppingCartSummaryPage.click_ConfirmOrder();
	}

	@Then("order confirmation is displayed")
	public void order_confirmation_is_displayed() throws InterruptedException {
		Assert.assertEquals("Your order on My Store is complete.", shoppingCartSummaryPage.getOrderConfirmation());
	}

}
