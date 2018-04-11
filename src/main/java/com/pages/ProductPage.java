package com.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ProductPage {
	
	WebDriver driver;

	//Declaring obects
	@FindBy(xpath= "(//img[contains(@alt,'m a product')])[4]") private WebElement product;
	@FindBy(xpath= "//span[contains(@class,'up-arrow')]") private WebElement quantity;
	@FindBy(xpath= "//button[contains(@class,'button-add-to-cart')]") private WebElement addtoCartBtn;
	@FindBy(xpath= "//li[contains(@class,'color-selection')]") private WebElement selectColor;
	@FindBy(xpath= "//div[contains(@data-hook,'cart-widget-total')]") private WebElement cartTotal;
	@FindBy(xpath= "//a[contains(@data-hook,'widget-view-cart-button')]") private WebElement viewCartBtn;
	@FindBy(xpath= "//button[contains(@data-hook,'checkout-button-button')]") private WebElement checkoutBtn;
	

	/**
	 * Method to initialize the page factory objects 
	 */
	public ProductPage(WebDriver driver){
		this.driver=driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
		
	public void selectProduct() throws InterruptedException {
		driver.switchTo().frame("TPASection_j4ci4xl4iframe");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
		product.click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	
	public void selectQuantity_Color() {
		driver.switchTo().frame("TPAMultiSection_j4ci4xqbiframe");
		quantity.click();
		quantity.click();
		selectColor.click();
	}
	
	public void addToCart() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectColor);
		addtoCartBtn.click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	
	public void verifyTotal( ) {
		driver.switchTo().frame(5);
		Assert.assertEquals(cartTotal.getText(), "C$75.00");
		driver.switchTo().defaultContent();
	}
	
	
}
