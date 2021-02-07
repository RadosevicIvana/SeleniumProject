package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	WebDriver driver;
	XSSFWorkbook wb;
	ExcelReader excelReader;

	@BeforeClass
	public void preKlase() throws IOException {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.excelReader = new ExcelReader("");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void posleKlase() throws IOException {
		driver.close();
		driver.quit();
		excelReader.fis.close();
	}

}
