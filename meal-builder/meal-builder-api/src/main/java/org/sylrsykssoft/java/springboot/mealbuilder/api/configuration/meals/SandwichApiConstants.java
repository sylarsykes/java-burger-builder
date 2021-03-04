/**
 * SandwichApiConstants.java 16 feb. 2021
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
public class SandwichApiConstants {

	// SANDWICH //
	public static final String REPOSITORY_SANDWICH_TABLE_NAME = "sandwich";
	public static final String REPOSITORY_SANDWICH_ENTITY_NAME = "Sandwich";
	public static final String SANDWICH_ID_JOIN_COLUMN = "sandwich_id";
	public static final String SANDWICH_SIZE_COLUMN = "size";
	
	public static final String REPOSITORY_SANDWICH_INGREDIENT_TABLE_NAME = "sandwich_ingredient";
	public static final String REPOSITORY_SANDWICH_INGREDIENT_ENTITY_NAME = "SandwichIngredient";
	
	// MAPPING FILE //
	public static final String MEALS_SANDWICH_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_SANDWICH_TABLE_NAME + ".orm.xml";
	public static final String MEALS_SANDWICH_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_SANDWICH_INGREDIENT_TABLE_NAME + ".orm.xml";
}
