package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTests extends TestBase {

	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");
		String email = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);
		logIn(email, password);

	}


	//@Test(priority = 0)

	public void updateAddress() throws InterruptedException {
		
		myAccountPage.addressesTabClick();
		addressesPage.updateButtonClick();
		String oldAddress = addressesPage.getAddressField().getText();
		addressesPage.getAddressField().clear();
		String newAddress = excelReader.getData("TC2", 4, 6);
		addressesPage.getAddressField().clear();
		addressesPage.inputAddress(newAddress);
		Thread.sleep(2000);
		addressesPage.saveButtonClick();
		Assert.assertEquals(addressesPage.getAddressLabel().getText(), newAddress);
		
		addressesPage.updateButtonClick();
		addressesPage.updateAddress(oldAddress);
		Assert.assertEquals(addressesPage.getAddressLabel(), oldAddress);

	}

	@Test (priority = 2)
	public void AddAddress() {
		
		myAccountPage.addressesTabClick();
		addressesPage.addNewAddressClick();

		String address = excelReader.getData("TC2", 4, 16);
		String city = excelReader.getData("TC2", 4, 17);
		String postalCode = excelReader.getData("TC2", 4, 19);
		String phoneNumber = excelReader.getData("TC2", 4, 20);
		String addressTitle = excelReader.getData("TC2", 4, 21);

		addressesPage.addNewAddress(address, city, 11, postalCode, phoneNumber, addressTitle);
		addressesPage.assertAddressTwoPresent();

	}

	@Test (priority = 4)
	public void deleteAddress() throws InterruptedException {
		
		myAccountPage.addressesTabClick();
		addressesPage.deleteAddressButtonClick();
		addressesPage.alert();
		addressesPage.assertAddressTwoPresent();

	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}
}
