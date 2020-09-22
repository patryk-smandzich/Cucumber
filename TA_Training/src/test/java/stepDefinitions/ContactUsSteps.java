package stepDefinitions;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ContactUsPage;

public class ContactUsSteps {

	TestContext testContext;
	ContactUsPage contactUsPage;

	public ContactUsSteps(TestContext context) {
		testContext = context;
		contactUsPage = testContext.getPageObjectManager().getContactUsPage();
	}

	@When("select {string} from Subject Heading")
	public void select_from_subject_heading(String select) {
		contactUsPage.select_SubjectHeading(select);
	}

	@When("enter {string} Email address")
	public void enter_email_address(String emial) {
		contactUsPage.enter_Emial(emial);
	}

	@When("enter {string} Order reference")
	public void enter_order_reference(String orderReference) {
		contactUsPage.enter_OrderReference(orderReference);
	}

	@When("Attach a file")
	public void attach_a_file() {
		contactUsPage.enter_AttachFile();
	}

	@When("enter {string} message")
	public void enter_message(String message) {
		contactUsPage.enter_Message(message);
	}

	@When("click Send")
	public void click_send() {
		contactUsPage.click_Send();
	}

	@Then("the confirmation message is displayed")
	public void the_confirmation_message_is_displayed() {
		Assert.assertEquals("Your message has been successfully sent to our team.",
				contactUsPage.getMessageSuccessfullySent());
	}

}
