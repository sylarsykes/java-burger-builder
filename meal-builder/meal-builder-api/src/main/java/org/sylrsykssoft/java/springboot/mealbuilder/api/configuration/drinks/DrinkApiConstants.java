/**
 * DrinkApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_JPA_REPOSITORIES_MAPPING_FILE;

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
	
	// MAPPING FILE //
	public static final String DRINKS_DRINK_JPA_REPOSITORIES_MAPPING_FILE = DRINKS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_DRINK_TABLE_NAME + ".orm.xml";
	
}
