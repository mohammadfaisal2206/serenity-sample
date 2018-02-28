/**
 * 
 */
package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.ProductCategory;
import static model.ProductCategory.called;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import questions.ContentAsset;
import questions.TheListDisplayedUnder;
import tasks.SelectLocation;
import ui.Geolocation;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import java.util.List;

import actions.HoverOn;
import actions.Start;
import static model.Country.FI;
/**
 * Created by @author faisal on 26-Feb-2018
 */
public class NavigatingCategories {
	
	private String category;
	
	/**
	 * Set the stage before calling the actor
	 * */
	@Before
	public void setTheStageForMike() {
		OnStage.
			setTheStage(new OnlineCast());
	}
	
	@Given("^(.*) is on the homepage$")
	public void actor_is_on_the_homepage(String actor) throws Exception {
		theActorCalled(actor).
			attemptsTo(
					Start.theApplication(),
					Check.whether(the(Geolocation.POPUP_WINDOW), isCurrentlyVisible()).andIfSo(SelectLocation.as(FI))
					);
	}

	@When("^he hovers on to the '(.*)' category$")
	public void he_hovers_on_to_the_x_category(String category) throws Exception {
		this.category = category;
		theActorInTheSpotlight().
						attemptsTo(
								HoverOn.the(ProductCategory.called(category))
				);
	}

	@Then("^he should see links '(.*)' under column '(.*)'$")
	public void he_should_see_links_x_under_column_y(List<String> categoryLinks, String column) throws Exception {
		theActorInTheSpotlight().should(
				seeThat(ContentAsset.forCategory(called(category)).isVisible()),
				seeThat(TheListDisplayedUnder.theCategory(called(category)).andColumn(column), equalTo(categoryLinks))
						);
	}

}
