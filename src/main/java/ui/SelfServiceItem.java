package ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by faisal on 27-Feb-2018
 */
public class SelfServiceItem {
	
	public static final Target ORDER_TRACKER = Target.the("Order Tracker link").locatedBy("//a[contains(@manual_cm_sp, 'customer_info-_-order tracker')]");

}
