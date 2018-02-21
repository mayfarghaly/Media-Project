package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.SelectGamePage;

public class SelectGameTest extends TestBase {
	
	SelectGamePage SelectGamePageObj ;
	
	//check that the last game added to cart 
	@Test
	public void checkGameAddedToCart(){
		SelectGamePageObj = new SelectGamePage(driver);
		
		String clickedGameName = SelectGamePageObj.selectlastGame();
		//assertTrue(!SelectGamePageObj.cartIsEmpty(), "shopping cart is Empty");
		
		String shoppingCartItem = SelectGamePageObj.getGameFromCart();
		assertEquals(shoppingCartItem , clickedGameName);
	}
	
	//check that the game name is the same name in game details and there is 4 screenshots  
	@Test(dependsOnMethods = "checkGameAddedToCart")
	public void checkGameDetails(){
		
		String clickFirstGame = SelectGamePageObj.selectFirstGame();
		String gameTitle = SelectGamePageObj.gameDetails();
		assertTrue(clickFirstGame.equals(gameTitle));
		assertTrue(driver.getCurrentUrl().endsWith("/Call-Of-Duty/BLACKOPS2/2_63.action"));
		
		int numberOfScreenShots = SelectGamePageObj.galleryScreenShots();
		assertEquals(numberOfScreenShots , 4);
	}
	
	//Add two games from the first item
	@Test(dependsOnMethods = "checkGameDetails")
	public void addTwoGamesItems(){
	SelectGamePageObj.addTwoGames();
	}
	
	//check the total number of selected games are added to cart
	@Test(dependsOnMethods = "addTwoGamesItems")
	public void checkThreeGamesAddedToCart(){
		
		String totalGamesIncart = SelectGamePageObj.allItemsInCart();
		assertEquals(totalGamesIncart , "(3)");
	}
	
	//Pressing on Check out button 
	@Test(dependsOnMethods = "checkThreeGamesAddedToCart" , groups={"Checkout"})
	public void checkOutBtnClick()
	{
		SelectGamePageObj.checkOut();
	}
	
	
	
}
