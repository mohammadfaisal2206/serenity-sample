package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.OrderTrackerPage;

/**
 * Created by faisal on 27-Feb-2018
 */
public class Notification {

	/**
	 * @return a Question object of type String, containing the text of the element
	 */
	public static Question<String> onOrderTrackerPage() {
		return actor -> Text.of(OrderTrackerPage.NOTIFICATION).viewedBy(actor).asString();
	}

	/**
	 * @return a Question object of type String, containing the text of the element
	 */
	public static Question<String> underOrderField() {
		return actor -> Text.of(OrderTrackerPage.NOTIFICATION_ERROR_INVALID_ORDER).viewedBy(actor).asString();
	}

	/**
	 * @return a Question object of type String, containing the text of the element
	 */
	public static Question<String> underEmailField() {
		return actor -> Text.of(OrderTrackerPage.NOTIFICATION_ERROR_INVALID_EMAIL).viewedBy(actor).asString();
	}


}
