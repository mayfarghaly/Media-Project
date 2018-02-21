package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;


public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	//move the price slider to be from 39 to 80 $
	public void slide(WebElement slider) {

		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		move.dragAndDropBy(slider, ((width) - 67), 0).build().perform();

		waitForAllElements();

		// assertTrue(driver.findElement(By.id("amount")).);
	}
	
	//wait for page load 
	 protected void waitForPageLoad() {
			(new WebDriverWait(driver, 10)).until((new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					JavascriptExecutor js = (JavascriptExecutor) d;
					return (Boolean) js.executeScript(("return document.readyState")).equals("complete");
				}
			}));
                
    }

	 //wait for all items 
	public void waitForAllElements() {
		(new WebDriverWait(driver, 10)).until((new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				JavascriptExecutor js = (JavascriptExecutor) d;
				return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
			}
		}));
	}
	
	//click on special selectors 
	public void mouseClickByLocator(String cssLocator) {
		String clickOnlocator = cssLocator;
		WebElement el = driver.findElement(By.cssSelector( clickOnlocator ));
		Actions builder = new Actions(driver);
		builder.moveToElement( el ).click( el ).perform();
	}
	
	//wait for all elements to be visible 
	protected void waitForElementVisible(final By selector, int timeout) { 
		(new WebDriverWait(driver,timeout)).until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver browser) {
                WebElement elem = browser.findElement(selector);
                if (elem != null && elem.isEnabled() && elem.isDisplayed()) { 
                    return true;
                }; 
                return false;
            }
        });
    }

	
}
