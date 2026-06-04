package SoloProject.ProductsStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

	//genral constructor
    public productsStorePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnSamGalS6Product() {
    	driver.findElement(samGalS6).click();
	}

    public void addsamGalS6ToCart() {
    	driver.findElement(itemAddCart).click();
	}
    
    public void gobackToProducts() {
    	driver.findElement(productPage).click();
	}
    
    public void clickOnSamGalS7Product() {
    	driver.findElement(samGalS7).click();
	}

    public void addSamGalS7ToCart() {
    	driver.findElement(itemAddCart).click();
	}
    
    public void addTheItemsToCart() {
    	clickOnSamGalS6Product();
    	addsamGalS6ToCart();
    	gobackToProducts();
    	clickOnSamGalS7Product();
    	addSamGalS7ToCart();
	}
    
}
