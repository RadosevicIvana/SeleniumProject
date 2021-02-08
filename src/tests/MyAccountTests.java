package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTests extends TestBase {

	@BeforeMethod
	public void setup() {
		driver.navigate().to("http://automationpractice.com/index.php");
		
	}
	public void login() {
		String username = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);

		homePage.signInClick();
		myAccountPage.inputUsername(username);
		myAccountPage.inputPassword(password);
		myAccountPage.signInButtonClick();
	}
	@Test (priority = 0)
	public void updateAddress() {
		login();
		myAccountPage.addressesTabClick();
		addressesPage.updateButtonClick();
		String newAddress = excelReader.getData("TC2", 4, 6);
		
		addressesPage.getAddressField().clear();
		addressesPage.inputAddress(newAddress);
		addressesPage.saveButtonClick();
		excelReader.asserting("TC2", 5, 7, addressesPage.getAddressLabel().getText());
		
	}
	//@Test (priority = 2)
	public void AddAddress() {
		login();
		myAccountPage.addressesTabClick();
		addressesPage.addNewAddressClick();
		
		String address = excelReader.getData("TC2", 4, 13);
		String city = excelReader.getData("TC2", 4, 14);
		String state = excelReader.getData("TC2", 4, 15);
		String postalCode = excelReader.getData("TC2", 4, 16);
		String phoneNumber = excelReader.getData("TC2", 4, 17);
		String addressTitle = excelReader.getData("TC2", 4, 18);
		
		addressesPage.inputAddress(address);
		addressesPage.inputCity(city);
		addressesPage.chooseState(state);
		addressesPage.inputPostalCode(postalCode);
		addressesPage.inputPhoneNumber(phoneNumber);
		addressesPage.inputAddressTitle(addressTitle);
		addressesPage.saveNewAddress();
		excelReader.asserting("TC2", 5, 19, addressesPage.getAddressTwoLabel().getText());
		

	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
	}
}
