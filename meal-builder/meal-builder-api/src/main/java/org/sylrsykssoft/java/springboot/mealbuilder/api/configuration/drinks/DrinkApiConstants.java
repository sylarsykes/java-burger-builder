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
	public static final String DRINK_ID_JOIN_COLUMN = "drink_id";
	
	public enum DrinkType {
		NO_ALCOHOLIC, ALCOHOLIC
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	public static final String DRINK_TYPE_TYPE_COLUMN = "type";
	public static final String DRINK_TYPE_TYPE_COLUMN_DEFAULT_VALUE = "varchar(20) default 'NO_ALCOHOLIC'";
	public static final int DRINK_TYPE_TYPE_COLUMN_LENGTH = 20;
	
	// LOCALIZED DRINK //
	public static final String REPOSITORY_LOCALIZED_NAME_DRINK_TABLE_NAME = "localized_name_drink";
	public static final String REPOSITORY_LOCALIZED_NAME_DRINK_ENTITY_NAME = "LocalizedNameDrink";
	
	public static final String REPOSITORY_LOCALIZED_DESCRIPTION_DRINK_TABLE_NAME = "localized_description_drink";
	public static final String REPOSITORY_LOCALIZED_DESCRIPTION_DRINK_ENTITY_NAME = "LocalizedDescriptionDrink";
	
}
