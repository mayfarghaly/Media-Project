package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectGamePage extends BasePage{

	@FindBy(css ="a[class='item-title']")
	private List <WebElement> GameNames ;
	
	@FindBy(id ="shopping-cart")
	private WebElement shoppingCart;
	
	@FindBy (css="span[id='basket-items']")
	private WebElement ItemsNumber;
	
	@FindBy(css ="img[class='item-img']")
	private List <WebElement> GameItems;
	
	@FindBy(css ="div[class='gallery_nav']")
	private WebElement GalleryScreensShots;
	
	@FindBy(id = "page-title")
	private WebElement PageTitle;
	
	@FindBy(css = "a[class ='add-to-cart-button-big button small-rounded-corners']")
	private WebElement AddToCartButton;
	
	
	public SelectGamePage(WebDriver driver) {
		super(driver);
	}

	//Select last game
	public String selectlastGame(){
		waitForAllElements();
		Actions addToCart = new Actions(driver);
		WebElement gameItem = GameItems.get(GameItems.size()-1);
		addToCart.moveToElement(gameItem).click(gameItem).build().perform();
		return GameNames.get(GameNames.size()-2).getText();
	}
	
	//Check that that shopping cart is empty before adding a game 
	public boolean cartIsEmpty()
	{
		Actions hoverOnShoppingCart = new Actions(driver);
		hoverOnShoppingCart.moveToElement(shoppingCart).build().perform();
		WebElement shoppingCartContent = driver.findElement(By.id("shopping-cart-contents"));
		if (shoppingCartContent.getText().trim().equals("Your Shopping Cart is empty"))
		{
			return true;
		}
		return false;
	}
	
	//check that the selected last game name is added to cart 
	public String getGameFromCart()
	{
		Actions hoverOn = new Actions(driver);
		hoverOn.moveToElement(shoppingCart).build().perform();
		waitForAllElements();
		WebElement itemInShoppingCart = driver.findElement(By.cssSelector("a[class='shopping-cart-item-title']"));
		return itemInShoppingCart.getText();
	}
	
	//clicking on the first game to go to the game details page
	public String selectFirstGame(){
		waitForAllElements();
		String gameName = GameNames.get(0).getText();
		Actions clickOnFirstGame = new Actions(driver);
		WebElement firstgame = GameNames.get(0);
		clickOnFirstGame.click(firstgame).build().perform();
		return gameName;
	}
	
	//check that the Game name in details page is the same name of the clicked item  
	public String gameDetails()
	{
		waitForAllElements();
		WebElement gameTitle = PageTitle;
		return gameTitle.getText();
	}
	
	//check the number of screen shots 
	public int galleryScreenShots()
	{
		waitForAllElements();
		List <WebElement> galleryScreens = GalleryScreensShots.findElements(By.tagName("a"));
		return galleryScreens.size();
	}
	
	//Add two game to the cart
	public void addTwoGames()
	{		
		Select qntyDDL = new Select (driver.findElement(By.id("product-column-right")).findElement(By.id("prodQuantityId")));
		qntyDDL.selectByValue("2");
		WebElement addToCartbtn = driver.findElement(By.id("product-column-right"))
				.findElement(By.cssSelector("a[class='add-to-cart-button-big button small-rounded-corners']"));
		addToCartbtn.click();
	}
	
	//check all the added Items on the Cart
	public String allItemsInCart()
	{
		waitForAllElements();
		WebElement totalGames = driver.findElement(By.id("shopping-cart"))
				.findElement(By.cssSelector("span[class='shopping-cart-title top-bar-menu-title']"))
				.findElement(By.cssSelector("span[id='basket-items']"));
		return totalGames.getText();
	}
	
	//Pressing on Checkout button
	public void checkOut()
	{
		waitForAllElements();
		Actions hoverOnCheckOutBtn = new Actions(driver);
		hoverOnCheckOutBtn.moveToElement(shoppingCart).build().perform();
		WebElement checkOutBtn = shoppingCart.findElement(By.id("shopping-cart-checkout-button"));
		checkOutBtn.click();
	}
}
