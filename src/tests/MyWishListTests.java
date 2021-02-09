package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishListTests extends TestBase {

	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");
		String email = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);
		logIn(email, password);
	}

	//@Test(priority = 0)
	public void addWishList() {
		myAccountPage.myWishListTabClick();
		String wishlistName = excelReader.getData("TC4", 4, 5);
		myWishlistPage.inputWishlistName(wishlistName);
		myWishlistPage.saveButtonClick();
		myWishlistPage.assertTheFirstWishlist();

	}

	//@Test (priority = 2)
	public void multipleWishlists() {
		myAccountPage.myWishListTabClick();
		String wishlistName = excelReader.getData("TC4", 4, 11);
		myWishlistPage.inputWishlistName(wishlistName);
		myWishlistPage.saveButtonClick();
		myWishlistPage.assertTheSecondWishList();

	}

	@Test(priority = 4)
	public void removeWishList() throws InterruptedException {
		myAccountPage.myWishListTabClick();
		myWishlistPage.deleteButtonClick();
		myWishlistPage.alertMessage();
		myWishlistPage.assertTheFirstWishlist();
		Thread.sleep(2000);
		myWishlistPage.assertTheSecondWishList();
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}
}
