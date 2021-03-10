/**
 * IngredientsApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients;

import lombok.experimental.UtilityClass;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class IngredientApiConstants {

	// INGREDIENT //
	public static final String REPOSITORY_INGREDIENT_TABLE_NAME = "ingredient";
	public static final String REPOSITORY_INGREDIENT_ENTITY_NAME = "Ingredient";
	public static final String INGREDIENT_ID_JOIN_COLUMN = "ingredient_id";
	
	public enum IngredientType {
		FOOD_STARTER, SALAD, BURGER, KEBAB, SANDWICH, SAUCE, COCKTAIL, DESSERT
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	public static final String INGREDIENT_TYPE_NAME_COLUMN = "type";
	public static final int INGREDIENT_TYPE_NAME_COLUMN_LENGTH = 20;
	public static final String INGREDIENT_COUNT_NAME_COLUMN = "count";
	public static final String INGREDIENT_POSITION_NAME_COLUMN = "position";
	public static final String INGREDIENT_CREATED_AT_NAME_COLUMN = "created_at";
	
	
	
}
