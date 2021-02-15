package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

	WebDriver driver;

	WebElement productsQuantity;
	WebElement product1Label;
	WebElement product2Label;
	WebElement product3Label;
	WebElement removeProductButton;
	WebElement emptyCartMessage;

	public OrderPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductsQuantity() {
		return driver.findElement(By.id("summary_products_quantity"));
	}

	public WebElement getProduct1Label() {
		return driver.findElement(By.xpath("//*[@id=\"product_1_1_0_445554\"]/td[2]/p/a"));
	}

	public WebElement getProduct2Label() {
		return driver.findElement(By.xpath("//*[@id=\"product_2_7_0_445554\"]/td[2]/p/a"));
	}

	public WebElement getProduct3Label() {
		return driver.findElement(By.xpath("//*[@id=\"product_3_13_0_445554\"]/td[2]/p/a"));
	}

	public WebElement getRemoveProductButton() {
		return driver.findElement(By.className("icon-trash"));
	}

	public WebElement getEmptyCartMessage() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p"));
	}

	public void removeProductClick() {
		this.getRemoveProductButton().click();
	}
}
