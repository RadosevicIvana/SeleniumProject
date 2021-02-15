package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class MyAccountPage {

	WebDriver driver;
	
	WebElement myAddressesTab;
	WebElement myWishListTab; 
	WebElement myPersonalInformationTab;
	WebElement emailField;
	WebElement passwordField;
	WebElement signInButton;
	WebElement signOutButton;
	WebElement credentialsWrongInput; 
	WebElement homeButton;
	 

	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmailField() {
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
		return driver.findElement(By.className("alert-danger"));
	}
	

	public WebElement getMyAddressesTab() {
		return driver.findElement(By.xpath("//a[@title=\"Addresses\"]"));
		
	}
	
	public WebElement getMyPersonalInformationTab() {
		return driver.findElement(By.xpath("//a[@title=\"Information\"]"));
	}
	

	public WebElement getMyWishListTab() {
		return driver.findElement(By.xpath("//a[@title=\"My wishlists\"]"));
	}
	

	public WebElement getHomeButton() {
		return driver.findElement(By.xpath("//a[@title='Home']"));
	}

	public void loginInput(String email, String password) {
		this.getEmailField().clear();
		this.getEmailField().sendKeys(email);
		this.getPasswordField().clear();
		this.getPasswordField().sendKeys(password);
		this.getSignInButton().click();
		
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
	public void myPersonalInformationTabClick() {
		this.getMyPersonalInformationTab().click();
	}
	public void myWishListTabClick() {
		this.getMyWishListTab().click();
	}
	public void homeButtonClick() {
		this.getHomeButton().click();
	}
}
