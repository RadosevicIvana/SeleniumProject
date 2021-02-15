package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	WebElement SignIn;
	WebElement addToCartProduct1;
	WebElement addToCartProduct2;
	WebElement addToCartProduct3;
	WebElement continueShoppingButton;
	WebElement cartButton;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSignIn() {
		return driver.findElement(By.className("login"));
	}

	public WebElement getAddToCartProduct1() {
		return driver.findElement(By.xpath("//a[@data-id-product = '1']"));
	}

	public WebElement getAddToCartProduct2() {
		return driver.findElement(By.xpath("//a[@data-id-product = '2']"));
	}

	public WebElement getAddToCartProduct3() {
		return driver.findElement(By.xpath("//a[@data-id-product = '3']"));
	}

	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.xpath("//div[@class='button-container']/span"));
	}

	public WebElement getCartButton() {
		return driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
	}

	public void signInClick() {
		this.getSignIn().click();
	}

	public void addToCartProduct1Click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", this.getAddToCartProduct1());

	}

	public void addToCartProduct2Click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", this.getAddToCartProduct2());

	}

	public void addToCartProduct3Click() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", this.getAddToCartProduct3());

	}

	public void continueShoppingButtonClick() {
		this.getContinueShoppingButton().click();

	}

	public void viewMyCartButtonClick() {
		this.getCartButton().click();
	}

}
