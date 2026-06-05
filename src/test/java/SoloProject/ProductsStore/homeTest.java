package SoloProject.ProductsStore;

import org.testng.Assert;
import org.testng.annotations.Test;

public class homeTest extends baseTest {
	
							//TC_UI_I001 Scroll down and verify that footer is visible	
		@Test	
		public void scrollVerifyThatFooterIsVisable	() {
			
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
	
	

}
