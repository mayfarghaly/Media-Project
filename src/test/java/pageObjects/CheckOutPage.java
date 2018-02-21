package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{
	
	@FindBy(id= "shopping-cart-checkout-button")
	private WebElement ShoppingCartCheckoutButton;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	//Pressing on Checkout as guest button
	public void checkOutAsGuest() 
	{
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement guestBtn = driver.findElement(By.cssSelector("div[class='sign-in-column-right centered']"))
				.findElement(By.cssSelector("span"));
		guestBtn.click();
	}

}
