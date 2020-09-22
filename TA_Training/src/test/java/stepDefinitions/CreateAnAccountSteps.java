package stepDefinitions;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObject.CreateAnAccountPage;
import testDataTypes.Informations;

public class CreateAnAccountSteps {

	TestContext testContext;
	CreateAnAccountPage createAnAccountPage;

	public CreateAnAccountSteps(TestContext context) {
		testContext = context;
		createAnAccountPage = testContext.getPageObjectManager().getCreateAnAccountPage();
	}

	@When("enter informations to create a account")
	public void enter_informations_to_create_a_account() {
		createAnAccountPage.fillAllInformation(1, 1, 1, 1, "21");
	}

	@When("click register")
	public void click_register() {
		createAnAccountPage.click_Register();
	}

	@Then("the sign in confirmation message is displayed")
	public void the_sign_in_confirmation_message_is_displayed() {
		Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
				createAnAccountPage.getCreateAccontConfirmation());
	}

	@When("click logout")
	public void click_logout() {
		createAnAccountPage.click_SignOut();
	}

	@When("enter {string} to create a account")
	public void enter_to_create_a_account(String firstName) {
		Informations informations = FileReaderManager.getInstance().getJsonReader().getInformationsByName(firstName);
		createAnAccountPage.fillInformationViaJsonFile(informations, 1, 1, 1, 1, "21");
		createAnAccountPage.click_Register();
	}

}
