package SoloProject.ProductsStore;

import org.testng.Assert;
import org.testng.annotations.Test;


public class loginSignupTest extends baseTest {

	@Test								//TC_Login_001 Login with valid username and password
	public void vaildLogin() {
		
		loginSignupPage login = new loginSignupPage (driver);
		login.validLogin("QualityAssurance", "QualityAssurance");
		//to verify login is sucsses
		Assert.assertEquals(login.getUsernameWelcome(), "Welcome QualityAssurance", " You didnt login successfully. ");
	}
	
	@Test								//TC_Login_002 Login with incorrect username
	public void invaildLogin() {
		
		loginSignupPage login = new loginSignupPage (driver);
		login.validLogin("QualityAssurance_988998", "QualityAssurance");
		//to verify login is not sucsses
		Assert.assertEquals(login.getAlertLoginIssue(), "User does not exist.", " Your login must not success. ");
	}
	
										//TC_Signup_001 Signup with used username 
		@Test	
		public void invaildSingup() {
			
			loginSignupPage singup = new loginSignupPage (driver);
			singup.invalidSignup("QualityAssurance", "QualityAssurance");
			//to verify signup is not sucsses
			Assert.assertEquals(singup.getAlertSignupIssue(), "This user already exist.", " Your signup must not success. ");
		}
	
										//TC_CART_001 Delete Item in cart page
		@Test	
		public void removeItemFromCart() {
		
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
}
