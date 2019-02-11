import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 */

/**
 * @author Raja
 *
 */
public class SelectedHotelPage extends BaseBooking{
	
	@FindBy(xpath = 
			"//*[@id='hprt-form']/table[contains(@class,'hprt-table')]")
	private WebElement scrollToAvailability;
	
	@FindBy(xpath = 
				"//*[@id='hprt-form']/table[contains(@class,'hprt-table')]/tbody/tr[contains(@class,'hprt-table-cheapest-block')][//td[contains(@class,'hprt-table-cell-price')]]")
	private WebElement cheapestPricedEntry;
	
	@FindBy(className = "hprt-nos-select")
	private WebElement numberOfRooms;
	
	private String finalReserveButton = "button";

	public SelectedHotelPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void switchTabs() {
		super.switchTabs();
	}
	
	SelectedHotelPage scrollToReserve(){
		scrollToReserveSection(scrollToAvailability);
		return this;
	}
	
	SelectedHotelPage findCheapestPricedOption(){
		cheapestPricedEntry = waitForElementToAppear(cheapestPricedEntry);
		return this;
	}
	
	SelectedHotelPage selectNumberOfRooms(String roomCount){
		WebElement selectElement = waitForElementToAppear(numberOfRooms);
		if(selectElement.isDisplayed()){
			Select roomSelectionElement = new Select(waitForElementToAppear(numberOfRooms));
			roomSelectionElement.selectByValue(roomCount);
		}else{
			
		}
		return this;
	}
	
	SelectedHotelPage SubmitSelectionToReserve(){
		waitForNestedElementToAppear(cheapestPricedEntry, By.tagName(finalReserveButton)).click();
		return this;
	}
	
}
