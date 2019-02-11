import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */

/**
 * @author Raja
 *
 */
public class HomePage extends BaseBooking {

	@FindBy(id = "ss")
	private WebElement searchInput;

	@FindBy(className = "xp__dates-inner")
	private WebElement datepickerElement;

	@FindBy(css = "div.bui-calendar__content table.bui-calendar__dates tbody")
	private WebElement dateWidget;

	private String dateTD = "td";

	@FindBy(css = ".sb-searchbox-submit-col.-submit-button")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	HomePage enterSearchText(String searchText) {
		waitForElementToAppear(searchInput).sendKeys(searchText);
		return this;
	}

	HomePage clickCalendar() {
		waitForElementToAppear(datepickerElement).click();
		return this;
	}

	HomePage selectPreferredDates(String preferredDate) {
		WebElement fromToDate = waitForElementToBeClickable(dateWidget);
		List<WebElement> columns = waitForAllNestedElementsToAppear(fromToDate, By.tagName(dateTD));
		for (WebElement cell : columns) {
			if (cell.getText().equals(preferredDate)) {
				cell.click();
				break;
			}
		}
		return this;
	}
	
	SearchResultsPage submitSearch(){
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		waitForElementToBeClickable(searchButton).click();
		return searchResultsPage;
	}

}
