package SoloProject.ProductsStore;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productsStorePage {
	
	WebDriver driver;	
												//locators for 2 items for cart TCs
	// Samsung galaxy s6 locator
    By samGalS6 = By.xpath("//a[normalize-space()='Samsung galaxy s6']");
    // go to product page locator
    By productPage = By.xpath("//a[@id='nava']");
	// Samsung galaxy s7 locator
    By samGalS7 = By.xpath("//a[normalize-space()='Samsung galaxy s7']");
    // item add to cart locator
    By itemAddCart = By.xpath("//a[normalize-space()='Add to cart']");
    // catagory sevtion locator
    //By catagories = By.xpath("//a[@id='cat']");


	//genral constructor
    public productsStorePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnSamGalS6Product() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove();");
		js.executeScript("window.scrollBy(0, 300);");
    	driver.findElement(samGalS6).click();
	}

    public void addsamGalS6ToCart() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(itemAddCart));
    	addToCartBtn.click();
    	Alert alertItemAdded = wait.until(ExpectedConditions.alertIsPresent());
    	alertItemAdded.accept();
	}
    
    public void gobackToProducts() {
    	driver.findElement(productPage).click();
	}
    
    public void clickOnSamGalS7Product() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove();");
		js.executeScript("window.scrollBy(0, 1000);");
    	WebElement clcikOnSamGaS7 = wait.until(ExpectedConditions.elementToBeClickable(samGalS7));
		clcikOnSamGaS7.click();
	}

    public void addSamGalS7ToCart() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(itemAddCart));
    	addToCartBtn.click();
    	Alert alertItemAdded = wait.until(ExpectedConditions.alertIsPresent());
    	alertItemAdded.accept();
	}
    
    public void addTheItemsToCart() {
    	clickOnSamGalS6Product();
    	addsamGalS6ToCart();
    	gobackToProducts();
    	clickOnSamGalS7Product();
    	addSamGalS7ToCart();
	}
    
}
