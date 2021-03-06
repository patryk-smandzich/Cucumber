package pageObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;
import selenium.Wait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "footer")
	WebElement footer;
	@FindBy(css = ".facebook [target='_blank']")
	WebElement btn_Facebook;
	@FindBy(css = ".twitter [target='_blank']")
	WebElement btn_Twitter;
	@FindBy(css = ".youtube [target='_blank']")
	WebElement btn_Youtube;
	@FindBy(css = ".google-plus [target='_blank']")
	WebElement btn_GooglePlus;
	@FindAll(@FindBy(css = "h5 a"))
	List<WebElement> products_Names;
	@FindAll(@FindBy(css = "div[class='button-container'] a:first-child"))
	List<WebElement> products_BtnsToCart;
	@FindAll(@FindBy(css = ".left-block .product-image-container"))
	List<WebElement> products_pcts;
	@FindAll(@FindBy(css = ".quick-view"))
	List<WebElement> products_quickViev;
	@FindBy(id = "layer_cart_product_price")
	WebElement cartProductPrice;
	@FindBy(xpath = "//span[@class='ajax_block_cart_total']")
	WebElement cartTotalPrice;
	@FindBy(css = "[title='Proceed to checkout']")
	WebElement btn_ProceedToCheckout;
	@FindBy(css = "[title='Contact us']")
	WebElement btn_ContactUs;
	@FindAll(@FindBy(css = "#blockbestsellers [itemprop='price']"))
	List<WebElement> prd_BestsellersListPrice;
	@FindAll(@FindBy(css = "#blockbestsellers .product-name"))
	List<WebElement> prd_BestsellersListName;
	@FindBy(css = "[href='#blockbestsellers']")
	WebElement btn_Bestsellers;
	@FindBy(css = ".login")
	WebElement btn_SignIn;
	@FindAll(@FindBy(xpath = "//*[@id]"))
	List<WebElement> allSiteIDs;
	@FindAll(@FindBy(css = ".fancybox [itemprop='image']"))
	List<WebElement> allThumbImages;
	@FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
	WebElement btn_Tshirts;
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
	WebElement btn_dresses;
	@FindBy(css = "[title='Casual Dresses'][style='']")
	WebElement btn_CasualDresses;
	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement btn_women;
	@FindBy(css = "[title='Blouses']")
	WebElement btn_Blouses;

	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void scrollToFooter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", footer);
	}

	public boolean isDisplayed_Facebook() {
		return btn_Facebook.isDisplayed();
	}

	public boolean isDisplayed_Twitter() {
		return btn_Twitter.isDisplayed();
	}

	public boolean isDisplayed_Youtube() {
		return btn_Youtube.isDisplayed();
	}

	public boolean isDisplayed_GooglePlus() {
		return btn_GooglePlus.isDisplayed();
	}

	public void click_Women() {
		btn_women.click();
	}

	public List<WebElement> getBtns_ToCart() {
		List<WebElement> btns = new ArrayList<>();
		for (WebElement btn : products_BtnsToCart) {
			btns.add(btn);
		}
		btns.subList(btns.size()/2, btns.size());
		return btns;
	}

	public List<String> getNamesToCart() {
		List<String> names = new ArrayList<>();
		for (WebElement name : products_Names) {
			names.add(name.getText());
		}
		names.subList(names.size()/2, names.size());
		return names;
	}

	public List<WebElement> getPcts_ToCart() {
		List<WebElement> pcts = new ArrayList<>();
		for (WebElement pct : products_pcts) {
			pcts.add(pct);
		}
		pcts.subList(pcts.size()/2, pcts.size());
		return pcts;
	}

	public List<WebElement> getProducts_quickViev() {
		List<WebElement> vievs = new ArrayList<>();
		for (WebElement viev : products_quickViev) {
			vievs.add(viev);
		}
		vievs.subList(vievs.size()/2, vievs.size());
		return vievs;
	}

	public String getCartProductPrice() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cartProductPrice));
		return cartProductPrice.getText();
	}

	public String getCartTotalPrice() {
		return cartTotalPrice.getText();
	}

	public void click_ProceedToCheckout() {
		btn_ProceedToCheckout.click();
	}

	public void click_ContactUs() {
		btn_ContactUs.click();
	}

	public void click_Bestsellers() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btn_Bestsellers);
		btn_Bestsellers.click();
		Wait.untilJqueryIsDone(driver);
	}

	public List<String> getBestsellersProductNames() {
		List<String> productNames = new ArrayList<>();
		for (WebElement name : prd_BestsellersListName) {
			productNames.add(name.getText());
		}
		return productNames;
	}

	public List<String> getBestsellersProductPrices() {
		List<String> productPrices = new ArrayList<>();
		for (WebElement price : prd_BestsellersListPrice) {
			if (price.getText().equals("")) {
			} else {
				productPrices.add(price.getText());
			}
		}
		return productPrices;
	}

	public void saveToFile() throws FileNotFoundException, InterruptedException {
		try (PrintStream out = new PrintStream(new FileOutputStream("filename.txt"))) {
			out.println(getBestsellersProductNames());
			out.println(getBestsellersProductPrices());
			out.close();
		}
	}

	public void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshot.png"));
	}

	public void click_SignIn() {
		btn_SignIn.click();
	}

	public List<String> getAllSiteIDs() throws InterruptedException {
		List<String> ids = new ArrayList<>();
		for (WebElement id : allSiteIDs) {
			ids.add(id.getAttribute("id"));
		}
		return ids;
	}

	public List<String> noDuplicatesArrayList() throws InterruptedException {
		Set<String> set = new HashSet<>(getAllSiteIDs());
		List<String> idNoDuplicate = new ArrayList<>();
		idNoDuplicate.addAll(set);
		return idNoDuplicate;
	}

	public void saveToFileIDs() throws FileNotFoundException, InterruptedException {
		try (PrintStream out = new PrintStream(new FileOutputStream("IDs.txt"))) {
			out.println(noDuplicatesArrayList());
			out.close();
		}
	}

	public void addItemToCart(String name) throws InterruptedException {
		int index = getNamesToCart().indexOf(name);
		System.out.println(getNamesToCart());
		System.out.println(index);
		Actions action = new Actions(driver);
		action.moveToElement(getPcts_ToCart().get(index)).build().perform();
		getBtns_ToCart().get(index).click();
	}
	
	public void addRandomItemToCart() throws InterruptedException {
		Random rand = new Random();
		int index = rand.nextInt(getBtns_ToCart().size()/2);
		System.out.println(index);
		Actions action = new Actions(driver);
		action.moveToElement(getPcts_ToCart().get(index)).build().perform();
		getBtns_ToCart().get(index).click();
	}

	public void click_ProductQuickView(String name) {
		int index = getNamesToCart().indexOf(name);
		Actions action = new Actions(driver);
		action.moveToElement(getPcts_ToCart().get(index)).moveToElement(getProducts_quickViev().get(index)).click()
				.build().perform();
		Wait.until(driver, ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='fancybox-overlay fancybox-overlay-fixed']")));
		Wait.untilJqueryIsDone(driver);
	}

	public List<String> saveBlosueImg() throws InterruptedException, MalformedURLException, IOException {
		driver.switchTo().frame(1);
		List<String> imgs = new ArrayList<>();
		int i = 0;
		for (WebElement img : allThumbImages) {
			BufferedImage bufferedImage = ImageIO.read(new URL(img.getAttribute("src")));
			File outputfile = new File("saved" + i + ".png");
			ImageIO.write(bufferedImage, "png", outputfile);
			imgs.add(img.getAttribute("src"));
			i++;
		}
		driver.switchTo().defaultContent();
		return imgs;
	}

	public void getNumberOfDownloadImages() throws MalformedURLException, InterruptedException, IOException {
		System.out.println(saveBlosueImg().size());
	}

	public void click_Tshirts() {
		btn_Tshirts.click();
	}

	public void click_CasualDresses() {
		btn_dresses.click();
	}


}
