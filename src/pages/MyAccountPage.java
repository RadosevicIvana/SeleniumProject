package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccountPage {

	WebDriver driver;
	WebElement usernameField;
	WebElement passwordField;
	WebElement signInButton;
	WebElement signOutButton;
	WebElement credentialsWrongInput; 
	WebElement myAddressesTab; 

	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}

	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}
	

	public WebElement getCredentialsWrongInput() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
	}
	

	public WebElement getMyAddressesTab() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a"));
	}

	public void inputUsername(String username) {
		this.getUsernameField().clear();
		this.getUsernameField().sendKeys(username);
	}

	public void inputPassword(String password) {
		this.getPasswordField().clear();
		this.getPasswordField().sendKeys(password);
	}

	public void signInButtonClick() {
		this.getSignInButton().click();
	}
	public void signOutButtonClick() {
		this.getSignOutButton().click();
	}

	public void assertSuccessfulLogin() {
		Assert.assertEquals(true, this.getSignOutButton().isDisplayed());
	}
	public void assertSuccessfulLogOut() {
		Assert.assertEquals(true, this.getSignInButton().isDisplayed());
	}
	public void addressesTabClick() {
		this.getMyAddressesTab().click();
	}
}
