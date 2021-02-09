package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTests extends TestBase {

	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");

	}


	@Test(priority = 0)

	public void updateAddress() {
		String email = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);
		logIn(email, password);
		myAccountPage.addressesTabClick();
		addressesPage.updateButtonClick();
		String newAddress = excelReader.getData("TC2", 4, 6);

		addressesPage.getAddressField().clear();
		addressesPage.inputAddress(newAddress);
		addressesPage.saveButtonClick();
		excelReader.asserting("TC2", 5, 7, addressesPage.getAddressLabel().getText());

		addressesPage.updateButtonClick();
		String oldAddress = excelReader.getData("TC2", 4, 9);
		addressesPage.updateAddress(oldAddress);
		excelReader.asserting("TC2", 5, 10, addressesPage.getAddressLabel().getText());

	}

	@Test (priority = 2)
	public void AddAddress() {
		String email = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);
		logIn(email, password);
		myAccountPage.addressesTabClick();
		addressesPage.addNewAddressClick();

		String address = excelReader.getData("TC2", 4, 16);
		String city = excelReader.getData("TC2", 4, 17);
		String postalCode = excelReader.getData("TC2", 4, 19);
		String phoneNumber = excelReader.getData("TC2", 4, 20);
		String addressTitle = excelReader.getData("TC2", 4, 21);

		addressesPage.inputAddress(address);
		addressesPage.inputCity(city);
		addressesPage.chooseState(11);
		addressesPage.inputPostalCode(postalCode);
		addressesPage.inputPhoneNumber(phoneNumber);
		addressesPage.inputAddressTitle(addressTitle);
		addressesPage.saveNewAddressClick();
		excelReader.asserting("TC2", 5, 22, addressesPage.getAddressTwoLabel().getText());

	}

	@Test (priority = 4)
	public void deleteAddress() throws InterruptedException {
		String email = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);
		logIn(email, password);
		myAccountPage.addressesTabClick();
		addressesPage.deleteAddressButtonClick();
		addressesPage.alert();
		addressesPage.assertAddressTwoNotPresent();

	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}
}
