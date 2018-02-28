package questions;

import java.util.List;

import model.ProductCategory;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.DataContentAsset;

/**
 * Created by faisal on 26-Feb-2018
 */
public class TheListDisplayedUnder {

	public static TheListDisplayedUnderBuilder theCategory(ProductCategory category) {
		return new TheListDisplayedUnderBuilder(category);
	}
	
	public static class TheListDisplayedUnderBuilder implements Question<List<String>>{
		
		private ProductCategory category;
		private String column;
		
		TheListDisplayedUnderBuilder(ProductCategory category) {
			this.category = category;
		}

		/* (non-Javadoc)
		 * @see net.serenitybdd.screenplay.Question#answeredBy(net.serenitybdd.screenplay.Actor)
		 */
		@Override
		public List<String> answeredBy(Actor actor) {
			return Text.of(DataContentAsset.forCategory().of(category.getName().toLowerCase(), column)).viewedBy(actor).asList();
		}

		/**
		 * @param column
		 * @return TheListDisplayedUnderBuilder object
		 */
		public TheListDisplayedUnderBuilder andColumn(String column) {
			this.column = column;
			return this;
		}
		
	}
	


}
