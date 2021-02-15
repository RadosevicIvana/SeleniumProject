package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends TestBase {

	@BeforeMethod
	public void setup() {

		driver.navigate().to("http://automationpractice.com/index.php");
		String email = excelReader.getData("Login", 4, 8);
		String password = excelReader.getData("Login", 4, 9);
		logIn(email, password);
	}

	@Test(priority = 0)
	public void addOneProduct() throws InterruptedException {
		myAccountPage.homeButtonClick();
		homePage.addToCartProduct1Click();
		continueShoppingButtonClick();
		Thread.sleep(4000);
		homePage.viewMyCartButtonClick();
		excelReader.asserting("Cart", 5, 7, orderPage.getProductsQuantity().getText());

	}

	@Test(priority = 2)
	public void addOneProductThreeTimes() throws InterruptedException {
		myAccountPage.homeButtonClick();
		for (int i = 0; i < 3; i++) {
			homePage.addToCartProduct1Click();
			continueShoppingButtonClick();
		}

		homePage.viewMyCartButtonClick();
		excelReader.asserting("Cart", 5, 18, orderPage.getProductsQuantity().getText());

	}

	@Test(priority = 4)
	public void addThreeProductsToCart() throws InterruptedException {
		myAccountPage.homeButtonClick();
		homePage.addToCartProduct1Click();
		continueShoppingButtonClick();
		homePage.addToCartProduct2Click();
		continueShoppingButtonClick();
		homePage.addToCartProduct3Click();
		continueShoppingButtonClick();
		homePage.viewMyCartButtonClick();

		excelReader.asserting("Cart", 5, 23, orderPage.getProduct1Label().getText());
		excelReader.asserting("Cart", 5, 25, orderPage.getProduct2Label().getText());
		excelReader.asserting("Cart", 5, 27, orderPage.getProduct3Label().getText());
	}

	@Test(priority = 6)

	public void removeProductFromCart() throws InterruptedException {
		addOneProduct();
		orderPage.removeProductClick();
		Thread.sleep(3000);
		excelReader.asserting("Cart", 5, 37, orderPage.getEmptyCartMessage().getText());
		
	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}

	public void continueShoppingButtonClick() {
		waiter.until(ExpectedConditions.elementToBeClickable(homePage.getContinueShoppingButton()));
		homePage.continueShoppingButtonClick();
	}
}
