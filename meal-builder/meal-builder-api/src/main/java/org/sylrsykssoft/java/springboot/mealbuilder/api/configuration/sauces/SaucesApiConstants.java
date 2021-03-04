/**
 * SaucesApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces;

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
	
	// DATASOURCE
	public static final String SAUCES_JPA_MODEL_BASE_PACKAGE = "org.sylrsykssoft.java.springboot.mealbuilder.api.model.sauces";
	public static final String SAUCES_JPA_REPOSITORIES_BASE_PACKAGE = "org.sylrsykssoft.java.springboot.mealbuilder.repository.sauces";
	public static final String SAUCES_DATA_SOURCE_PROPERTIES = "app.data.datasource.sauces";
	public static final String SAUCES_DATA_SOURCE_CONFIGURATION_PROPERTIES = "app.data.datasource.sauces.configuration";
	public static final String SAUCES_DATA_SOURCE_CUSTOM_PROPERTIES = "app.data.datasource.sauces.custom";
	public static final String SAUCES_DATA_SOURCE_HIBERNATE_PROPERTIES = "app.data.datasource.sauces.hibernate";
	public static final String SAUCES_JPA_REPOSITORIES_DATA_SOURCE_PROPERTIES = SAUCE_SCHEMA_NAME + "SchemaDataSourceProperties";
	public static final String SAUCES_JPA_REPOSITORIES_DATA_SOURCE_CUSTOM_PROPERTIES = SAUCE_SCHEMA_NAME + "SchemaDataSourceCustomProperties";
	public static final String SAUCES_JPA_REPOSITORIES_DATA_SOURCE = SAUCE_SCHEMA_NAME + "SchemaDataSource";
	public static final String SAUCES_JPA_REPOSITORIES_ENTITY_MANAGER = SAUCE_SCHEMA_NAME + "EntityManagerFactory";
	public static final String SAUCES_JPA_REPOSITORIES_PERSISTENCE_UNIT = SAUCE_SCHEMA_NAME + "PersistenceUnit";
	public static final String SAUCES_JPA_REPOSITORIES_TRANSACTION_MANAGER = SAUCE_SCHEMA_NAME + "EntityTransactionManager";

}
