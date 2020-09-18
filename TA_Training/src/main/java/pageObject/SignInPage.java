package pageObject;

import java.util.Random;

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

	public String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr + "@gmail.com";

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
