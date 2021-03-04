/**
 * CocktailApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINKS_JPA_REPOSITORIES_MAPPING_FILE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;

import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class CocktailApiConstants {

	// COCKTAIL //
	// https://en.wikipedia.org/wiki/Cocktail
	public static final String REPOSITORY_COCKTAIL_TABLE_NAME = "cocktail";
	public static final String REPOSITORY_COCKTAIL_ENTITY_NAME = "Cocktail";
	public static final String COCKTAIL_ID_JOIN_COLUMN = "cocktail_id";
	public static final String COCKTAIL_GLASS_COCKTAIL_JOIN_COLUMN = "glassCocktail";
	
	public enum CocktailClassification {
		APPETIZER, DIGESTIVE, RESTORATIVE, MID_AFTERNOON, REFRESHING 
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	public static final String REPOSITORY_COCKTAIL_INGREDIENT_TABLE_NAME = "cocktail_ingredient";
	public static final String REPOSITORY_COCKTAIL_INGREDIENT_ENTITY_NAME = "CocktailIngredient";
	
	public static final String REPOSITORY_GLASS_COCKTAIL_TABLE_NAME = "glass_cocktail";
	public static final String REPOSITORY_GLASS_COCKTAIL_ENTITY_NAME = "GlassCocktail";
	public static final String GLASS_COCKTAIL_ID_JOIN_COLUMN = "glass_cocktail_id";
	public static final String GLASS_COCKTAIL_NAME_SIZE_COLUMN = "size";
	
	// GLASS SIZE //
	public enum GlassCocktailSize {
		SHOT, SMALL, MEDIUM, LARGE
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	// MAPPING FILE //
	public static final String DRINKS_COCKTAIL_JPA_REPOSITORIES_MAPPING_FILE = DRINKS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_COCKTAIL_TABLE_NAME + ".orm.xml";
	public static final String DRINKS_COCKTAIL_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE = DRINKS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_COCKTAIL_INGREDIENT_TABLE_NAME + ".orm.xml";
	public static final String DRINKS_GLASS_COCKTAIL_JPA_REPOSITORIES_MAPPING_FILE = DRINKS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_GLASS_COCKTAIL_TABLE_NAME + ".orm.xml";
	public static final String DRINKS_INGREDIENT_JPA_REPOSITORIES_MAPPING_FILE = DRINKS_JPA_REPOSITORIES_MAPPING_FILE + REPOSITORY_INGREDIENT_TABLE_NAME + ".orm.xml";
}
