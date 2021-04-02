/**
 * MealsApiConstants.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_COMPONENT_MODEL_SCAN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_CONFIGURATION_PROPERTIES_CONFIGURATION_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_CUSTOM_PROPERTIES_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_HIBERNATE_PROPERTIES_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_PROPERTIES_BASE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_JPA_REPOSITORIES_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_REST_CONTROLLER_ADMIN_API_PACKAGE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_REST_CONTROLLER_PUBLIC_API_PACKAGE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_ENTITY_NAME;

import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class MealsApiConstants {

	// CATEGORY CUISINE //
	public enum CategoryCuisine {
		BURGER, BURRITO, DESSERT, FOOD_STARTER, SALAD, SANDWICH, ASSIAN, AMERICAN, TURKISH, SPANISH, HEALTHY, FAST_FOOD,
		ITALIAN, MEXICAN, CHINESE, MEDITERRANEAN, JAPANESE, LATIN_AMERICAN, BRAZILIAN, ARABIAN, VEGETARIAN, VEGAN,
		CHICKEN, ARGENTINIAN, GOURMET

		// Check exists use EnumUtils.isValidEnum
	}
	
	public enum MealType {
		CHICKEN, MEAT, VEGETARIAN, VEGAN
		
		// Check exists use EnumUtils.isValidEnum
	}
	public static final String MEAL_TYPE_TYPE_COLUMN = "type";
	public static final int MEAL_TYPE_TYPE_COLUMN_LENGTH = 10;
	public static final String MEAL_TYPE_TYPE_COLUMN_DEFAULT_VALUE = "VARCHAR(" + MEAL_TYPE_TYPE_COLUMN_LENGTH + ") DEFAULT 'MEAT'";
	
	public static final String REPOSITORY_CATEGORY_TABLE_NAME = "category";
	public static final String REPOSITORY_CATEGORY_ENTITY_NAME = "MealCategory";
	public static final String CATEGORY_ID_JOIN_COLUMN = "category_id";
	
	// SCHEMA //
	public static final String MEAL_SCHEMA_NAME = "meals";

	// PACKAGES //
	public static final String MEALS_JPA_MODEL_BASE_PACKAGE = API_COMPONENT_MODEL_SCAN + "." + MEAL_SCHEMA_NAME;
	public static final String MEALS_JPA_REPOSITORIES_BASE_PACKAGE = API_JPA_REPOSITORIES_BASE_PACKAGE + "."
			+ MEAL_SCHEMA_NAME;

	// DATASOURCE
	public static final String MEALS_JPA_REPOSITORIES_MAPPING_FILE = "META-INF/" + MEAL_SCHEMA_NAME + "-mapping/";
	public static final String MEALS_DATA_SOURCE_PROPERTIES = API_DATA_SOURCE_PROPERTIES_BASE + "." + MEAL_SCHEMA_NAME;
	public static final String MEALS_DATA_SOURCE_CONFIGURATION_PROPERTIES = MEALS_DATA_SOURCE_PROPERTIES + "."
			+ API_DATA_SOURCE_CONFIGURATION_PROPERTIES_CONFIGURATION_NAME;
	public static final String MEALS_DATA_SOURCE_CUSTOM_PROPERTIES = MEALS_DATA_SOURCE_PROPERTIES + "."
			+ API_DATA_SOURCE_CUSTOM_PROPERTIES_NAME;
	public static final String MEALS_DATA_SOURCE_HIBERNATE_PROPERTIES = MEALS_DATA_SOURCE_PROPERTIES + "."
			+ API_DATA_SOURCE_HIBERNATE_PROPERTIES_NAME;
	public static final String MEALS_JPA_REPOSITORIES_DATA_SOURCE_CONFIGURATION_PROPERTIES = MEAL_SCHEMA_NAME
			+ "ConfigurationDataSourceProperties";
	public static final String MEALS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES = MEAL_SCHEMA_NAME
			+ "SchemaDataSourceProperties";
	public static final String MEALS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES = MEAL_SCHEMA_NAME
			+ "SchemaDataSourceCustomProperties";
	public static final String MEALS_JPA_REPOSITORIES_DATA_SOURCE = MEAL_SCHEMA_NAME + "SchemaDataSource";
	public static final String MEALS_JPA_REPOSITORIES_ENTITY_MANAGER = MEAL_SCHEMA_NAME + "EntityManagerFactory";
	public static final String MEALS_JPA_REPOSITORIES_PERSISTENCE_UNIT = MEAL_SCHEMA_NAME + "PersistenceUnit";
	public static final String MEALS_JPA_REPOSITORIES_TRANSACTION_MANAGER = MEAL_SCHEMA_NAME
			+ "EntityTransactionManager";

	// INGREDIENT //
	public static final String MEALS_REPOSITORY_INGREDIENT_ENTITY_NAME = "M" + REPOSITORY_INGREDIENT_ENTITY_NAME;

	// REST CONTROLLER //
	public static final String MEALS_REST_CONTROLLER_PUBLIC_API_PACKAGE = MEALS_JPA_REPOSITORIES_BASE_PACKAGE + "."
			+ API_REST_CONTROLLER_PUBLIC_API_PACKAGE_NAME;
	public static final String MEALS_REST_CONTROLLER_ADMIN_API_PACKAGE = MEALS_JPA_REPOSITORIES_BASE_PACKAGE + "."
			+ API_REST_CONTROLLER_ADMIN_API_PACKAGE_NAME;

}
