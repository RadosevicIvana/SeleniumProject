package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
		driver.navigate().refresh();
		int tableSizeOneList = myWishlistPage.wishListSize();
		Assert.assertEquals(tableSizeOneList, 1);

	}

	@Test(priority = 2)
	public void multipleWishlists() {
		myAccountPage.myWishListTabClick();
		String wishlistName = excelReader.getData("Wishlist", 4, 11);
		int tableSizeOneList = myWishlistPage.wishListSize();

		for (int i = 1; i < 5; i++) {
			myWishlistPage.inputWishlistName(wishlistName + i);
			myWishlistPage.saveButtonClick();
		}
		int tableSizeMultipleLists = myWishlistPage.wishListSize();

		Assert.assertNotEquals(tableSizeOneList, tableSizeMultipleLists);
	}

	@Test(priority = 4)
	public void removeWishList() throws InterruptedException {
		myAccountPage.myWishListTabClick();
		int tableSizeWithLists = myWishlistPage.wishListSize();
		Thread.sleep(3000);
		System.out.println(tableSizeWithLists);

		for (int i = 0; i < tableSizeWithLists; i++) {
			waiter.until(ExpectedConditions.elementToBeClickable(myWishlistPage.getDeleteButton()));
			myWishlistPage.deleteButtonClick();
			myWishlistPage.alertMessage();
			Thread.sleep(3000);

		}
		driver.navigate().refresh();
		int tableSizeNoLists = myWishlistPage.wishListSize();
		Thread.sleep(3000);
		System.out.println(tableSizeNoLists);
		Assert.assertEquals(tableSizeNoLists, 0);
	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}

}
