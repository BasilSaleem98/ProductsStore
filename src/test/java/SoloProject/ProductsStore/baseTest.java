package SoloProject.ProductsStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {
	
    public WebDriver driver;
	
	@BeforeMethod
    public void setup() {
    	driver = new EdgeDriver(); //used edge browser
    	
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
	
}
