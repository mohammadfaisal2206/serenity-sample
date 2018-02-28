package questions;

import model.ProductCategory;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import ui.NavigationBar;

/**
 * Created by faisal on 26-Feb-2018
 */
public class ContentAsset {

	public static ContentAssetBuilder forCategory(ProductCategory category) {
		return new ContentAssetBuilder(category);
	}
	
		public static class ContentAssetBuilder implements Question<Boolean>{
			private final ProductCategory category;
			
			ContentAssetBuilder(ProductCategory category){
				this.category = category;
			}
			
			public ContentAssetBuilder isVisible(){
				return Instrumented.instanceOf(ContentAssetBuilder.class).withProperties(category);
			}
			
			/* (non-Javadoc)
			 * @see net.serenitybdd.screenplay.Question#answeredBy(net.serenitybdd.screenplay.Actor)
			 */
			@Override
			public Boolean answeredBy(Actor actor) {
				return Visibility.of(NavigationBar.category(category)).viewedBy(actor).asBoolean();
			}
			
		}

}
