package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
public static WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void setUP()
	{
		driver.get("http://www.konakart.com/konakart/Welcome.action");
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}

}
