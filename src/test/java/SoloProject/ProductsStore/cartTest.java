package SoloProject.ProductsStore;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.testData;

public class cartTest extends baseTest {
	
							//TC_CART_001 add items and verify the total price match
	@Test	
	public void addItemToCart() throws InterruptedException {
		loginSignupPage login = new loginSignupPage (driver);
		productsStorePage product = new productsStorePage(driver);
		cartPage cart = new cartPage(driver);
		
		driver.get("https://www.demoblaze.com/index.html");
		login.validLogin(testData.loginUsername, testData.loginPassword);
		Thread.sleep(2000);
		product.addTheItemsToCart();
		cart.clickCartTopBar();
		Assert.assertEquals(cart.getTotalPrice(), "1160", " The total price not match ");
	}
	
	

}
