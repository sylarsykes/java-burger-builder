/**
 * CocktailApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.INGREDIENT_TYPE_NAME_COLUMN_LENGTH;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_ENTITY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_TABLE_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_MODEL_NAME_ID_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.REPOSITORY_LOCALIZED_ENTITY_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.REPOSITORY_LOCALIZED_TABLE_NAME;

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
	public static final String COCKTAIL_ID_JOIN_COLUMN = REPOSITORY_COCKTAIL_TABLE_NAME + "_"
			+ BASE_MODEL_NAME_ID_COLUMN;
	public static final String COCKTAIL_GLASS_COCKTAIL_JOIN_COLUMN = "glassCocktail";

	public enum CocktailClassification {
		APPETIZER, DIGESTIVE, RESTORATIVE, MID_AFTERNOON, REFRESHING

		// Check exists use EnumUtils.isValidEnum
	}

	public static final String COCKTAIL_CLASSIFICATION_TYPE_COLUMN = "type";
	public static final int COCKTAIL_CLASSIFICATION_TYPE_COLUMN_LENGTH = 20;
	public static final String COCKTAIL_CLASSIFICATION_TYPE_COLUMN_DEFAULT_VALUE = "VARCHAR("
			+ COCKTAIL_CLASSIFICATION_TYPE_COLUMN_LENGTH + ") DEFAULT 'APPETIZER'";

	// LOCALIZED COCKTAIL //
	public static final String REPOSITORY_LOCALIZED_COCKTAIL_TABLE_NAME = REPOSITORY_LOCALIZED_TABLE_NAME
			+ REPOSITORY_COCKTAIL_TABLE_NAME;
	public static final String REPOSITORY_LOCALIZED_COCKTAIL_ENTITY_NAME = REPOSITORY_LOCALIZED_ENTITY_NAME
			+ REPOSITORY_COCKTAIL_ENTITY_NAME;

	public static final String REPOSITORY_COCKTAIL_INGREDIENT_TABLE_NAME = REPOSITORY_COCKTAIL_TABLE_NAME + "_"
			+ REPOSITORY_INGREDIENT_TABLE_NAME;
	public static final String REPOSITORY_COCKTAIL_INGREDIENT_ENTITY_NAME = REPOSITORY_COCKTAIL_ENTITY_NAME
			+ REPOSITORY_INGREDIENT_ENTITY_NAME;
	public static final int COCKTAIL_INGREDIENT_MAX_LENGTH = 10;
	public static final int COCKTAIL_INGREDIENT_MIN_LENGTH = 1;
	public static final String COCKTAIL_INGREDIENT_NAME_TYPE_COLUMN_DEFAULT_VALUE = "VARCHAR("
			+ INGREDIENT_TYPE_NAME_COLUMN_LENGTH + ") DEFAULT 'COCKTAIL'";

	public static final String REPOSITORY_GLASS_COCKTAIL_TABLE_NAME = "glass_" + REPOSITORY_COCKTAIL_TABLE_NAME;
	public static final String REPOSITORY_GLASS_COCKTAIL_ENTITY_NAME = "Glass" + REPOSITORY_COCKTAIL_ENTITY_NAME;
	public static final String GLASS_COCKTAIL_ID_JOIN_COLUMN = "glass_" + REPOSITORY_COCKTAIL_TABLE_NAME + "_"
			+ BASE_MODEL_NAME_ID_COLUMN;

	// GLASS SIZE //
	public enum GlassCocktailSize {
		SHOT, SMALL, MEDIUM, LARGE

		// Check exists use EnumUtils.isValidEnum
	}

	public static final String GLASS_COCKTAIL_NAME_SIZE_COLUMN = "size";
	public static final int GLASS_COCKTAIL_NAME_SIZE_COLUMN_LENGTH = 10;
	public static final String GLASS_COCKTAIL_NAME_SIZE_COLUMN_DEFAULT_VALUE = "VARCHAR("
			+ GLASS_COCKTAIL_NAME_SIZE_COLUMN_LENGTH + ") DEFAULT 'MEDIUM'";

}
