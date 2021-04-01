/**
 * IngredientsApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_MODEL_NAME_ID_COLUMN;

import lombok.experimental.UtilityClass;

/**
 * IngredientApiConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class IngredientApiConstants {

	// INGREDIENT //
	public static final String REPOSITORY_INGREDIENT_TABLE_NAME = "ingredient";
	public static final String REPOSITORY_INGREDIENT_ENTITY_NAME = "Ingredient";
	public static final String INGREDIENT_ID_JOIN_COLUMN = REPOSITORY_INGREDIENT_TABLE_NAME + "_" + BASE_MODEL_NAME_ID_COLUMN;
	
	public enum IngredientType {
		FOOD_STARTER, SALAD, BURGER, KEBAB, SANDWICH, SAUCE, COCKTAIL, DESSERT
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	public static final String INGREDIENT_TYPE_NAME_COLUMN = "type";
	public static final int INGREDIENT_TYPE_NAME_COLUMN_LENGTH = 20;
	public static final String INGREDIENT_COUNT_NAME_COLUMN = "count";
	public static final String INGREDIENT_POSITION_NAME_COLUMN = "position";
	public static final int LENGTH_PRECISION_INGREDIENT_CREATED_AT = 6;
	public static final String INGREDIENT_CREATED_AT_NAME_COLUMN = "created_at";
	
	// DEFAULT VALUES //
	public static final String INGREDIENT_CREATED_AT_NAME_COLUMN_DEFAULT_VALUE = "DATETIME("
			+ LENGTH_PRECISION_INGREDIENT_CREATED_AT + ") DEFAULT CURRENT_TIMESTAMP(" + LENGTH_PRECISION_INGREDIENT_CREATED_AT + ")";
}
