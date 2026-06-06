package SoloProject.ProductsStore;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
	WebDriver driver;						
	
											//locators for UI TCs
	// "about us" locator in downbar 
    By aboutUsDownBar = By.xpath("//b[normalize-space()='About Us']");
    // "about us" paragraph locator in downbar 
    By aboutUsDownBarPara = By.xpath("//p[contains(text(),'We believe performance needs')]");
    // "get in touch" locator
    By getInTouch = By.xpath("//b[normalize-space()='Get in Touch']");    //verify that all of the are visible
    // "product store" locator in downbar 
    By productStoreDownBar = By.xpath("//h4[normalize-space()='PRODUCT STORE']");
    By sonyVaioI5Vis = By.xpath("//a[normalize-space()='Sony vaio i5']");
  ///*****************************************
    //locator for next page button
    By nextPageBtn = By.xpath("//button[@id='next2']");
    //locator for apple monitor product
    By appleMonitor24 = By.xpath("//a[normalize-space()='Apple monitor 24']");
    //locator for apple monitor price
    By appleMonitor24Price = By.xpath("//h5[normalize-space()='$400']");
    //*****************************************************************************
    												//locators for contact us TC
    //locator for contact button in topbar
    By contactBtn = By.xpath("//a[normalize-space()='Contact']");
    //locator for verify that "New meesage" opend
    By contactFrameMess = By.xpath("//h5[@id='exampleModalLabel']");
    //locator for contact email
    By contactEmail = By.xpath("//input[@id='recipient-email']");
    //locator for contact name
    By contactName = By.xpath("//input[@id='recipient-name']");
    //locator for contact message
    By contactMessage = By.xpath("//textarea[@id='message-text']");
    //locator for send message button
    By sendMessageBtn = By.xpath("//button[normalize-space()='Send message']");
    //variables
    String getMessageIsSend;
//*********************************************************************
    
  //genral constructor
    public homePage(WebDriver driver) {
        this.driver = driver;
    }
    				//////////////////////////////////////////////////TC_UI_I001
    public void scrollDown()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till sony i5 is visible 
		WebElement sony = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(sonyVaioI5Vis)));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
    //verify that "about us" in down bar visible 
    public boolean isAboutUsVis() {
		return driver.findElement(aboutUsDownBar).isDisplayed();
	}
    //verify that "about us" paragraph in down bar visible 
    public boolean isAboutUsParaVis() {
		return driver.findElement(aboutUsDownBarPara).isDisplayed();
	}
    // verify that "get in touch" in down bar visible 
    public boolean isGetInTouchVis() {
		return driver.findElement(getInTouch).isDisplayed();
	}
    // verify that "product store" in down bar visible 
    public boolean isProductStoreVis() {
		return driver.findElement(productStoreDownBar).isDisplayed();
	}
	//////////////////////////////////////////////////TC_UI_I002
    //click on next page button
    public void clickNextPage() {
		driver.findElement(nextPageBtn).click();
	}
    //vrify that apple monitor is visible 
    public String getAppleMonitor24Vis() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till apple monitor is visible 
		WebElement apple = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(appleMonitor24)));
		return apple.getText();
		
	}
  //vrify that apple monitor price is visible 
    public String getAppleMonitor24PriceVis() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till apple monitor price is visible 
		WebElement apple = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(appleMonitor24Price)));
		return apple.getText();
	}
	//////////////////////////////////////////////////TC_Contact_Us
    //click on contact button
    public void clickOnContactTopBar() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till contact is visible 
		WebElement contBtn = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(contactBtn)));
		contBtn.click();
	}
    //verify that contact frame message is visible
    public boolean isNewMessageFrameVis() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till conatact frame is visible 
		WebElement newMessFrame = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(contactFrameMess)));
		return newMessFrame.isDisplayed();		
	}
    //enter contact email
    public void enterContactEmail(String email) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till email field is visible 
		WebElement enterContactEmail = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(contactEmail)));
		enterContactEmail.sendKeys(email);
	}
    //enter contact name
    public void enterContactName(String name) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till name field visible 
		WebElement enterContactName = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(contactName)));
		enterContactName.sendKeys(name);
	}
    //enter ur message
    public void enterContactMess(String message) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till message field is visible 
		WebElement enterContactMess = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(contactMessage)));
		enterContactMess.sendKeys(message);
	}
    //send contact message (click on send message buttton)
    public void clickSendMessage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait till send message button is visible 
		WebElement sendMessage = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(sendMessageBtn)));
		sendMessage.click();
    }
    
	// to verify that message is sent
	public String getAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	Alert alertMessSend = wait.until(ExpectedConditions.alertIsPresent());
    	getMessageIsSend= alertMessSend.getText();
    	alertMessSend.accept();
    	return getMessageIsSend;
	}
    
	public void contactForm(String email, String name, String message) {
		enterContactEmail(email);
		enterContactName(name);
		enterContactMess(message);
		clickSendMessage();
	}
    
}
