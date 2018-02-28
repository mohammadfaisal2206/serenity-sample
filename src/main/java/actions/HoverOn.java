package actions;

import model.ProductCategory;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Hover;
import ui.NavigationBar;

/**
 * Created by faisal on 26-Feb-2018
 * 
 */
public class HoverOn implements Interaction{

	private final ProductCategory category;
	
	/**
	 * 
	 */
	public HoverOn(ProductCategory category) {
		this.category = category;
	}
	
	/* (non-Javadoc)
	 * @see net.serenitybdd.screenplay.Performable#performAs(net.serenitybdd.screenplay.Actor)
	 */
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
					Hover.over(NavigationBar.category(category))
				);
	}

	/**
	 * @param ProductCategory
	 * @return instance of the current class. This will invoke the constructor with ProductCategory property 
	 */
	public static HoverOn the(ProductCategory category) {
		return Instrumented.instanceOf(HoverOn.class).withProperties(category);
	}

}
