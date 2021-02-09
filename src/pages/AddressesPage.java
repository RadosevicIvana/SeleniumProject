package pages;

import java.util.List;

import org.openqa.selenium.Alert;
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
	WebElement deleteAddressButton;

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
		return driver.findElement(By.id("id_state"));
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
		return driver.findElement(By.xpath("//div[@class='addresses']/div/div[2]/ul/li/h3"));
	}

	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}

	public WebElement getAddressLabel() {
		return driver.findElement(By.className("address_address1"));
	}

	public WebElement getDeleteAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]"));
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

	public void chooseState(int index) {
		Select stateFromDropDown = new Select(getStateField());
		stateFromDropDown.selectByIndex(index);
	}

	public void inputPostalCode(String postalCode) {
		this.getPostalCodeField().sendKeys(postalCode);
	}

	public void inputPhoneNumber(String phoneNumber) {
		this.getHomePhoneField().sendKeys(phoneNumber);
	}

	public void inputAddressTitle(String addressTitle) {
		this.getAddressTitleField().clear();
		this.getAddressTitleField().sendKeys(addressTitle);
	}

	public void saveNewAddressClick() {
		this.getSaveButton().click();
	}

	public void updateAddress(String oldAddress) {
		this.getAddressField().clear();
		this.inputAddress(oldAddress);
		this.saveButtonClick();
	}

	public void deleteAddressButtonClick() {
		this.getDeleteAddressButton().click();
	}

	public void alert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void assertAddressTwoNotPresent() {
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//div[@class='addresses']/div/div[2]/ul/li/h3"));
		if(dynamicElement.size() != 0){
			 System.out.println("Element present");
			}
			else{
			 System.out.println("Element not present");
			}
	}
}
