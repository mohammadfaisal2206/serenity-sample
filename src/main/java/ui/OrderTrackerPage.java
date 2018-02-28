package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by faisal on 27-Feb-2018
 */
public class OrderTrackerPage {
	
	public static final Target ORDER_NUMBER_FIELD = Target.the("order number field").locatedBy("#dwfrm_ordersignup_orderNo");
	
	public static final Target EMAIL_FIELD = Target.the("email field").locatedBy("#dwfrm_ordersignup_email");
	
	public static final Target VIEW_ORDER_BUTTON = Target.the("view order button").located(By.name("dwfrm_ordersignup_signup"));
	
	public static final Target NOTIFICATION = Target.the("error notification").locatedBy(".notification-block.error-notification");
	
	public static final Target NOTIFICATION_ERROR_INVALID_ORDER = Target.the("error notification about invalid order number").locatedBy("//*[@id='dwfrm_ordersignup_orderNo']/parent::div/following-sibling::span");
	
	public static final Target NOTIFICATION_ERROR_INVALID_EMAIL = Target.the("error notification about invalid email").locatedBy("//*[@id='dwfrm_ordersignup_email']/parent::div/following-sibling::span");

}
