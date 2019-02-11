import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 */


/**
 * @author Raja
 *
 */
public class SearchResultsPage extends BaseBooking{
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public SelectedHotelPage clickOneOfTopThree(int randomIndex){
		String searchListItemCss = "div#hotellist_inner div:nth-child(" +randomIndex+ ") table tfoot tr a";
		driver.findElement(By.cssSelector(searchListItemCss)).click();
		return new SelectedHotelPage(driver);
	}
	
}
