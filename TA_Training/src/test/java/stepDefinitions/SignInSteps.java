package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;
import pageObject.SignInPage;

public class SignInSteps {
	
	TestContext testContext;
	SignInPage signInPage;

	public SignInSteps(TestContext context) {
		testContext = context;
		signInPage = testContext.getPageObjectManager().getSignInPage();
	}
	
	@When("enter email to create an account")
	public void enter_email_to_create_an_account() {
		String randomEmial = signInPage.getSaltString();
		testContext.scenarioContext.setContext(Context.EMAIL, randomEmial);
		signInPage.enter_RandomEmailAddresCreateAccount(randomEmial);
	}
	
	@When("click Create an account")
	public void click_create_an_account() {
	    signInPage.click_CreateAnAccount();
	}
	

	@When("sign in with new accout details")
	public void sign_in_with_new_accout_details() {
		String email = (String) testContext.scenarioContext.getContext(Context.EMAIL);
	    signInPage.enter_SignIn(email);
	}
	

	
	
	

}
