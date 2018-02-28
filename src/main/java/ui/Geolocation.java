package ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by faisal on 26-Feb-2018
 */
public class Geolocation{

	public static final Target POPUP_WINDOW = Target.the("geolocation popup window").locatedBy(".glass-modal-dialog");
	
	public static final Target FLAG = Target.the("Flag for country {0}").locatedBy("//span[contains(., 'adidas.{0}')]");
	
}
