package com.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.ProductPage;

public class AutomationTest {
	
	public WebDriver driver;
	public BasePage basepage;
	public ProductPage productpage;
	
	@BeforeSuite
	public void setup( ) {
		System.setProperty("webdriver.gecko.driver", "driver" + File.separator + "geckodriver.exe");
		driver = new FirefoxDriver();
		basepage = new BasePage(driver);	
		productpage = new ProductPage(driver);
	}

	@Test(priority=1)
	public void OpenSite_GotoShop() throws InterruptedException, IOException {									
		basepage.openSite();	
		basepage.goToShop();
	}
	
	@Test(priority=2)
	public void selectProduct() throws InterruptedException{
		basepage.selectProduct();
	}
	
	@Test(priority=3)
	public void selectQuantity_Color() throws InterruptedException {		
		productpage.selectQuantity_Color();
	}
	
	@Test(priority=4)
	public void addToCartVerifyTotal() throws InterruptedException {
		productpage.addToCart();
		productpage.verifyTotal();
		
	}
	
	@AfterMethod
	public void takeScreenshot() throws IOException{
		basepage.takeScreenshot();
		
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
