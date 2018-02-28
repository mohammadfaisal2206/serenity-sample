package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import questions.Notification;
import tasks.NavigateTo;
import tasks.SelectLocation;
import ui.Geolocation;
import ui.OrderTrackerPage;
import ui.SelfServiceItem;

import static model.Country.FI;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import actions.Start;

/**
 * Created by faisal on 27-Feb-2018
 */
public class OrderTracker {
	
	@Before
	public void setTheStageForMike() {
		OnStage.
			setTheStage(new OnlineCast());
	}
	
	@Given("^(.*) is on Order Tracker page$")
	public void mike_is_on_Order_Tracker_page(String actor) throws Exception {
		theActorCalled(actor)
			.attemptsTo(
					Start.theApplication(),
					Check.whether(the(Geolocation.POPUP_WINDOW), isCurrentlyVisible()).andIfSo(SelectLocation.as(FI))
					);
		theActorInTheSpotlight().should(
				seeThat(
						the(SelfServiceItem.ORDER_TRACKER), isCurrentlyVisible()
						));
		theActorInTheSpotlight()
			.attemptsTo(
					NavigateTo.theOrderTrackerPage()
					);
	}

	@When("^he enters an (.*)$")
	public void he_enters_an_invalid_order_number(String orderNumber) throws Exception {
		theActorInTheSpotlight()
			.attemptsTo(
					Enter
						.theValue(orderNumber)
							.into(OrderTrackerPage.ORDER_NUMBER_FIELD)
					);
	}
	
	@When("^he enters invalid email address '(.*)'$")
	public void he_enters_invalid_email_address(String invalidEmail) throws Exception {
		theActorInTheSpotlight()
			.attemptsTo(
					Enter
						.theValue(invalidEmail)
							.into(OrderTrackerPage.EMAIL_FIELD)
								.thenHit(Keys.TAB)
					);
	}

	@When("^he enters his (.*)$")
	public void he_enters_his_valid_email_address(String email) throws Exception {
		theActorInTheSpotlight()
		.attemptsTo(
				Enter
					.theValue(email)
						.into(OrderTrackerPage.EMAIL_FIELD)
				);
	}

	@When("^he clicks view order button$")
	public void he_clicks_view_order_button() throws Exception {
		theActorInTheSpotlight()
		.attemptsTo(
				Click.on(OrderTrackerPage.VIEW_ORDER_BUTTON)
				);
	}

	@Then("^he should see error message about invalid combination of order number and email address$")
	public void he_should_see_error_message_about_invalid_combination_of_order_number_and_email_address() throws Exception {
		theActorInTheSpotlight()
			.should(
				seeThat(
						Notification.onOrderTrackerPage(), containsString("Incorrect e-mail address or order number.")));
	}
	

	@When("^he enters blank in order field$")
	public void he_enters_blank_in_order_field() throws Exception {
	    theActorInTheSpotlight()
	    	.attemptsTo(
	    			Enter
	    				.theValue(" ")
	    					.into(OrderTrackerPage.ORDER_NUMBER_FIELD)
	    					.thenHit(Keys.TAB)
	    			);
	}

	@Then("^he should see error message '(.*)' under order field$")
	public void he_should_see_error_message_about_invalid_order_number(String invalidOrderNumberError) throws Exception {
	    theActorInTheSpotlight()
	    	.should(
    			seeThat(
					Notification.underOrderField(), containsString(invalidOrderNumberError)));
	}

	@Then("^he should see error message '(.*)' under email field$")
	public void he_should_see_error_message_about_invalid_email(String invalidEmailError) throws Exception {
		theActorInTheSpotlight()
			.should(
				seeThat(
					Notification.underEmailField(), containsString(invalidEmailError)));
	}

}
