package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IdentityTests extends TestBase {

	
	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");

	}
	
	@Test (priority = 0)
	public void editPersonalInformation() {
		String email = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);
		logIn(email, password);
		myAccountPage.myPersonalInformationTabClick();
		String newLastName = excelReader.getData("TC3", 4, 5);
		String currentPassword = excelReader.getData("TC3", 4, 6);
		identityPage.inputLastName(newLastName);
		identityPage.inputCurrentPassword(currentPassword);
		identityPage.saveButtonClick();
		excelReader.asserting("TC3", 5, 7, identityPage.getSuccessfulEditLabel().getText());
		
	}
	
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}
}
