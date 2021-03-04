/**
 * SaladApiConstants.java 16 feb. 2021
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
public class SaladApiConstants {

	// SALAD //
	public static final String REPOSITORY_SALAD_TABLE_NAME = "salad";
	public static final String REPOSITORY_SALAD_ENTITY_NAME = "Salad";
	public static final String SALAD_ID_JOIN_COLUMN = "salad_id";
	public static final String SALAD_SIZE_COLUMN = "size";
	
	public static final String REPOSITORY_SALAD_INGREDIENT_TABLE_NAME = "salad_ingredient";
	public static final String REPOSITORY_SALAD_INGREDIENT_ENTITY_NAME = "SaladIngredient";
	
}
