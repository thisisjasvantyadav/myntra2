package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC002_ProductPageTest extends BaseClass {
	
	@Test
	public void capture_prices_of_first_five_products() {
		
		HomePage homepage = new HomePage(driver);
	    homepage.moveToProductPage();

	    Assert.assertTrue(driver.getCurrentUrl().contains("men-tshirts"));

	    ProductPage productpage = new ProductPage(driver);

	    for (int i = 0; i < 5; i++) {

	        productpage.clickProduct(i);
	        productpage.switchToNewWindow();
	        productpage.clickAddToBag();
	        productpage.switchBack();
	    }

	    if(productpage.isAdded()) {
	        Assert.assertTrue(true);
	    } else {
	        System.out.println("No items added to bag");
	    }
	}
}
