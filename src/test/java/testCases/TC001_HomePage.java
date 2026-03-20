package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_HomePage extends BaseClass {
	
	@Test
	public void navigate_to_product() {
		
		logger.info("***************** TC001_HomePage started *********************");
		
		HomePage homepage = new HomePage(driver);
		homepage.moveToProductPage();
		
		String currUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(currUrl, "https://www.myntra.com/men-tshirts");
		
		logger.info("***************** TC001_HomePage finished *********************");
	}
}
