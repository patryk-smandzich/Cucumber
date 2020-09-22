package stepDefinitions;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import pageObject.WomenPage;

public class WomenSteps {

	TestContext testContext;
	WomenPage womenPage;

	public WomenSteps(TestContext context) {
		testContext = context;
		womenPage = testContext.getPageObjectManager().getWomenPage();
	}

	@Then("TOPS subcategory is available")
	public void tops_subcategory_is_available() {
		Assert.assertEquals(true, womenPage.isDisplayed_Tops());
	}

	@Then("DRESSES subcategory is available")
	public void dresses_subcategory_is_available() {
		Assert.assertEquals(true, womenPage.isDisplayed_Dresses());
	}

}
