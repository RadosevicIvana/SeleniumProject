package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressesPage {
	WebDriver driver;
	WebElement addANewAddress;
	WebElement addressField;
	WebElement cityField;
	WebElement stateField;
	WebElement postalCodeField;
	WebElement homePhoneField;
	WebElement addressTitleField;
	WebElement saveButton;
	WebElement addressTwoLabel;
	WebElement updateButton;
	WebElement addressLabel;

	public AddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddANewAddress() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a"));
	}

	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getStateField() {
		return driver.findElement(By.id("id_country"));
	}

	public WebElement getPostalCodeField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getHomePhoneField() {
		return driver.findElement(By.id("phone"));
	}

	public WebElement getAddressTitleField() {
		return driver.findElement(By.id("alias"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}

	public WebElement getAddressTwoLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[1]/h3"));
	}
	

	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}

	public WebElement getAddressLabel() {
		return driver.findElement(By.className("address_address1"));
	}

	public void updateButtonClick() {
		this.getUpdateButton().click();
	}
	
	
	public void saveButtonClick() {
		this.getSaveButton().click();
	}
	
	public void addNewAddressClick() {
		this.getAddANewAddress().click();
	}
	

	public void inputAddress(String address) {
		this.getAddressField().sendKeys(address);
	}

	public void inputCity(String city) {
		this.getCityField().sendKeys(city);
	}

	public void chooseState(String state) {
		Select drpState = new Select(this.getStateField());
		drpState.selectByVisibleText(state);
	}

	public void inputPostalCode(String postalCode) {
		this.getPostalCodeField().sendKeys(postalCode);
	}

	public void inputPhoneNumber(String phoneNumber) {
		this.getHomePhoneField().sendKeys(phoneNumber);
	}

	public void inputAddressTitle(String addressTitle) {
		this.getAddressTitleField().sendKeys(addressTitle);
	}

	public void saveNewAddress() {
		this.getSaveButton().click();
	}
	
}
