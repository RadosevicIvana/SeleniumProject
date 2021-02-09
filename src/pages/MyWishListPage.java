package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishListPage {
	WebDriver driver;
	WebElement wishlistNameField;
	WebElement saveButton;
	WebElement deleteButton;

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

	public WebElement getDeleteButton() {
		return driver.findElement(By.className("icon-remove"));
	}

	public void inputWishlistName(String wishlistName) {
		this.getWishlistNameField().clear();
		this.getWishlistNameField().sendKeys(wishlistName);
	}

	public void saveButtonClick() {
		this.getSaveButton().click();
	}

	public void deleteButtonClick() {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", this.getDeleteButton());
		this.getDeleteButton().click();
	}

	public void assertTheFirstWishlist() {
		List<WebElement> dynamicElement = driver.findElements(By.className("mywishlist_first"));
		if (dynamicElement.size() != 0) {
			System.out.println("Element present");
		} else {
			System.out.println("Element not present");
		}
	}

	public void assertTheSecondWishList() {
		List<WebElement> dynamicElement = driver.findElements(By.className("mywishlist_second"));
		if (dynamicElement.size() != 0) {
			System.out.println("Element present");
		} else {
			System.out.println("Element not present");
		}
	}

	public void alertMessage() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}
