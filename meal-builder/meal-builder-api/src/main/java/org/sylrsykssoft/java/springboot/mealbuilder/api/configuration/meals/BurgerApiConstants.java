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
public class BurgerApiConstants {

	// BURGER //
	public static final String REPOSITORY_BURGER_TABLE_NAME = "burger";
	public static final String REPOSITORY_BURGER_ENTITY_NAME = "Burger";
	public static final String BURGER_ID_JOIN_COLUMN = "burger_id";
	
	public static final String REPOSITORY_BURGER_BREAD_TABLE_NAME = "burger_bread";
	public static final String REPOSITORY_BURGER_BREAD_ENTITY_NAME = "BurgerBread";
	
	public static final String REPOSITORY_BURGER_INGREDIENT_TABLE_NAME = "burger_ingredient";
	public static final String REPOSITORY_BURGER_INGREDIENT_ENTITY_NAME = "BurgerIngredient";
	
	public static final String REPOSITORY_BURGER_CATEGORY_TABLE_NAME = "burger_category";
	public static final String REPOSITORY_BURGER_CATEGORY_ENTITY_NAME = "BurgerCategory";
	
}
