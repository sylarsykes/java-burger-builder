/**
 * SaucesApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_COMPONENT_MODEL_SCAN;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_CONFIGURATION_PROPERTIES_CONFIGURATION_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_CUSTOM_PROPERTIES_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_HIBERNATE_PROPERTIES_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_DATA_SOURCE_PROPERTIES_BASE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_JPA_REPOSITORIES_BASE_PACKAGE;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_REST_CONTROLLER_ADMIN_API_PACKAGE_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_REST_CONTROLLER_BASE_PACKAGE;
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
public class SaucesApiConstants {

	// SCHEMA //
	public static final String SAUCE_SCHEMA_NAME = "sauces";

	// PACKAGES //
	public static final String SAUCES_JPA_MODEL_BASE_PACKAGE = API_COMPONENT_MODEL_SCAN + "." + SAUCE_SCHEMA_NAME;
	public static final String SAUCES_JPA_REPOSITORIES_BASE_PACKAGE = API_JPA_REPOSITORIES_BASE_PACKAGE + "."
			+ SAUCE_SCHEMA_NAME;
	public static final String SAUCES_REST_CONTROLLER_BASE_PACKAGE = API_REST_CONTROLLER_BASE_PACKAGE + "."
			+ SAUCE_SCHEMA_NAME;

	// DATASOURCE
	public static final String SAUCES_JPA_REPOSITORIES_MAPPING_FILE = "META-INF/" + SAUCE_SCHEMA_NAME + "-mapping/";
	public static final String SAUCES_DATA_SOURCE_PROPERTIES = API_DATA_SOURCE_PROPERTIES_BASE + "."
			+ SAUCE_SCHEMA_NAME;
	public static final String SAUCES_DATA_SOURCE_CONFIGURATION_PROPERTIES = SAUCES_DATA_SOURCE_PROPERTIES + "."
			+ API_DATA_SOURCE_CONFIGURATION_PROPERTIES_CONFIGURATION_NAME;
	public static final String SAUCES_DATA_SOURCE_CUSTOM_PROPERTIES = SAUCES_DATA_SOURCE_PROPERTIES + "."
			+ API_DATA_SOURCE_CUSTOM_PROPERTIES_NAME;
	public static final String SAUCES_DATA_SOURCE_HIBERNATE_PROPERTIES = SAUCES_DATA_SOURCE_PROPERTIES + "."
			+ API_DATA_SOURCE_HIBERNATE_PROPERTIES_NAME;
	public static final String SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CONFIGURATION_PROPERTIES = SAUCE_SCHEMA_NAME
			+ "ConfigurationDataSourceProperties";
	public static final String SAUCES_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES = SAUCE_SCHEMA_NAME
			+ "SchemaDataSourceProperties";
	public static final String SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES = SAUCE_SCHEMA_NAME
			+ "SchemaDataSourceCustomProperties";
	public static final String SAUCES_JPA_REPOSITORIES_DATA_SOURCE = SAUCE_SCHEMA_NAME + "SchemaDataSource";
	public static final String SAUCES_JPA_REPOSITORIES_ENTITY_MANAGER = SAUCE_SCHEMA_NAME + "EntityManagerFactory";
	public static final String SAUCES_JPA_REPOSITORIES_PERSISTENCE_UNIT = SAUCE_SCHEMA_NAME + "PersistenceUnit";
	public static final String SAUCES_JPA_REPOSITORIES_TRANSACTION_MANAGER = SAUCE_SCHEMA_NAME
			+ "EntityTransactionManager";

	// INGREDIENT //
	public static final String SAUCES_REPOSITORY_INGREDIENT_ENTITY_NAME = "S" + REPOSITORY_INGREDIENT_ENTITY_NAME;

	// REST CONTROLLER //
	public static final String SAUCES_REST_CONTROLLER_PUBLIC_API_PACKAGE = SAUCES_REST_CONTROLLER_BASE_PACKAGE + "."
			+ API_REST_CONTROLLER_PUBLIC_API_PACKAGE_NAME;
	public static final String SAUCES_REST_CONTROLLER_ADMIN_API_PACKAGE = SAUCES_REST_CONTROLLER_BASE_PACKAGE + "."
			+ API_REST_CONTROLLER_ADMIN_API_PACKAGE_NAME;

}
