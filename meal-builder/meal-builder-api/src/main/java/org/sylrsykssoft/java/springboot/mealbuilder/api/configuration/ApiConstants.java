/**
 * ApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration;

import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class ApiConstants {

	public static final int LENGTH_PRECISION_PRICE = 7;
	public static final int LENGTH_SCALE_PRICE = 2;
	public static final int LENGTH_DIGITS_PRECISION_PRICE = 9;
	public static final int LENGTH_DIGITS_SCALE_PRICE = 2;

	// FOOD SIZE //
	public enum FoodSize {
		SMALL, MEDIUM, LARGE

		// Check exists use EnumUtils.isValidEnum
	}
	
	public static final String FOOD_SIZE_SIZE_COLUMN = "size";
	public static final String FOOD_SIZE_SIZE_COLUMN_DEFAULT_VALUE = "varchar(10) default 'MEDIUM'";
	public static final int FOOD_SIZE_SIZE_COLUMN_LENGTH = 10;
	
	
	// PACKAGES //
	public static final String API_APP_BASE_PACKAGE = "org.sylrsykssoft.java.springboot.mealbuilder";
	public static final String API_COMPONENT_MODEL_DTO_SCAN = API_APP_BASE_PACKAGE + ".api.dto";
	public static final String API_COMPONENT_MODEL_MAPPER_SCAN = API_APP_BASE_PACKAGE + ".api.mapper";
	public static final String API_COMPONENT_MODEL_SCAN = API_APP_BASE_PACKAGE + ".api.model";
	public static final String API_JPA_REPOSITORIES_BASE_PACKAGE = API_APP_BASE_PACKAGE + ".repository";
	public static final String API_MODEL_SERVICES_BASE_PACKAGE = API_APP_BASE_PACKAGE + ".model.service";
	public static final String API_REST_CONTROLLER_BASE_PACKAGE = API_APP_BASE_PACKAGE + ".rest.controller";

	// DATASOURCE //
	public static final String API_DATA_SOURCE_PROPERTIES_BASE = "app.data.datasource";
	public static final String API_DATA_SOURCE_CONFIGURATION_PROPERTIES_CONFIGURATION_NAME = "configuration";
	public static final String API_DATA_SOURCE_CUSTOM_PROPERTIES_NAME = "custom";
	public static final String API_DATA_SOURCE_HIBERNATE_PROPERTIES_NAME = "hibernate";
	
	// MODELMAPPER //
	public static final String API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME = "commonModelMapper";
	public static final String API_MODELMAPPER_EMBEDDABLE_MODEL_MODEL_MAPPER_BEAN_NAME = "mealBuilderEmbeddableModelMapper";
	
	public static final String API_MODELMAPPER_MODEL_DRINKS_LOCALIZED_MODEL_MAPPER_BEAN_NAME = "mealBuilderDrinksLocalizedDataModelMapper";
	public static final String API_MODELMAPPER_MODEL_DRINKS_MODEL_MAPPER_BEAN_NAME = "mealBuilderDrinksModelMapper";

	// JPA QUERY OBJECTS NAMES //
	public static final String PRICE_MODEL_OBJECT_JPA = "price";

	// JPA FIELD NAMES //
	public static final String FOODSIZE_SIZE_COLUMN = "size";
	// PRICE //
	public static final String PRICE_PRICE_NAME_COLUMN = "price";
	// PREPARATION //
	public static final String PREPARATION_PREPARATION_NAME_COLUMN = "preparation";

	// JPA QUERY FIELD NAMES //
	// PRICE //
	public static final String PRICE_MODEL_OBJECT_PRICE_JPA = PRICE_MODEL_OBJECT_JPA + "." + PRICE_PRICE_NAME_COLUMN;

	// REST CONTOLLER //
	public static final String API_REST_CONTROLLER_PUBLIC_API_PACKAGE_NAME = "publicapi";
	public static final String API_REST_CONTROLLER_ADMIN_API_PACKAGE_NAME = "adminapi";
		
}
