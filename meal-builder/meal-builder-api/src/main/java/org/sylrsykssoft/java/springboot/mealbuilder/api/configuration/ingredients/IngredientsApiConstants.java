/**
 * IngredientsApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients;

import lombok.experimental.UtilityClass;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class IngredientsApiConstants {

	// SCHEMA //
	public static final String INGREDIENT_SCHEMA_NAME = "ingredients";
	
	// DATASOURCE
	public static final String INGREDIENTS_JPA_MODEL_BASE_PACKAGE = "org.sylrsykssoft.java.springboot.mealbuilder.api.model.ingredients";
	public static final String INGREDIENTS_JPA_REPOSITORIES_BASE_PACKAGE = "org.sylrsykssoft.java.springboot.mealbuilder.repository.ingredients";
	public static final String INGREDIENTS_DATA_SOURCE_PROPERTIES = "app.data.datasource.ingredients";
	public static final String INGREDIENTS_DATA_SOURCE_CONFIGURATION_PROPERTIES = "app.data.datasource.ingredients.configuration";
	public static final String INGREDIENTS_DATA_SOURCE_CUSTOM_PROPERTIES = "app.data.datasource.ingredients.custom";
	public static final String INGREDIENTS_DATA_SOURCE_HIBERNATE_PROPERTIES = "app.data.datasource.ingredients.hibernate";
	public static final String INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES = INGREDIENT_SCHEMA_NAME + "SchemaDataSourceProperties";
	public static final String INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES = INGREDIENT_SCHEMA_NAME + "SchemaDataSourceCustomProperties";
	public static final String INGREDIENTS_JPA_REPOSITORIES_DATA_SOURCE = INGREDIENT_SCHEMA_NAME + "SchemaDataSource";
	public static final String INGREDIENTS_JPA_REPOSITORIES_ENTITY_MANAGER = INGREDIENT_SCHEMA_NAME + "EntityManagerFactory";
	public static final String INGREDIENTS_JPA_REPOSITORIES_PERSISTENCE_UNIT = INGREDIENT_SCHEMA_NAME + "PersistenceUnit";
	public static final String INGREDIENTS_JPA_REPOSITORIES_TRANSACTION_MANAGER = INGREDIENT_SCHEMA_NAME + "EntityTransactionManager";

	// INGREDIENT //
	public static final String REPOSITORY_INGREDIENT_TABLE_NAME = "ingredient";
	public static final String REPOSITORY_INGREDIENT_ENTITY_NAME = "DIngredient";
	public static final String INGREDIENT_ID_JOIN_COLUMN = "ingredient_id";
	
	public enum IngredientType {
		FOOD_STARTER, SALAD, BURGER, SANDWICH, SAUCE, COCKTAIL, DESSERT
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	public static final String INGREDIENT_TYPE_NAME_COLUMN = "type";
	public static final String INGREDIENT_COUNT_NAME_COLUMN = "count";
	public static final String INGREDIENT_POSITION_NAME_COLUMN = "position";
	public static final String INGREDIENT_CREATED_AT_NAME_COLUMN = "created_at";
	
	
	
}
