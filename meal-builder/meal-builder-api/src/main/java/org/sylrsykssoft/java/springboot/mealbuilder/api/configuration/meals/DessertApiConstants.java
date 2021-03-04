/**
 * DessertApiConstants.java 16 feb. 2021
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
public class DessertApiConstants {

	// DESSERT //
	public static final String REPOSITORY_DESSERT_TABLE_NAME = "dessert";
	public static final String REPOSITORY_DESSERT_ENTITY_NAME = "Dessert";
	public static final String DESSERT_ID_JOIN_COLUMN = "dessert_id";
	
	public static final String REPOSITORY_DESSERT_INGREDIENT_TABLE_NAME = "dessert_ingredient";
	public static final String REPOSITORY_DESSERT_INGREDIENT_ENTITY_NAME = "DessertIngredient";
	
	// MAPPING FILE //
	public static final String MEALS_DESSERT_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_DESSERT_TABLE_NAME + ".orm.xml";
	public static final String MEALS_DESSERT_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_DESSERT_INGREDIENT_TABLE_NAME + ".orm.xml";
}
