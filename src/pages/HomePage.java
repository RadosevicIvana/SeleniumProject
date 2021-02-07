package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
}
