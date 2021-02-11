package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishListTests extends TestBase {

	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");
		String email = excelReader.getData("Login", 4, 8);
		String password = excelReader.getData("Login", 4, 9);
		logIn(email, password);
	}

	@Test(priority = 0)
	public void addWishList() {
		myAccountPage.myWishListTabClick();
		String wishlistName = excelReader.getData("Wishlist", 4, 5);
		myWishlistPage.inputWishlistName(wishlistName);
		myWishlistPage.saveButtonClick();
		assertTheFirstWishlist();

	}

	@Test (priority = 2)
	public void multipleWishlists() {
		myAccountPage.myWishListTabClick();
		String wishlistName = excelReader.getData("Wishlist", 4, 11);
		myWishlistPage.inputWishlistName(wishlistName);
		myWishlistPage.saveButtonClick();
		assertTheSecondWishList();

	}

	@Test(priority = 4)
	public void removeWishList() throws InterruptedException {
		myAccountPage.myWishListTabClick();
		myWishlistPage.deleteButtonClick();
		myWishlistPage.alertMessage();
		assertTheFirstWishlist();
		Thread.sleep(2000);
		assertTheSecondWishList();
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
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}
}
