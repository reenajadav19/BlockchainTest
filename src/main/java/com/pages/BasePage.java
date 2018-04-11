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

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Declaring obects

	@FindBy(id= "comp-j4o1o5uulink") private WebElement shopNowBtn;
	@FindBy(xpath= "(//img[contains(@alt,'m a product')])[4]") private WebElement product;


	/**
	 * Method to initialize the page factory objects 
	 */
	public BasePage(WebDriver driver){
		this.driver=driver;
		wait = new WebDriverWait(driver, 120);
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	public void openSite() {
		driver.get("https://arielkiell.wixsite.com/interview");
		
		
	}
	
	public void goToShop() {
		wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn));
		shopNowBtn.click();
	}
	
	public void selectProduct() throws InterruptedException {
		driver.switchTo().frame("TPASection_j4ci4xl4iframe");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
		product.click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	

	public void takeScreenshot() throws IOException {
	 
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("screenshot"+File.separator+System. currentTimeMillis()+".png")); 
	 
	}
	
	
}
