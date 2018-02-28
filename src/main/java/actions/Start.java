/**
 * 
 */
package actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import ui.HomePage;

/**
 * Created by @author faisal on 26-Feb-2018
 */
public class Start implements Task{

	private HomePage homepage;
	
	/**
	 * @return
	 */
	public static Start theApplication() {
		return Instrumented.instanceOf(Start.class).newInstance();
	}

	/* (non-Javadoc)
	 * @see net.serenitybdd.screenplay.Performable#performAs(net.serenitybdd.screenplay.Actor)
	 */
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Open.browserOn(homepage)
				);
	}

}
