package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AddressesPage;
import pages.HomePage;
import pages.MyAccountPage;
public class TestBase {

	WebDriver driver;
	XSSFWorkbook wb;
	ExcelReader excelReader;
	HomePage homePage; 
	MyAccountPage myAccountPage; 
	AddressesPage addressesPage; 

	@BeforeClass
	public void preKlase() throws IOException {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.excelReader = new ExcelReader("Data/SeleniumFinalProject.xlsx");
		this.homePage = new HomePage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.addressesPage = new AddressesPage(driver);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void posleKlase() throws IOException {
		driver.close();
		driver.quit();
		excelReader.fis.close();
	}

}
