package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.GamesPage;

public class GamesTest extends TestBase {
	
	@Test
	public void pricesFilteredBySlider() {

		GamesPage gamesPageObject = new GamesPage(driver);
		gamesPageObject.setPrice();
		
		for (double price: gamesPageObject.getPrices())
		{
			assertTrue(price < 80);
		}
	
	}	 
}
