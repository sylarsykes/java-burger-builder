/**
 * DessertApiConstants.java 16 feb. 2021
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
public class DessertApiConstants {

	// DESSERT //
	public static final String REPOSITORY_DESSERT_TABLE_NAME = "dessert";
	public static final String REPOSITORY_DESSERT_ENTITY_NAME = "Dessert";
	public static final String DESSERT_ID_JOIN_COLUMN = "dessert_id";
	
	public static final String REPOSITORY_DESSERT_INGREDIENT_TABLE_NAME = "dessert_ingredient";
	public static final String REPOSITORY_DESSERT_INGREDIENT_ENTITY_NAME = "DessertIngredient";
	
}
