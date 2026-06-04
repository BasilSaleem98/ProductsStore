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
		
		// locators for payment fields
		By name = By.xpath("//input[@id='name']");
		By country = By.xpath("//input[@id='country']");
		By city = By.xpath("//input[@id='city']");
		By credit = By.xpath("//input[@id='card']");
		By month = By.xpath("//input[@id='month']");
		By year = By.xpath("//input[@id='year']");
		By purchase = By.xpath("//button[normalize-space()='Purchase']");
		
		// locator for payment success
		By successMessage = By.xpath("//h2[normalize-space()='Thank you for your purchase!']");

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
		
							//TC_CART_002 Place order and verify place order is success
		//click on place order
		public void clickPlaceOrder() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement pOrderBtn = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(placeOrderBtn)));
			pOrderBtn.click();
		}
		
		//enter name
	    public void enterName(String nameCustomer) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement customerName = wait.until(ExpectedConditions.elementToBeClickable(name));
	    	customerName.clear();
	    	customerName.sendKeys(nameCustomer);
		}
	    //enter country
	    public void enterCountry(String countryCustomer) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement userCountry = wait.until(ExpectedConditions.elementToBeClickable(country));
	    	userCountry.clear();
	    	userCountry.sendKeys(countryCustomer);
		}
	    
	  //enter city
	    public void enterCity(String CityCustomer) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement userCity = wait.until(ExpectedConditions.elementToBeClickable(city));
	    	userCity.clear();
	    	userCity.sendKeys(CityCustomer);
		}
	    
	  //enter card
	    public void enterCreditCard(String creditCard) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement userCard = wait.until(ExpectedConditions.elementToBeClickable(credit));
	    	userCard.clear();
	    	userCard.sendKeys(creditCard);
		}
	    
	  //enter month
	    public void enterMonth(String cardMonth) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement cMonth = wait.until(ExpectedConditions.elementToBeClickable(month));
	    	cMonth.clear();
	    	cMonth.sendKeys(cardMonth);
		}
	    
	  //enter year
	    public void enterYear(String cardYear) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement cYear = wait.until(ExpectedConditions.elementToBeClickable(year));
	    	cYear.clear();
	    	cYear.sendKeys(cardYear);
		}
	    
		//click on purchase
		public void clickpurchase() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement purchaseBtn = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(purchase)));
			purchaseBtn.click();
		}
	    
	  //to verify that payment success
	    public String getSuccessMessagePayment() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement paySuccess = wait.until(ExpectedConditions.elementToBeClickable(successMessage));
	    	return paySuccess.getText();
		}
		
		//all action to place order
	    public void finshOrder(String customerName, String customerCountry, String customerCity, String cridit, String criditMonth,String criditYear ) {
	    	clickPlaceOrder();
	    	enterName(customerName);
	    	enterCountry(customerCountry);
	    	enterCity(customerCity);
	    	enterCreditCard(cridit);
	    	enterMonth(criditMonth);
	    	enterYear(criditYear);
	    	clickpurchase();
		}
	    
		
}
