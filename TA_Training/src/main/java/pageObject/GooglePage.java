package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class GooglePage {

	WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[name='q']")
	WebElement txtbx_search;
	@FindBy(css = "[href='http://automationpractice.com/'] h3")
	WebElement automationpracticeLink;

	public void navigateTo_GooglePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getGoogleUrl());
	}

	public void acceptCookies() {
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe")));
		driver.findElement(By.cssSelector("#introAgreeButton")).click();
		driver.switchTo().defaultContent();
	}

	public void enter_Search(String txt_Search) {
		txtbx_search.sendKeys(txt_Search + Keys.ENTER);
	}

	public boolean isDisplayed_AutomationpracticeLink() {
		return automationpracticeLink.isDisplayed();
	}

	public void enter_AutomationpracticePage() {
		automationpracticeLink.click();
	}

}
