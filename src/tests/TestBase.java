package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AddressesPage;
import pages.HomePage;
import pages.IdentityPage;
import pages.MyAccountPage;
import pages.MyWishListPage;
import pages.OrderPage;

public class TestBase {

	WebDriver driver;
	XSSFWorkbook wb;
	ExcelReader excelReader;
	WebDriverWait waiter;
	// Pages
	HomePage homePage;
	MyAccountPage myAccountPage;
	AddressesPage addressesPage;
	IdentityPage identityPage;
	MyWishListPage myWishlistPage;
	OrderPage orderPage;

	public void logIn(String email, String password) {
		homePage.signInClick();
		myAccountPage.loginInput(email, password);
	}

	@BeforeClass
	public void preKlase() throws IOException {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.excelReader = new ExcelReader("Data/SeleniumFinalProject.xlsx");
		this.homePage = new HomePage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.addressesPage = new AddressesPage(driver);
		this.identityPage = new IdentityPage(driver);
		this.myWishlistPage = new MyWishListPage(driver);
		this.waiter = new WebDriverWait(driver, 40);
		this.orderPage = new OrderPage(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void posleKlase() throws IOException {
		driver.close();
		driver.quit();
		excelReader.fis.close();
	}

}
