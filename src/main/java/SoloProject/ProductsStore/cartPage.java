package SoloProject.ProductsStore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartPage {
	
		WebDriver driver;	
	//*********************************************locators for cart 	
	
								//locators for cart TCs (dont forget that items locators are in product store page)
		// cart button in TopBar locator
		By cartTopBar = By.xpath("//a[@id='cartur']");
		// total price items locator
		By totalPrice = By.xpath("//h3[@id='totalp']");
		// cart button in TopBar locator
		By placeOrderBtn = By.xpath("//button[normalize-space()='Place Order']");
		

		////////////////////////////////////////////////////////////
		
		//genral constructor
	    public cartPage(WebDriver driver) {
	        this.driver = driver;
	    }
		
							//TC_CART_001 add items and verify the total price match
		
	    public void clickCartTopBar() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement cartBtn = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(cartTopBar)));
			cartBtn.click();
		}
		
		public String getTotalPrice() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement totPrice = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(totalPrice)));
	    	return totPrice.getText();
		}
		

}
