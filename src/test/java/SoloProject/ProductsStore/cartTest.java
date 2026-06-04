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
		//take values from TestData to perform thier method (login)
		login.validLogin(testData.loginUsername, testData.loginPassword);
		Thread.sleep(2000);
		product.addTheItemsToCart();
		cart.clickCartTopBar();
		Assert.assertEquals(cart.getTotalPrice(), "1160", " The total price not match ");
	}
	
						//TC_CART_002 Place order and verify place order is success
		@Test	
		public void placeOrderFinal() throws InterruptedException {
			loginSignupPage login = new loginSignupPage (driver);
			cartPage cart = new cartPage(driver);
			//take values from TestData to perform thier method (login)
			login.validLogin(testData.loginUsername, testData.loginPassword);
			Thread.sleep(2000);
			cart.clickCartTopBar();
			//take values from TestData to perform thier method (payment)
			cart.finshOrder(testData.name, testData.country, testData.city, testData.creditCard, testData.month, testData.year);
			Assert.assertEquals(cart.getSuccessMessagePayment(), "Thank you for your purchase!", "Your Payment not success ");
		}

}
