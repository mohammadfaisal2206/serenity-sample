package model;

/**
 * Created by faisal on 26-Feb-2018
 */
public enum Country {
	SE,
	FI;

	/**
	 * @param countryCode : String
	 * @return enumName : String
	 */
	public static String called(String countryCode) {
		for(Country country : values()) {
			if(country.name().equals(countryCode))
				return country.name().toLowerCase();
		}
		throw new IllegalStateException("Invalid Country code::"+countryCode);
	}
}
