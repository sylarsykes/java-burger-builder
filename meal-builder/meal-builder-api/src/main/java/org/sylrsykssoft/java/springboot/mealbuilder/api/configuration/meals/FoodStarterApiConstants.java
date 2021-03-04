/**
 * FoodStarterApiConstants.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_MAPPING_FILE;

import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class FoodStarterApiConstants {

	// FOOD STARTER //
	public static final String REPOSITORY_FOOD_STARTER_TABLE_NAME = "food_starter";
	public static final String REPOSITORY_FOOD_STARTER_ENTITY_NAME = "FoodStarter";
	public static final String REPOSITORY_FOOD_STARTER_TABLE_KEY_NAME = "foodStarter";
	public static final String FOOD_STARTER_ID_JOIN_COLUMN = "food_starter_id";
	public static final String FOOD_STARTER_SIZE_COLUMN = "size";
	
	public static final String REPOSITORY_FOOD_STARTER_INGREDIENT_TABLE_NAME = "food_starter_ingredient";
	public static final String REPOSITORY_FOOD_STARTER_INGREDIENT_ENTITY_NAME = "FoodStarterIngredient";
	
	// MAPPING FILE //
	public static final String MEALS_FOOD_STARTER_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_FOOD_STARTER_TABLE_NAME + ".orm.xml";
	public static final String MEALS_FOOD_STARTER_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_FOOD_STARTER_INGREDIENT_TABLE_NAME + ".orm.xml";
}
