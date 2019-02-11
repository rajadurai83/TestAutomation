import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Raja
 *
 */
public class ReserveBookingTest extends BaseTest {

	@Test(priority = 1)
	@Parameters({ "search_cityName","room_count"})
	public void bookReservation(String search_cityName, String room_count) {
		//String room_count = "1";
		String preferredSearchDates = CommonComponents.getCurrentDay();
		int randomIndex = CommonComponents.randomIndex;

		HomePage bookingHome = new HomePage(driver);
		SelectedHotelPage selectedHotelPage = bookingHome.enterSearchText(search_cityName).clickCalendar()
				.selectPreferredDates(preferredSearchDates).submitSearch().clickOneOfTopThree(randomIndex);

		selectedHotelPage.switchTabs();

		selectedHotelPage.scrollToReserve().findCheapestPricedOption().selectNumberOfRooms(room_count)
				.SubmitSelectionToReserve();

	}
}
