package steps;

import static net.serenitybdd.rest.SerenityRest.expect;
import static io.restassured.specification.ProxySpecification.host;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.is;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.jayway.jsonpath.JsonPath;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import static net.serenitybdd.rest.SerenityRest.when;

public class CMSResponseSteps {

	EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	private String baseUri = variables.getProperty("api.uri");
	
	public Response response;
	
	/**
	 * If you are behind corporate proxy, configure it here
	 * */
	@Before
	public void setup() {
		RestAssured.proxy = host("proxy.hm.com").withPort(8080);
		RestAssured.useRelaxedHTTPSValidation();
	}

	@Given("^api request was successful$")
	public void api_request_was_successful() throws Exception {
		expect().
			statusCode(200).
				when().
					get(baseUri);
	}

	@Then("^the response time should be less than (\\d+) sec$")
	public void the_response_time_should_be_less_than_sec(long responseTime) throws Exception {
		expect().
			time(lessThan(responseTime), TimeUnit.SECONDS).
				when().
					get(baseUri);
	}
	
	@Then("^all the links should be accessible$")
	public void all_the_links_should_be_accessible() throws Exception {
		response = expect().
						statusCode(200).
							when().
								get(baseUri).
									then().
										extract().
											response();
		List<String> urlStrings = JsonPath.read(response.asString(), "$..url");
		urlStrings.stream().forEach(url -> expect().statusCode(200).when().get(url));
		
	}
	
	@Then("^each '(.*)' object should contain key called '(.*)'$")
	public void each_object_should_contain_key_called(String object, String key) {
		when()
			.get(baseUri)
				.then()
					.body("component_presentations."+ object +".any { it.containsKey('"+ key +"') }", is(true));
				
	}
}
