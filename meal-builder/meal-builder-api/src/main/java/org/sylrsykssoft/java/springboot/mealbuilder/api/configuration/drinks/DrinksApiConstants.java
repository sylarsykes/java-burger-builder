/**
 * DrinksApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks;

import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class DrinksApiConstants {

	// SCHEMA //
	public static final String DRINK_SCHEMA_NAME = "drinks";

	// DATASOURCE //
	public static final String COMPONENT_MODEL_SCAN = "org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks";
	public static final String DRINKS_JPA_REPOSITORIES_BASE_PACKAGE = "org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks";
	public static final String DRINKS_JPA_REPOSITORIES_MAPPING_FILE = "META-INF/drinks-mapping/*.xml";
	public static final String DRINKS_DATA_SOURCE_PROPERTIES = "app.data.datasource.drinks";
	public static final String DRINKS_DATA_SOURCE_CONFIGURATION_PROPERTIES = "app.data.datasource.drinks.configuration";
	public static final String DRINKS_DATA_SOURCE_CUSTOM_PROPERTIES = "app.data.datasource.drinks.custom";
	public static final String DRINKS_DATA_SOURCE_HIBERNATE_PROPERTIES = "app.data.datasource.drinks.hibernate";
	public static final String DRINKS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES = DRINK_SCHEMA_NAME + "SchemaDataSourceProperties";
	public static final String DRINKS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES = DRINK_SCHEMA_NAME + "SchemaDataSourceCustomProperties";
	public static final String DRINKS_JPA_REPOSITORIES_DATA_SOURCE = DRINK_SCHEMA_NAME + "SchemaDataSource";
	public static final String DRINKS_JPA_REPOSITORIES_ENTITY_MANAGER = DRINK_SCHEMA_NAME + "EntityManagerFactory";
	public static final String DRINKS_JPA_REPOSITORIES_PERSISTENCE_UNIT = DRINK_SCHEMA_NAME + "PersistenceUnit";
	public static final String DRINKS_JPA_REPOSITORIES_TRANSACTION_MANAGER = DRINK_SCHEMA_NAME + "EntityTransactionManager";
	
}
