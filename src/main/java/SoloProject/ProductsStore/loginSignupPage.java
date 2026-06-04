package SoloProject.ProductsStore;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginSignupPage {
	
	WebDriver driver;						
	
											//locators for login TCs
	// login button in TopBar locator
    By loginTopBar = By.xpath("//a[@id='login2']");
    
    // login username field locator
    By usernameLogin = By.xpath("//input[@id='loginusername']");
    // login password field locator
    By passwordLogin = By.xpath("//input[@id='loginpassword']");
    
 // login button in login form locator 
    By loginButton = By.xpath("//button[normalize-space()='Log in']");
	
    // to verify login is sucsses
    By usernameWelcome = By.xpath("//a[@id='nameofuser']");
    
    //////////////////////////////////////////////////////////////////////
    												//locators for singup TC
  	// signup button in TopBar locator
      By signupTopBar = By.xpath("//a[@id='signin2']");
      
      // signup username field locator
      By usernameSignup = By.xpath("//input[@id='sign-username']");
      // signup password field locator
      By passwordSignup = By.xpath("//input[@id='sign-password']");
      
   // signup button in login form locator 
      By SignupButton = By.xpath("//button[normalize-space()='Sign up']");

    //************************************
    
    //genral constructor
    public loginSignupPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
  //***********************************************TC_Login_001 Login with valid username and password
    //click on login on top bar
    public void clickLoginTopBar() {
    	driver.findElement(loginTopBar).click();
	}
    //enter username
    public void enterUsernameLogin(String username) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement usernameLoginField = wait.until(ExpectedConditions.elementToBeClickable(usernameLogin));
    	usernameLoginField.clear();
    	usernameLoginField.sendKeys(username);
	}
    //eneter passewrd
    public void enterPasswordLogin(String password) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement passwordLoginField = wait.until(ExpectedConditions.elementToBeClickable(passwordLogin));
    	passwordLoginField.clear();
    	passwordLoginField.sendKeys(password);
	}
    
  //click on login on login form
    public void clickLoginBtn() {
    	driver.findElement(loginButton).click();
	}
    
    // to verify login is sucsses
	public String getUsernameWelcome() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement usernameWelcomeLogin = wait.until(ExpectedConditions.elementToBeClickable(usernameWelcome));
		return usernameWelcomeLogin.getText();
	}
	
	
	public void validLogin(String username, String password) {
		clickLoginTopBar();
		enterUsernameLogin(username);
		enterPasswordLogin(password);
		clickLoginBtn();
	}
	/////////////////////////////////////////TC_Login_002 Login with incorrect username
	
	public void invalidLogin(String username, String password) {
		clickLoginTopBar();
		enterUsernameLogin(username);
		enterPasswordLogin(password);
		clickLoginBtn();
	}
	
	// to verify login not sucsses incorect username
		public String getAlertLoginIssue() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Alert alertIncorrectLogin = wait.until(ExpectedConditions.alertIsPresent());
			return alertIncorrectLogin.getText();
		}
		
		////////////////////////////////////////TC_Signup_001 Signup with used username 
		
		 //click on login on top bar
	    public void clickSignupTopBar() {
	    	driver.findElement(signupTopBar).click();
		}
	    //enter username
	    public void enterUsernameSignup(String username) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement usernameLoginField = wait.until(ExpectedConditions.elementToBeClickable(usernameSignup));
	    	usernameLoginField.clear();
	    	usernameLoginField.sendKeys(username);
		}
	    //eneter passewrd
	    public void enterPasswordSignup(String password) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement passwordLoginField = wait.until(ExpectedConditions.elementToBeClickable(passwordSignup));
	    	passwordLoginField.clear();
	    	passwordLoginField.sendKeys(password);
		}
	    
	  //click on login on login form
	    public void clickSignupBtn() {
	    	driver.findElement(SignupButton).click();
		}
		//all action to signup
	    public void invalidSignup(String username, String password) {
			clickSignupTopBar();
			enterUsernameSignup(username);
			enterPasswordSignup(password);
			clickSignupBtn();
		}
	 // to verify signup not sucsses cuz enter used username
	 		public String getAlertSignupIssue() {
	 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 			Alert alertIncorrectSignup = wait.until(ExpectedConditions.alertIsPresent());
	 			return alertIncorrectSignup.getText();
	 		}
}
