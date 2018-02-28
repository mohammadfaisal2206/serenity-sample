package tasks;

import model.Country;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.Geolocation;

import static ui.Geolocation.FLAG;

/**
 * Created by faisal on 25-Feb-2018
 */
public class SelectLocation implements Task{

	private Country country;
	
	/**
	 * 
	 */
	public SelectLocation(Country country) {
		this.country = country;
	}
	/**
	 * @param string
	 * @return
	 */
	public static SelectLocation as(Country country) {
		return Instrumented.instanceOf(SelectLocation.class).withProperties(country);
	}

	/* (non-Javadoc)
	 * @see net.serenitybdd.screenplay.Performable#performAs(net.serenitybdd.screenplay.Actor)
	 */
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Click.on(FLAG.of(Country.called(country.name()))),
				WaitUntil.the(Geolocation.POPUP_WINDOW, isNotVisible()).forNoMoreThan(10).seconds()	
						);
	}

}
