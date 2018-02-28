package model;

/**
 * Created by faisal on 26-Feb-2018
 */
public enum Column {
	Featured,
	Shoes,
	Clothing,
	Accessories,
	Sports;
	
	/**
	 * @param columnName : String
	 * @return enum : Column
	 */
	public static Column called(String column) {
		
		for(Column columnName : values()) {
			if(column.equals(columnName.name()))
				return columnName;
		}
		throw new IllegalStateException("Illegal column name::"+column);
	}

}
