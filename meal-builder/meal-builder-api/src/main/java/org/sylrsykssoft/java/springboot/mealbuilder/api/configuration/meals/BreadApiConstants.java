/**
 * BurgerApiConstants.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals;

import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class BreadApiConstants {

	// BREAD //
	public static final String REPOSITORY_BREAD_TABLE_NAME = "bread";
	public static final String REPOSITORY_BREAD_ENTITY_NAME = "Bread";
	public static final String BREAD_ID_JOIN_COLUMN = "bread_id";
	public static final String BREAD_TYPE_COLUMN = "type";
	
	public enum BreadTypeMeal {
		BURGER, BURRITO, KEBAB, SANDWICH
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	// @see https://en.wikipedia.org/wiki/List_of_breads
	// @see https://en.wikipedia.org/wiki/List_of_sandwiches
	
}
