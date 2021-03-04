/**
 * BurgerApiConstants.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals;

import static java.util.Arrays.asList;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEALS_JPA_REPOSITORIES_MAPPING_FILE;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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
	public static final String BURGER_TYPE_COLUMN = "type";
	public static final String BURGER_SIZE_COLUMN = "size";
	
	
	public static final String REPOSITORY_BURGER_INGREDIENT_TABLE_NAME = "burger_ingredient";
	public static final String REPOSITORY_BURGER_INGREDIENT_ENTITY_NAME = "BurgerIngredient";
	
	public enum BurgerType {
		CHICKEN, MEAT, VEGETARIAN, VEGAN
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	// BREAD //
	public static final String REPOSITORY_BREAD_TABLE_NAME = "bread";
	public static final String REPOSITORY_BREAD_ENTITY_NAME = "Bread";
	public static final String BREAD_ID_JOIN_COLUMN = "bread_id";
	public static final String BREAD_TYPE_COLUMN = "type";
	public static final String BREAD_SIZE_COLUMN = "size";
	
	public enum BreadTypeMeal {
		BURGER, SANDWICH
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	// @see https://en.wikipedia.org/wiki/List_of_breads
	// @see https://en.wikipedia.org/wiki/List_of_sandwiches
	@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
	@Getter
	@RequiredArgsConstructor
	public enum BreadType {
		BURGER(BreadTypeMeal.BURGER, asList("chapata")),
		SANDWICH(BreadTypeMeal.BURGER, asList("Baguette", "Arepa", "Bagel", "Mollete", "Barmbrack", "Sandwich bread"));
		
		BreadTypeMeal typeMeal;
		
		List<String> breads;
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	// MAPPING FILE //
	public static final String MEALS_BURGER_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_BURGER_TABLE_NAME + ".orm.xml";
	public static final String MEALS_BURGER_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_BURGER_INGREDIENT_TABLE_NAME + ".orm.xml";
	public static final String MEALS_BREAD_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_BREAD_TABLE_NAME + ".orm.xml";
	public static final String MEALS_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE = MEALS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_INGREDIENT_TABLE_NAME + ".orm.xml";
	
}
