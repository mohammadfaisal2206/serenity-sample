package ui;

import model.ProductCategory;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by faisal on 26-Feb-2018
 */
public class NavigationBar {

	/**
	 * @param category : ProductCategory
	 * @return Target element matching the product category
	 */
	public static Target category(ProductCategory category) {
		return Target.the(category.name())
				.locatedBy("//*[contains(@class, 'main-menu')]//*[contains(., '{0}') and contains(@class, 'glass-navigation-flyout')]")
				.of(category.getName());
	}
	
}
