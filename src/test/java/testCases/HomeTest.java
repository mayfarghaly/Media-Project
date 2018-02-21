package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.HomePage;

public class HomeTest extends TestBase {
	
	@Test
	public void goToGames() {

		HomePage homePageObject = new HomePage(driver);
		homePageObject.goToGames();
		
		assertTrue(driver.getCurrentUrl().endsWith("/1_2_-1_-1.action"));
	}	

}
