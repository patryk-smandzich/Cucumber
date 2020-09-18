package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObject.HomePage;

public class HomeSteps {

	TestContext testContext;
	HomePage homePage;

	public HomeSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		homePage.navigateTo_HomePage();
	}

	@When("scroll to the footer")
	public void scroll_to_the_footer() {
		homePage.scrollToFooter();
	}

	@Then("Facebook icon is displayed")
	public void facebook_icon_is_displayed() {
		Assert.assertEquals(true, homePage.isDisplayed_Facebook());
	}

	@Then("Twitter icon is displayed")
	public void twitter_icon_is_displayed() {
		Assert.assertEquals(true, homePage.isDisplayed_Twitter());
	}

	@Then("Google icon is displayed")
	public void google_icon_is_displayed() {
		Assert.assertEquals(true, homePage.isDisplayed_GooglePlus());
	}

	@Then("Youtube icon is displayed")
	public void youtube_icon_is_displayed() {
		Assert.assertEquals(true, homePage.isDisplayed_Youtube());
	}

	@When("enter the Women category")
	public void enter_the_women_category() {
		homePage.click_Women();
	}

	@When("add to cart Blouse item")
	public void add_to_cart_blouse_item() {
		homePage.addToCartBlouse();
	}

	@Then("the item price prive should be {string}")
	public void the_item_price_prive_should_be(String itemPrice) {
		Assert.assertEquals(itemPrice, homePage.getCartProductPrice());
	}

	@Then("the total price prive should be {string}")
	public void the_total_price_prive_should_be(String totalPrice) {
		Assert.assertEquals(totalPrice, homePage.getCartTotalPrice());
	}

	@When("proceed to checkout")
	public void proceed_to_checkout() {
		homePage.click_ProceedToCheckout();
	}

	@When("enter Contact us Page")
	public void enter_contact_us_page() {
		homePage.click_ContactUs();
	}

	@When("open bestsellers section")
	public void open_bestsellers_section() throws InterruptedException {
		homePage.click_Bestsellers();
	}

	@When("log names and prices to console")
	public void log_names_and_prices_to_console() throws InterruptedException {
		System.out.println(homePage.getBestsellersProductNames());
		System.out.println(homePage.getBestsellersProductPrices());
	}

	@When("log names and prices to file")
	public void log_names_and_prices_to_file() throws FileNotFoundException, InterruptedException {
		homePage.saveToFile();
	}

	@Then("capture a screenshot of displayed products")
	public void capture_a_screenshot_of_displayed_products() throws IOException {
		homePage.takeScreenshot();
	}

	@When("enter Sign in")
	public void enter_sign_in() {
		homePage.click_SignIn();
	}

	@When("capture all diffrent IDs")
	public void capture_all_diffrent_i_ds() throws InterruptedException {
		homePage.noDuplicatesArrayList();
	}

	@Then("save the IDs to a file")
	public void save_the_i_ds_to_a_file() throws FileNotFoundException, InterruptedException {
		homePage.saveToFileIDs();
	}

	@When("enter the Blouse Quick viev")
	public void enter_the_blouse_quick_viev() {
		homePage.click_BlouseQuickView();
	}

	@When("download thumbs images")
	public void download_thumbs_images() throws MalformedURLException, InterruptedException, IOException {
		homePage.saveBlosueImg();
	}

	@Then("log the number of download images")
	public void log_the_number_of_download_images() throws MalformedURLException, InterruptedException, IOException {
		homePage.getNumberOfDownloadImages();
	}
	
	@When("enter the t-shirt category")
	public void enter_the_t_shirt_category() {
	    homePage.click_Tshirts();
	}
	
	@When("enter the casual dresses category")
	public void enter_the_casual_dresses_category() {
		homePage.click_CasualDresses();
	}
	
	@When("enter the women category")
	public void enter_the_blouses_category() {
	    homePage.click_Women();
	}


}
