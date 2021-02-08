package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	@BeforeMethod
	public void setup() {
		driver.navigate().to("http://automationpractice.com/index.php");

	}

	@Test (priority = 0)
	public void successfulLogin() {
		String username = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);

		homePage.signInClick();
		myAccountPage.inputUsername(username);
		myAccountPage.inputPassword(password);
		myAccountPage.signInButtonClick();
		myAccountPage.assertSuccessfulLogin();

	}

	@Test (priority = 2)
	public void invlidCredentialsLogin() {
		String username = excelReader.getData("TC1", 4, 18);
		String password = excelReader.getData("TC1", 4, 19);

		homePage.signInClick();
		myAccountPage.inputUsername(username);
		myAccountPage.inputPassword(password);
		myAccountPage.signInButtonClick();
		excelReader.asserting("TC1", 5, 20, myAccountPage.getCredentialsWrongInput().getText());

	}

	@Test(priority = 4)
	public void noInputLogin() {

		homePage.signInClick();
		myAccountPage.getUsernameField().clear();
		myAccountPage.getPasswordField().clear();
		myAccountPage.signInButtonClick();
		excelReader.asserting("TC1", 5, 28, myAccountPage.getCredentialsWrongInput().getText());

	}

	@Test(priority = 6)
	public void successfulLogOut() {
		successfulLogin();
		myAccountPage.signOutButtonClick();
		myAccountPage.assertSuccessfulLogOut();

	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
	}

}
