package tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.OrderTrackerPage;
import ui.SelfServiceItem;

/**
 * Created by faisal on 27-Feb-2018
 */
public class NavigateTo implements Task{

	/**
	 * @return
	 */
	public static NavigateTo theOrderTrackerPage() {
		return Instrumented.instanceOf(NavigateTo.class).newInstance();
	}

	/* (non-Javadoc)
	 * @see net.serenitybdd.screenplay.Performable#performAs(net.serenitybdd.screenplay.Actor)
	 */
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Click.on(SelfServiceItem.ORDER_TRACKER),
				WaitUntil.the(OrderTrackerPage.ORDER_NUMBER_FIELD, isVisible())
				);
	}

}
