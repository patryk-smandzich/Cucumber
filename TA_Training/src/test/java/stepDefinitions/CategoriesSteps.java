package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObject.CategoriesPages;
import testDataTypes.Informations;

public class CategoriesSteps {

	TestContext testContext;
	CategoriesPages categoriesPages;

	public CategoriesSteps(TestContext context) {
		testContext = context;
		categoriesPages = testContext.getPageObjectManager().getCategoriesPages();
	}

	@When("add to cart a {string} t-shirt")
	public void add_to_cart_a_t_shirt(String firstName) {
		Informations informations = FileReaderManager.getInstance().getJsonReader().getInformationsByName(firstName);
		categoriesPages.click_Product1(informations);
		categoriesPages.addToCartProduct();
	}

	@When("add to cart a {string} casual dres")
	public void add_to_cart_a_casual_dres(String firstName) {
		Informations informations = FileReaderManager.getInstance().getJsonReader().getInformationsByName(firstName);
		categoriesPages.click_Product2(informations);
		categoriesPages.addToCartProduct();
	}

	@When("add to cart a {string} blouse")
	public void add_to_cart_a_blouse(String firstName) {
		Informations informations = FileReaderManager.getInstance().getJsonReader().getInformationsByName(firstName);
		categoriesPages.click_Product3(informations);
		categoriesPages.addToCartProduct();
	}

}
