package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IdentityTests extends TestBase {

	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");
		String email = excelReader.getData("Login", 4, 8);
		String password = excelReader.getData("Login", 4, 9);
		logIn(email, password);
	}

	@Test(priority = 0)
	public void editPersonalInformation() {

		myAccountPage.myPersonalInformationTabClick();
		String newLastName = excelReader.getData("MyPersonalInformation", 4, 5);
		String currentPassword = excelReader.getData("MyPersonalInformation", 4, 6);
		identityPage.inputLastName(newLastName);
		identityPage.inputCurrentPassword(currentPassword);
		identityPage.saveButtonClick();
		Assert.assertEquals(true, identityPage.getSuccessfulEditLabel().isDisplayed());
		excelReader.asserting("MyPersonalInformation", 5, 7, identityPage.getProfileName().getText());
		returnToPreviousLastName();

	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}

	public void returnToPreviousLastName() {
		identityPage.backToMyAccountClick();
		myAccountPage.myPersonalInformationTabClick();
		String oldLastName = excelReader.getData("MyPersonalInformation", 4, 4);
		String currentPassword = excelReader.getData("MyPersonalInformation", 4, 6);
		identityPage.inputLastName(oldLastName);
		identityPage.inputCurrentPassword(currentPassword);
		identityPage.saveButtonClick();
		Assert.assertEquals(true, identityPage.getSuccessfulEditLabel().isDisplayed());
		excelReader.asserting("MyPersonalInformation", 5, 4, identityPage.getProfileName().getText());
	}
}
