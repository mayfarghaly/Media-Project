package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamesPage extends BasePage {

	@FindBy(css = "#price-range-slider > span:nth-child(3)")
	private WebElement slider;
	
	@FindBy(className = "price")
	public List <WebElement> prices;
	
	public GamesPage(WebDriver driver) {
		super(driver);
	}
	
	public void setPrice()
	{
		slide(slider);
	}
	
	public List<Double> getPrices ()
	{
		ArrayList<Double> li = new ArrayList<Double>();
		for (WebElement price : prices)	
		{
			String pricetext = price.getText() ;
			li.add(Double.parseDouble(pricetext.substring(1, pricetext.length())));
		}
		return li;
	}

}
