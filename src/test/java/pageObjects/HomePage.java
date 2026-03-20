package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {	
		super(driver);	
	}

	@FindBy(xpath="//a[@class='desktop-main'][normalize-space()='Men']")
	WebElement btnMenCategory;
	
	@FindBy(xpath="//a[text()='T-Shirts']")
	WebElement btnTshirts;
	
	public void moveToProductPage() {

		Actions actions = new Actions(driver);
		actions.moveToElement(btnMenCategory).perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(btnTshirts));
	    
		btnTshirts.click();
	}
}
