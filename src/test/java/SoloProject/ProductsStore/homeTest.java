package SoloProject.ProductsStore;

import org.testng.Assert;
import org.testng.annotations.Test;

public class homeTest extends baseTest {
	
							//TC_UI_I001 Scroll down and verify that footer is visible	
		@Test	
		public void scrollVerifyThatFooterIsVisible	() {
			
			homePage home = new homePage(driver);
			home.scrollDown();
		    //verify that "about us" in down bar visible 
			Assert.assertEquals(home.isAboutUsParaVis(), true, " About us not visible ");
		    //verify that "about us" paragraph in down bar visible 
			Assert.assertEquals(home.isAboutUsParaVis(), true, " About us paragraph not visible ");
		    // verify that "get in touch" in down bar visible 
			Assert.assertEquals(home.isGetInTouchVis(), true, " Get in touch not visible ");
		    // verify that "product store" in down bar visible 
			Assert.assertEquals(home.isProductStoreVis(), true, " Product store not visible ");
		}
		
						//TC_UI_I001 Scroll down and switch to another page	
		@Test
		public void switchToNextPage() {
			homePage home = new homePage(driver);
			home.scrollDown();
			home.clickNextPage();
		    //verify that apple monitor visible 
			Assert.assertEquals(home.getAppleMonitor24Vis(), "Apple monitor 24", " The page didnt switch and apple monitor not visible ");
		    //verify that apple monitor price visible 
			Assert.assertEquals(home.getAppleMonitor24PriceVis(), "$400", " The page didnt switch and apple monitor price not visible ");
		}
		
	

}
