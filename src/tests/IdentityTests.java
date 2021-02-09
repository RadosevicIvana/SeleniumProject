package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IdentityTests extends TestBase {

	
	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");
		String email = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);
		logIn(email, password);
	}
	
	@Test (priority = 0)
	public void editPersonalInformation() {
		
		myAccountPage.myPersonalInformationTabClick();
		String newLastName = excelReader.getData("TC3", 4, 5);
		String currentPassword = excelReader.getData("TC3", 4, 6);
		identityPage.inputLastName(newLastName);
		identityPage.inputCurrentPassword(currentPassword);
		identityPage.saveButtonClick();
		Assert.assertEquals(true, identityPage.getSuccessfulEditLabel().isDisplayed());
		excelReader.asserting("TC3", 5, 7, identityPage.getProfileName().getText());
		
		
		
		
		
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}
}
