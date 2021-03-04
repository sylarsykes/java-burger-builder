/**
 * SauceApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces;

import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class SauceApiConstants {
	
	// SAUCE //
	public static final String REPOSITORY_SAUCE_TABLE_NAME = "sauce";
	public static final String REPOSITORY_SAUCE_ENTITY_NAME = "Sauce";
	public static final String SAUCE_ID_JOIN_COLUMN = "sauce_id";
	
	// SAUCE INGREDIENT //
	public static final String REPOSITORY_SAUCE_INGREDIENT_TABLE_NAME = "sauce_ingredient";
	public static final String REPOSITORY_SAUCE_INGREDIENT_ENTITY_NAME = "SauceIngredient";
	
}
