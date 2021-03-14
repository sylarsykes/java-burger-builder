/**
 * SandwichApiConstants.java 16 feb. 2021
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
public class SandwichApiConstants {

	// SANDWICH //
	public static final String REPOSITORY_SANDWICH_TABLE_NAME = "sandwich";
	public static final String REPOSITORY_SANDWICH_ENTITY_NAME = "Sandwich";
	public static final String SANDWICH_ID_JOIN_COLUMN = "sandwich_id";
	
	public static final String REPOSITORY_SANDWICH_BREAD_TABLE_NAME = "sandwich_bread";
	public static final String REPOSITORY_SANDWICH_BREAD_ENTITY_NAME = "SandwichBread";
	public static final int SANDWICH_BREAD_MAX_LENGTH = 2;
	public static final int SANDWICH_BREAD_MIN_LENGTH = 2;
	
	public static final String REPOSITORY_SANDWICH_INGREDIENT_TABLE_NAME = "sandwich_ingredient";
	public static final String REPOSITORY_SANDWICH_INGREDIENT_ENTITY_NAME = "SandwichIngredient";
	public static final int SANDWICH_INGREDIENT_MAX_LENGTH = 10;
	public static final int SANDWICH_INGREDIENT_MIN_LENGTH = 1;
	
	public static final String REPOSITORY_SANDWICH_CATEGORY_TABLE_NAME = "sandwich_category";
	public static final String REPOSITORY_SANDWICH_CATEGORY_ENTITY_NAME = "SandwichCategory";
	public static final int SANDWICH_CATEGORY_MAX_LENGTH = 10;
	public static final int SANDWICH_CATEGORY_MIN_LENGTH = 1;
	
}
