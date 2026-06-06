package SoloProject.ProductsStore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
	WebDriver driver;						
	
											//locators for UI TCs
	// "about us" locator in downbar 
    By aboutUsDownBar = By.xpath("//b[normalize-space()='About Us']");
    // "about us" paragraph locator in downbar 
    By aboutUsDownBarPara = By.xpath("//p[contains(text(),'We believe performance needs')]");
    // "get in touch" locator
    By getInTouch = By.xpath("//b[normalize-space()='Get in Touch']");    //verify that all of the are visible
    // "product store" locator in downbar 
    By productStoreDownBar = By.xpath("//h4[normalize-space()='PRODUCT STORE']");
    By sonyVaioI5Vis = By.xpath("//a[normalize-space()='Sony vaio i5']");
  ///*****************************************
    //locator for next page button
    By nextPageBtn = By.xpath("//button[@id='next2']");
    //locator for apple monitor product
    By appleMonitor24 = By.xpath("//a[normalize-space()='Apple monitor 24']");
    //locator for apple monitor price
    By appleMonitor24Price = By.xpath("//h5[normalize-space()='$400']");
    
    //////////////////////////////////////////////////TC_UI_I001
    
  //genral constructor
    public homePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void scrollDown()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till sony i5 is visible 
		WebElement sony = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(sonyVaioI5Vis)));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
    //verify that "about us" in down bar visible 
    public boolean isAboutUsVis() {
		return driver.findElement(aboutUsDownBar).isDisplayed();
	}
    //verify that "about us" paragraph in down bar visible 
    public boolean isAboutUsParaVis() {
		return driver.findElement(aboutUsDownBarPara).isDisplayed();
	}
    // verify that "get in touch" in down bar visible 
    public boolean isGetInTouchVis() {
		return driver.findElement(getInTouch).isDisplayed();
	}
    // verify that "product store" in down bar visible 
    public boolean isProductStoreVis() {
		return driver.findElement(productStoreDownBar).isDisplayed();
	}
    //***********************************************************
    //click on next page button
    public void clickNextPage() {
		driver.findElement(nextPageBtn).click();
	}
    //vrify that apple monitor is visible 
    public String getAppleMonitor24Vis() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till sony i5 is visible 
		WebElement apple = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(appleMonitor24)));
		return apple.getText();
		
	}
  //vrify that apple monitor price is visible 
    public String getAppleMonitor24PriceVis() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till sony i5 is visible 
		WebElement apple = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(appleMonitor24Price)));
		return apple.getText();
	}
    //**************************************************************
    
    
    
    
}
