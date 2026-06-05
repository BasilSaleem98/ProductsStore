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
    // phone locator in catagory section 
    By phoneCat = By.xpath("(//a[normalize-space()='Phones'])");
	// Samsung galaxy s6 product locator
    By samGalS6Pro = By.xpath("//a[normalize-space()='Samsung galaxy s6']");
    // samsung galaxy s 6 name locator
    By samGalS6Name = By.xpath("//h2[normalize-space()='Samsung galaxy s6']"); 
    // samsung galaxy s 6 name locator
    By samGalS6Price = By.xpath("//h3[@class='price-container']"); 
    // go to product page locator
    By productPage = By.xpath("//a[@id='nava']");
	// Samsung galaxy s7 product locator
    By samGalS7Pro = By.xpath("//a[normalize-space()='Samsung galaxy s7']");
    // samsung galaxy s 7 name locator
    By samGalS7Name = By.xpath("//h2[normalize-space()='Samsung galaxy s7']");
    // samsung galaxy s 7 proce locator
    By samGalS7Price = By.xpath("//h3[@class='price-container']"); 
    // item add to cart locator
    By itemAddCart = By.xpath("//a[normalize-space()='Add to cart']");
    
    //variabels
    String samGS6Name,samGS6Price,samGS7Name,samGS7Price;


	//genral constructor
    public productsStorePage(WebDriver driver) {
        this.driver = driver;
    }
	//click on samsung galaxy S6
    public void clickOnSamGalS6Product() throws InterruptedException {
    	Thread.sleep(2000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement phoneBtn = wait.until(ExpectedConditions.elementToBeClickable(phoneCat));
    	Thread.sleep(2000);
    	phoneBtn.click();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
        WebElement sGS6=driver.findElement(samGalS6Pro);
        sGS6.click();
    	Thread.sleep(500);
    	samGS6Name = driver.findElement(samGalS6Name).getText();  //get name and price samsung galaxy S6
    	Thread.sleep(500);
    	String getFullTxt =driver.findElement(samGalS6Price).getText();
    	samGS6Price = getFullTxt.split(" ")[0]; //take first value which is price
	}
	//add samsung galaxy S6 on cart
    public void addsamGalS6ToCart() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(itemAddCart));
    	addToCartBtn.click();
    	Alert alertItemAdded = wait.until(ExpectedConditions.alertIsPresent());
    	alertItemAdded.accept();
    	driver.findElement(productPage).click();
	}
	//go back to home screen
    public void goBackToProducts() throws InterruptedException {
    	driver.findElement(productPage).click();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 700);");
	    Thread.sleep(2000); 
	}
	//click on samsung galaxy S7
    public void clickOnSamGalS7Product() throws InterruptedException {
    	driver.findElement(phoneCat).click(); //to navegate phones from catagory
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement clcikOnSamGaS7 = wait.until(ExpectedConditions.elementToBeClickable(samGalS7Pro));
		clcikOnSamGaS7.click();
    	Thread.sleep(500);
    	samGS7Name = driver.findElement(samGalS7Name).getText();
        String getFullTxt = driver.findElement(samGalS7Price).getText();       //get name and price of samsung galaxy S7
    	samGS7Price =  getFullTxt.split(" ")[0];  //take first value which is price
	}
    //add samsung galaxy S7 on cart
    public void addSamGalS7ToCart() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(itemAddCart));
    	addToCartBtn.click();
    	Alert alertItemAdded = wait.until(ExpectedConditions.alertIsPresent());
    	alertItemAdded.accept();
	}
    // actions to add items to cart
    public void addTheItemsToCart() throws InterruptedException {
    	clickOnSamGalS6Product();
    	addsamGalS6ToCart();
    	goBackToProducts();
    	clickOnSamGalS7Product();
    	addSamGalS7ToCart();
	}
    //get name from SGS6
    public String getSGS6Name() {
		return samGS6Name;
		
	}
    //get price from SGS6
    public String getSGS6Price() {
		return samGS6Price;
		
	} 
    //get name from SGS7
    public String getSGS7Name() {
		return samGS7Name;
		
	}
    //get price from SGS7
    public String getSGS7Price() {
		return samGS7Price;
		
	}
}
