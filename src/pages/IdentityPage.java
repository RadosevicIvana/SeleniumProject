package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdentityPage {

	WebDriver driver;
	WebElement lastNameField;
	WebElement saveButton; 
	WebElement successfulEditLabel;
	WebElement currentPasswordField;
	WebElement profileName; 
	WebElement backToMyAccount; 
	 

	public IdentityPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastname"));
	}
	
	
	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}

	
	public WebElement getCurrentPasswordField() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getSuccessfulEditLabel() {
		return driver.findElement(By.className("alert-success"));
	}

	public WebElement getBackToMyAccount() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a"));
	}

	public WebElement getProfileName() {
		return driver.findElement(By.className("account"));
	}

	public void inputLastName(String newLastName) {
		this.getLastNameField().clear();
		this.getLastNameField().sendKeys(newLastName);
	}
	public void inputCurrentPassword(String currentPassword) {
		this.getCurrentPasswordField().clear();
		this.getCurrentPasswordField().sendKeys(currentPassword);
		
	}
	public void saveButtonClick() {
		this.getSaveButton().click();
	}
	
	
}
