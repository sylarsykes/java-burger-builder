/**
 * KEBABApiConstants.java 16 feb. 2021
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
public class KebabApiConstants {

	// KEBAB //
	public static final String REPOSITORY_KEBAB_TABLE_NAME = "kebab";
	public static final String REPOSITORY_KEBAB_ENTITY_NAME = "Kebab";
	public static final String KEBAB_ID_JOIN_COLUMN = "kebab_id";
	
	public static final String REPOSITORY_KEBAB_BREAD_TABLE_NAME = "kebab_bread";
	public static final String REPOSITORY_KEBAB_BREAD_ENTITY_NAME = "KebabBread";
	public static final String KEBAB_BREAD_MAPPED_BY_NAME = "kebabBread";
	public static final String KEBAB_BREAD_ID_JOIN_COLUMN = "kebab_bread_id";
	
	public static final String REPOSITORY_KEBAB_INGREDIENT_TABLE_NAME = "kebab_ingredient";
	public static final String REPOSITORY_KEBAB_INGREDIENT_ENTITY_NAME = "KebabIngredient";
	public static final int KEBAB_INGREDIENT_MAX_LENGTH = 10;
	public static final int KEBAB_INGREDIENT_MIN_LENGTH = 1;
	
	public static final String REPOSITORY_KEBAB_CATEGORY_TABLE_NAME = "kebab_category";
	public static final String REPOSITORY_KEBAB_CATEGORY_ENTITY_NAME = "KebabCategory";
	public static final int KEBAB_CATEGORY_MAX_LENGTH = 10;
	public static final int KEBAB_CATEGORY_MIN_LENGTH = 1;
	
}
