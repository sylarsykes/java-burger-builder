/**
 * DrinksApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_COMPONENT_MODEL_SCAN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_CONFIGURATION_PROPERTIES_CONFIGURATION_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_CUSTOM_PROPERTIES_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_HIBERNATE_PROPERTIES_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_PROPERTIES_BASE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_JPA_REPOSITORIES_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ingredients.IngredientApiConstants.REPOSITORY_INGREDIENT_ENTITY_NAME;

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

	// PACKAGES //
	public static final String DRINKS_JPA_MODEL_BASE_PACKAGE = API_COMPONENT_MODEL_SCAN + "." + DRINK_SCHEMA_NAME;
	public static final String DRINKS_JPA_REPOSITORIES_BASE_PACKAGE = API_JPA_REPOSITORIES_BASE_PACKAGE + "."
			+ DRINK_SCHEMA_NAME;
	
	// DATASOURCE //
	public static final String DRINKS_JPA_REPOSITORIES_MAPPING_FILE = "META-INF/" + DRINK_SCHEMA_NAME + "-mapping/";
	public static final String DRINKS_DATA_SOURCE_PROPERTIES = API_DATA_SOURCE_PROPERTIES_BASE + "."
			+ DRINK_SCHEMA_NAME;
	public static final String DRINKS_DATA_SOURCE_CONFIGURATION_PROPERTIES = DRINKS_DATA_SOURCE_PROPERTIES + "."
			+ API_DATA_SOURCE_CONFIGURATION_PROPERTIES_CONFIGURATION_NAME;
	public static final String DRINKS_DATA_SOURCE_CUSTOM_PROPERTIES = DRINKS_DATA_SOURCE_PROPERTIES + "."
			+ API_DATA_SOURCE_CUSTOM_PROPERTIES_NAME;
	public static final String DRINKS_DATA_SOURCE_HIBERNATE_PROPERTIES = DRINKS_DATA_SOURCE_PROPERTIES + "."
			+ API_DATA_SOURCE_HIBERNATE_PROPERTIES_NAME;
	public static final String DRINKS_JPA_REPOSITORIES_DATA_SOURCE_CONFIGURATION_PROPERTIES = DRINK_SCHEMA_NAME
			+ "ConfigurationDataSourceProperties";
	public static final String DRINKS_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES = DRINK_SCHEMA_NAME
			+ "SchemaDataSourceProperties";
	public static final String DRINKS_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES = DRINK_SCHEMA_NAME
			+ "SchemaDataSourceCustomProperties";
	public static final String DRINKS_JPA_REPOSITORIES_DATA_SOURCE = DRINK_SCHEMA_NAME + "SchemaDataSource";
	public static final String DRINKS_JPA_REPOSITORIES_ENTITY_MANAGER = DRINK_SCHEMA_NAME + "EntityManagerFactory";
	public static final String DRINKS_JPA_REPOSITORIES_PERSISTENCE_UNIT = DRINK_SCHEMA_NAME + "PersistenceUnit";
	public static final String DRINKS_JPA_REPOSITORIES_TRANSACTION_MANAGER = DRINK_SCHEMA_NAME
			+ "EntityTransactionManager";

	// INGREDIENT //
	public static final String DRINKS_REPOSITORY_INGREDIENT_ENTITY_NAME = "D" + REPOSITORY_INGREDIENT_ENTITY_NAME;

}
