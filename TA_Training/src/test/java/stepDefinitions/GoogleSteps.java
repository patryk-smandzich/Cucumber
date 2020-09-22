package stepDefinitions;

import java.awt.AWTException;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.GooglePage;

public class GoogleSteps {

	TestContext testContext;
	GooglePage googlePage;

	public GoogleSteps(TestContext context) {
		testContext = context;
		googlePage = testContext.getPageObjectManager().getGooglePage();
	}

	@Given("user is on Google search page")
	public void user_is_on_google_search_page() {
		googlePage.navigateTo_GooglePage();
	}

	@When("accept cookies")
	public void accept_cookies() throws InterruptedException, AWTException {
		googlePage.acceptCookies();
	}

	@When("search for {string}")
	public void search_for(String search_Txt) {
		googlePage.enter_Search(search_Txt);
	}

	@Then("automationpractice website found")
	public void automationpractice_website_found() {
		Assert.assertEquals(true, googlePage.isDisplayed_AutomationpracticeLink());
	}

	@When("enter the automationpractice website")
	public void enter_the_automationpractice_website() {
		googlePage.enter_AutomationpracticePage();
	}

}
