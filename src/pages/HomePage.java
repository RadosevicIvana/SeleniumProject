package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	WebElement SignIn;

	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSignIn() {
		return driver.findElement(By.className("login")); 
	}
	public void signInClick() {
		this.getSignIn().click();
	}
	
}
