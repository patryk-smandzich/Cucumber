package pageObject;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.TestContext;

public class SignInPage {

	WebDriver driver;
	TestContext testContext;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email_create")
	WebElement txtbx_EmailAddresCreateAccount;
	@FindBy(id = "SubmitCreate")
	WebElement btn_CreateAnAccount;
	@FindBy(id = "email")
	WebElement txtbx_EmailAddresSignIn;
	@FindBy(id = "passwd")
	WebElement txtbx_Password;
	@FindBy(css = "[name='SubmitLogin']")
	WebElement btn_SignIn;

	public String getRandomEmial() {
		String randomUserName = RandomStringUtils.randomAlphanumeric(20);
		return new StringBuilder(randomUserName).append("@gmail.com").toString();
	}

	public void enter_RandomEmailAddresCreateAccount(String mail) {
		txtbx_EmailAddresCreateAccount.sendKeys(mail);
	}

	public void click_CreateAnAccount() {
		btn_CreateAnAccount.click();
	}

	public void enter_EmailAddresSignIn(String email) {
		txtbx_EmailAddresSignIn.sendKeys(email);
	}

	public void enter_Password() {
		txtbx_Password.sendKeys("Password");
	}

	public void click_SignIn() {
		btn_SignIn.click();
	}

	public void enter_SignIn(String email) {
		enter_EmailAddresSignIn(email);
		enter_Password();
		click_SignIn();
	}

}
