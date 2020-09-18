package stepDefinitions;

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


}
