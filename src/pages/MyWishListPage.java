package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishListPage {
	WebDriver driver;
	WebElement wishlistNameField; 
	WebElement saveButton; 
	WebElement labelFirstWishlist; 

	public MyWishListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getWishlistNameField() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public WebElement getLabelFirstWishlist() {
		return driver.findElement(By.xpath("//*[@id=\"wishlist_28122\"]/td[1]/a"));
	}

	public void inputWishlistName(String wishlistName) {
		this.getWishlistNameField().clear();
		this.getWishlistNameField().sendKeys(wishlistName);
	}
	public void saveButtonClick() {
		this.getSaveButton().click();
	}

}
