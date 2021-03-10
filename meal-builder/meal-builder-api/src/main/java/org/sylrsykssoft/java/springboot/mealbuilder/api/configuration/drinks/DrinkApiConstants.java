/**
 * DrinkApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks;

import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class DrinkApiConstants {
	
	// DRINK //
	public static final String REPOSITORY_DRINK_TABLE_NAME = "drink";
	public static final String REPOSITORY_DRINK_ENTITY_NAME = "Drink";
	
	public enum DrinkType {
		NO_ALCOHOLIC, ALCOHOLIC
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	public static final String DRINK_TYPE_TYPE_COLUMN = "type";
	public static final String DRINK_TYPE_TYPE_COLUMN_DEFAULT_VALUE = "varchar(20) default 'NO_ALCOHOLIC'";
	public static final int DRINK_TYPE_TYPE_COLUMN_LENGTH = 20;
	
}
