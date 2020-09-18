package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage {

	WebDriver driver;

	public CreateAnAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_gender1")
	WebElement rd_Mr;
	@FindBy(id = "customer_firstname")
	WebElement txtbx_FirstName;
	@FindBy(id = "customer_lastname")
	WebElement txtbx_LastName;
	@FindBy(id = "email")
	WebElement txtbx_Emial;
	@FindBy(id = "passwd")
	WebElement txtbx_Password;
	@FindBy(id = "days")
	WebElement drpdwn_Days;
	@FindBy(id = "months")
	WebElement drpdwn_Months;
	@FindBy(id = "years")
	WebElement drpdwn_Years;
	@FindBy(id = "newsletter")
	WebElement chkbx_Newsletter;
	@FindBy(id = "optin")
	WebElement chkbx_SpecialOfferts;
	@FindBy(id = "firstname")
	WebElement txtbx_FirstNameAddress;
	@FindBy(id = "lastname")
	WebElement txtbx_LastNameAddress;
	@FindBy(id = "company")
	WebElement txtbx_Company;
	@FindBy(id = "address1")
	WebElement txtbx_AddresLine1;
	@FindBy(id = "address2")
	WebElement txtbx_AddresLine2;
	@FindBy(id = "city")
	WebElement txtbx_City;
	@FindBy(id = "id_state")
	WebElement drpdwn_State;
	@FindBy(id = "postcode")
	WebElement txtbx_Zip;
	@FindBy(id = "id_country")
	WebElement drpdwn_Country;
	@FindBy(id = "other")
	WebElement txtbx_AdditionalInformation;
	@FindBy(id = "phone")
	WebElement txtbx_HomePhone;
	@FindBy(id = "phone_mobile")
	WebElement txtbx_MobilePhone;
	@FindBy(id = "alias")
	WebElement txtbx_Alias;
	@FindBy(id = "submitAccount")
	WebElement btn_Register;
	@FindBy(css = ".info-account")
	WebElement createAccontConfirmation;
	@FindBy(css = ".logout")
	WebElement btn_SignOut;

	public void select_Mr() {
		rd_Mr.click();
	}

	public void enter_FirstName() {
		txtbx_FirstName.sendKeys("FirstName");
	}

	public void enter_LastName() {
		txtbx_LastName.sendKeys("LastName");
	}

	public void click_Email() {
		txtbx_Emial.click();
	}

	public void enter_Password() {
		txtbx_Password.sendKeys("Password");
	}

	public void select_Days() {
		Select day = new Select(drpdwn_Days);
		day.selectByIndex(1);
	}

	public void select_Months() {
		Select month = new Select(drpdwn_Months);
		month.selectByIndex(1);
	}

	public void select_Years() {
		Select year = new Select(drpdwn_Years);
		year.selectByIndex(1);
	}

	public void click_Newsletter() {
		chkbx_Newsletter.click();
	}

	public void click_SpecialOffert() {
		chkbx_SpecialOfferts.click();
	}

	public void click_FirstNameAddres() {
		txtbx_FirstNameAddress.click();
	}

	public void click_LastNameAddres() {
		txtbx_LastNameAddress.click();
	}

	public void enter_Company() {
		txtbx_Company.sendKeys("Company");
	}

	public void enter_AddresLine1() {
		txtbx_AddresLine1.sendKeys("Line1");
	}

	public void enter_AddresLine2() {
		txtbx_AddresLine2.sendKeys("Line2");
	}

	public void enter_City() {
		txtbx_City.sendKeys("City");
	}

	public void select_State() {
		Select state = new Select(drpdwn_State);
		state.selectByIndex(1);
	}

	public void enter_Zip() {
		txtbx_Zip.sendKeys("11122");
	}

	public void select_Country() {
		Select country = new Select(drpdwn_Country);
		country.selectByValue("21");
	}

	public void enter_AdditionalInformation() {
		txtbx_AdditionalInformation.sendKeys("Info");
	}

	public void enter_HomePhone() {
		txtbx_HomePhone.sendKeys("111222333");
	}

	public void enter_MobilePhone() {
		txtbx_MobilePhone.sendKeys("444222333");
	}

	public void click_Alias() {
		txtbx_Alias.click();
	}

	public void click_Register() {
		btn_Register.click();
	}

	public void fillAllInformation() {
		select_Mr();
		enter_FirstName();
		enter_LastName();
		click_Email();
		enter_Password();
		select_Days();
		select_Months();
		select_Years();
		click_Newsletter();
		click_SpecialOffert();
		click_FirstNameAddres();
		click_LastNameAddres();
		enter_Company();
		enter_AddresLine1();
		enter_AddresLine2();
		enter_City();
		select_State();
		enter_Zip();
		select_Country();
		enter_AdditionalInformation();
		enter_HomePhone();
		enter_MobilePhone();
		click_Alias();
	}

	public String getCreateAccontConfirmation() {
		return createAccontConfirmation.getText();
	}

	public void click_SignOut() {
		btn_SignOut.click();
	}

}
