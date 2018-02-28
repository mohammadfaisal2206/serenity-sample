package steps;

/**
 * Created by @author faisal on 26-Feb-2018
 */
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/ui_features/")
public class UiTestSuite {

}
