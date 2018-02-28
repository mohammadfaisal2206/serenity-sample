package model;

/**
 * Created by faisal on 26-Feb-2018
 */
public enum ProductCategory {
	MEN("Men"),
	WOMEN("Women"),
	KIDS("Kids"),
	SPORTS("Sports"),
	BRANDS("Brands"),
	CUSTOMISE("Customise");
	
	private String name;
	
	/**
	 * 
	 */
	private ProductCategory(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	/**
	 * @param category : string
	 * @return enum : ProductCategory
	 */
	public static ProductCategory called(String category) {
		
		for(ProductCategory productCategory : values()) {
			if(category.equals(productCategory.getName()))
				return productCategory;
		}
		throw new IllegalStateException("Illegal product category value::"+category);
	}
}
