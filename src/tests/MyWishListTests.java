package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishListTests extends TestBase {

	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");

	}



	@Test(priority = 0)
	public void addWishList() {
		String email = excelReader.getData("TC1", 4, 8);
		String password = excelReader.getData("TC1", 4, 9);
		logIn(email, password);
		myAccountPage.myWishListTabClick();
		String wishlistName = excelReader.getData("TC4", 4, 5);
		myWishlistPage.inputWishlistName(wishlistName);
		myWishlistPage.saveButtonClick();
		excelReader.asserting("TC4", 5, 6, myWishlistPage.getLabelFirstWishlist().getText());

	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}
}
