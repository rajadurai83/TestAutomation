import java.util.Calendar;
import java.util.TimeZone;

/**
 * 
 */

/**
 * @author Raja
 *
 */
public class CommonComponents {

    public static int randomIndex = (int) (Math.random() * 3 + 1);

	public static String getCurrentDay() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);

		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);

		return todayStr;
	}

}
