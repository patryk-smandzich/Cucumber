package managers;

import org.openqa.selenium.WebDriver;

import pageObject.ContactUsPage;
import pageObject.CreateAnAccountPage;
import pageObject.GooglePage;
import pageObject.HomePage;
import pageObject.ShoppingCartSummaryPage;
import pageObject.WomenPage;
import pageObject.SignInPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private GooglePage googlePage;
	private WomenPage womenPage;
	private ShoppingCartSummaryPage shoppingCartSummaryPage;
	private ContactUsPage contactUsPage;
	private SignInPage signInPage;
	private CreateAnAccountPage createAnAccountPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public GooglePage getGooglePage() {
		return (googlePage == null) ? googlePage = new GooglePage(driver) : googlePage;
	}

	public WomenPage getWomenPage() {
		return (womenPage == null) ? womenPage = new WomenPage(driver) : womenPage;
	}

	public ShoppingCartSummaryPage getShoppingCartSummaryPage() {
		return (shoppingCartSummaryPage == null) ? shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver)
				: shoppingCartSummaryPage;
	}

	public ContactUsPage getContactUsPage() {
		return (contactUsPage == null) ? contactUsPage = new ContactUsPage(driver) : contactUsPage;
	}

	public SignInPage getSignInPage() {
		return (signInPage == null) ? signInPage = new SignInPage(driver) : signInPage;
	}

	public CreateAnAccountPage getCreateAnAccountPage() {
		return (createAnAccountPage == null) ? createAnAccountPage = new CreateAnAccountPage(driver)
				: createAnAccountPage;
	}

}
