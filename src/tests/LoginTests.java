package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	@BeforeMethod
	public void setup() {
		driver.navigate().to("http://automationpractice.com/index.php");

	}

	@Test(priority = 0)
	public void successfulLogin() {
		String email = excelReader.getData("Login", 4, 8);
		String password = excelReader.getData("Login", 4, 9);

		homePage.signInClick();
		loginInput(email, password);
		Assert.assertEquals(true, myAccountPage.getSignOutButton().isDisplayed());

	}

	@Test(priority = 2)
	public void invlidEmailLogin() {
		String email = excelReader.getData("Login", 4, 18);
		String password = excelReader.getData("Login", 4, 19);

		homePage.signInClick();
		loginInput(email, password);
		Assert.assertEquals(true, myAccountPage.getCredentialsWrongInput().isDisplayed());

	}

	@Test(priority = 4)
	public void invalidPasswordLogin() {
		String email = excelReader.getData("Login", 4, 28);
		String password = excelReader.getData("Login", 4, 29);

		homePage.signInClick();
		loginInput(email, password);
		Assert.assertEquals(true, myAccountPage.getCredentialsWrongInput().isDisplayed());
	}

	@Test(priority = 6)
	public void noInputLogin() {

		homePage.signInClick();
		myAccountPage.getEmailField().clear();
		myAccountPage.getPasswordField().clear();
		myAccountPage.signInButtonClick();
		Assert.assertEquals(true, myAccountPage.getCredentialsWrongInput().isDisplayed());

	}

	@Test(priority = 8)
	public void successfulLogOut() {
		successfulLogin();
		myAccountPage.signOutButtonClick();
		Assert.assertEquals(true, myAccountPage.getSignInButton().isDisplayed());

	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}

	public void loginInput(String email, String password) {
		myAccountPage.getEmailField().clear();
		myAccountPage.getEmailField().sendKeys(email);
		myAccountPage.getPasswordField().clear();
		myAccountPage.getPasswordField().sendKeys(password);
		myAccountPage.getSignInButton().click();

	}

}
