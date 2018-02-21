package testCases;

import org.testng.annotations.Test;

import pageObjects.CheckOutPage;

public class CheckOutTest extends TestBase{
	
	CheckOutPage checkOutPageobj;
	
	//Checkout as guest test
	@Test(dependsOnGroups = "Checkout")
	public void checkOutAsGuestClick()
	{
		checkOutPageobj = new CheckOutPage(driver);
		checkOutPageobj.checkOutAsGuest();
	}

}
