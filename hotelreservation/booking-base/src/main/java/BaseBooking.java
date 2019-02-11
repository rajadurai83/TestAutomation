import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 */

/**
 * @author Raja
 *
 */

public class BaseBooking {

	private static final int TIMEOUT = 7; // seconds
	private static final int POLLING = 100; // seconds

	protected WebDriver driver;
	private WebDriverWait wait;

	public BaseBooking(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	protected WebElement waitForElementToAppear(WebElement element) {
		return (WebElement) wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected WebElement waitForElementToBeClickable(WebElement element) {
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected List<WebElement> waitForAllElementsToAppear(WebElement element) {
		return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	protected List<WebElement> waitForAllNestedElementsToAppear(WebElement element, By childLocator) {
		return (List<WebElement>) wait
				.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, childLocator));
	}
	
	protected WebElement waitForNestedElementToAppear(WebElement element, By childLocator) {
		return (WebElement) wait
				.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, childLocator));
	}

	protected Boolean waitForTextToBePresentInElement(WebElement element, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	protected void switchTabs() {
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
	}

	public WebElement scrollToReserveSection(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		return element;
	}

}
