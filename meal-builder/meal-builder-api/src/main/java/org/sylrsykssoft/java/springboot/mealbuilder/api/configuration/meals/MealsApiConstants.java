/**
 * MealsApiConstants.java 16 feb. 2021
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
public class MealsApiConstants {

	// SCHEMA //
	public static final String MEAL_SCHEMA_NAME = "meals";
	
	// DATASOURCE
	public static final String COMPONENT_MODEL_SCAN = "org.sylrsykssoft.java.springboot.mealbuilder.api.model.meals";
	public static final String MEALS_JPA_REPOSITORIES_BASE_PACKAGE = "org.sylrsykssoft.java.springboot.mealbuilder.repository.meals";
	public static final String MEALS_DATA_SOURCE_PROPERTIES = "app.data.datasource.meals";
	public static final String MEALS_DATA_SOURCE_CONFIGURATION_PROPERTIES = "app.data.datasource.meals.configuration";
	public static final String MEALS_DATA_SOURCE_CUSTOM_PROPERTIES = "app.data.datasource.meals.custom";
	public static final String MEALS_DATA_SOURCE_HIBERNATE_PROPERTIES = "app.data.datasource.meals.hibernate";
	public static final String MEALS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES = MEAL_SCHEMA_NAME + "SchemaDataSourceProperties";
	public static final String MEALS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES = MEAL_SCHEMA_NAME + "SchemaDataSourceCustomProperties";
	public static final String MEALS_JPA_REPOSITORIES_DATA_SOURCE = MEAL_SCHEMA_NAME + "SchemaDataSource";
	public static final String MEALS_JPA_REPOSITORIES_ENTITY_MANAGER = MEAL_SCHEMA_NAME + "EntityManagerFactory";
	public static final String MEALS_JPA_REPOSITORIES_PERSISTENCE_UNIT = MEAL_SCHEMA_NAME + "PersistenceUnit";
	public static final String MEALS_JPA_REPOSITORIES_TRANSACTION_MANAGER = MEAL_SCHEMA_NAME + "EntityTransactionManager";
	
}
