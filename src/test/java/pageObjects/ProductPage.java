package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[contains(@class,'product-base')]")
	List<WebElement> products;

	@FindBy(xpath = "//span[contains(@class,'desktop-badge')]")
	WebElement bagBadge;

	public void clickProduct(int index) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement product = wait.until(ExpectedConditions
	            .elementToBeClickable(products.get(index)));

	    product.click();
	}
	
	public String parentWindow;
	public void switchToNewWindow() {
	    parentWindow = driver.getWindowHandle();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);


	    for (String window : driver.getWindowHandles()) {
	        if (!window.equals(parentWindow)) {
	            driver.switchTo().window(window);
	            break;
	        }
	    }
	}

	public void switchBack() {
	    driver.close(); 
	    driver.switchTo().window(parentWindow);
	}

	public int addedCount=0;
	public void clickAddToBag() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        WebElement size = wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//button[contains(@class,'size-buttons-size-button') and not(@disabled)]")));
	        size.click();

	        WebElement addBtn = wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//div[contains(text(),'ADD TO BAG')]")));
	        addBtn.click();

	        addedCount++; 

	    } catch (Exception e) {
	        System.out.println("Product skipped (size not available)");
	    }
	}

	public boolean isAdded() {
		System.out.println("Items count: "+addedCount);
		return addedCount > 0;
	}
}
