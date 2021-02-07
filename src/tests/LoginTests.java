package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
		
	}
	@Test 
	public void working() {
		
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
}
