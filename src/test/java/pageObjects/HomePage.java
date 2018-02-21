package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	@FindBy(linkText="Games")
	private WebElement gamesLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void goToGames(){
		gamesLink.click();
	}	
}
