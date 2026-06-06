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
		//verify loged in successfully
		Assert.assertEquals(login.getUsernameWelcome(), "Welcome QualityAssurance", " You didnt login successfully. ");
		product.addTheItemsToCart(); 
		//verify that first item is Samsung galaxy s6
		Assert.assertEquals(product.getSGS6Name(), "Samsung galaxy s6", " The item is not Samsung galaxy s6 ");
		//verify that first item Samsung galaxy s6 price is 360
		Assert.assertEquals(product.getSGS6Price(), "$360", "  The item price not match to 360 ");
		//verify that first item is Samsung galaxy s7
		Assert.assertEquals(product.getSGS7Name(), "Samsung galaxy s7", " The item is not Samsung galaxy s7 ");
		//verify that first item Samsung galaxy s6 price is 800
		Assert.assertEquals(product.getSGS7Price(), "$800", " The item price not match to 800 ");
		cart.clickCartTopBar();
		//verify that total price for both items is 1160
		Assert.assertEquals(cart.getTotalPrice(), "1160", " The total price not match ");
		System.out.print("the log in success and the welcoming is : " + login.getUsernameWelcome() + " . " + "\n"
				+ " the first item is: " + product.getSGS6Name() + " and the price is: " + product.getSGS6Price() + "\n"
				+ " the second item is: " + product.getSGS7Name() + " and the price is: " + product.getSGS7Price() + "\n"
				+ " the total of ordered items is: " + cart.getTotalPrice() + " . "+ "\n");
	}
	
						//TC_CART_002 Place order and verify place order is success
		@Test	
		public void placeOrderFinal() throws InterruptedException {
			loginSignupPage login = new loginSignupPage (driver);
			cartPage cart = new cartPage(driver);
			//take values from TestData to perform thier method (login)
			login.validLogin(testData.loginUsername, testData.loginPassword);
			cart.clickCartTopBar();
			//take values from TestData to perform thier method (payment)
			cart.finshOrder(testData.name, testData.country, testData.city, testData.creditCard, testData.month, testData.year);
			Assert.assertEquals(cart.getSuccessMessagePayment(), "Thank you for your purchase!", "Your Payment not success ");
			System.out.println("thanks for the ordering from our store and " + cart.getSuccessMessagePayment() + " . " );
		}

}
