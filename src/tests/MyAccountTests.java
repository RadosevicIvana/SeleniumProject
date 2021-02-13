package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTests extends TestBase {

	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");
		String email = excelReader.getData("Login", 4, 8);
		String password = excelReader.getData("Login", 4, 9);
		logIn(email, password);

	}

	@Test(priority = 0)

	public void updateAddress() {

		myAccountPage.addressesTabClick();
		addressesPage.updateButtonClick();
		addressesPage.getAddressField().clear();
		String newAddress = excelReader.getData("MyAddress", 4, 6);
		addressesPage.inputAddress(newAddress);
		waiter.until(ExpectedConditions.elementToBeClickable(addressesPage.getSaveButton()));
		addressesPage.saveButtonClick();
		Assert.assertEquals(addressesPage.getAddressLabel().getText(), newAddress);
		driver.navigate().refresh();
		returnToPreviousAddress();

	}

	@Test(priority = 2)
	public void AddAddress() {

		myAccountPage.addressesTabClick();
		addressesPage.addNewAddressClick();

		String address = excelReader.getData("MyAddress", 4, 16);
		String city = excelReader.getData("MyAddress", 4, 17);
		String postalCode = excelReader.getData("MyAddress", 4, 19);
		String phoneNumber = excelReader.getData("MyAddress", 4, 20);
		String addressTitle = excelReader.getData("MyAddress", 4, 21);

		addNewAddress(address, city, 11, postalCode, phoneNumber, addressTitle);
		driver.navigate().refresh();
		assertAddressTwoPresent();

	}

	@Test(priority = 4)
	public void removeAddress() throws InterruptedException {

		myAccountPage.addressesTabClick();
		addressesPage.deleteAddressButtonClick();
		addressesPage.alert();
		driver.navigate().refresh();
		Thread.sleep(3000);
		assertAddressTwoPresent();
		//Assert.assertNull(addressesPage.getAddressTwoLabel());
	

	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}

	public void addNewAddress(String address, String city, int index, String postalCode, String phoneNumber,
			String addressTitle) {
		addressesPage.inputAddress(address);
		addressesPage.inputCity(city);
		addressesPage.chooseState(11);
		addressesPage.inputPostalCode(postalCode);
		addressesPage.inputPhoneNumber(phoneNumber);
		addressesPage.inputAddressTitle(addressTitle);
		addressesPage.saveNewAddressClick();
	}

	public void assertAddressTwoPresent() {
		if (addressesPage.getAddressTwoLabel().size()==0) {
			System.out.println("Element not present, appearing " + addressesPage.getAddressTwoLabel().size() + " time");
		}
		else {
			 System.out.println("Element present, appearing "+ addressesPage.getAddressTwoLabel().size() + " time");
		}
	}

	public void returnToPreviousAddress() {
		addressesPage.updateButtonClick();
		addressesPage.getAddressField().clear();
		String oldAddress = excelReader.getData("MyAddress", 4, 9);
		addressesPage.inputAddress(oldAddress);
		addressesPage.saveButtonClick();
		Assert.assertEquals(addressesPage.getAddressLabel().getText(), oldAddress);
	}

}
