package ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by faisal on 26-Feb-2018
 */
public class DataContentAsset {
	
	public static final Target forCategory() {
		return Target.the("Content holder for {0}").locatedBy("//*[@class='contentasset' and @data-contentasset='navigation-gender-{0}']//*[contains(.,'{1}')]/ul/li/a");
	}

}
