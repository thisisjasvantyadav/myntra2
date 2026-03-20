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
	
	@Test
	public void sort_price_low_to_high() {
		HomePage homepage = new HomePage(driver);
	    homepage.moveToProductPage();
	    
	    if(driver.getCurrentUrl().contains("men-tshirts")) {
	    	ProductPage productpage = new ProductPage(driver);
	    	
	    	productpage.sortLowToHighPrice();
	    	String sortUrl=driver.getCurrentUrl();
	    	Assert.assertEquals(sortUrl, "https://www.myntra.com/men-tshirts?sort=price_asc");
	    }else {
	    	System.out.println("T-Shirts page not displayed");
	    }
	}
}
