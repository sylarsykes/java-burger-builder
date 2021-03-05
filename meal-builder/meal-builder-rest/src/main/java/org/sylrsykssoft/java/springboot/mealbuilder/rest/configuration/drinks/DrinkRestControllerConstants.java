/**
 * DrinkRestControllerConstants.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks;

import lombok.experimental.UtilityClass;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class DrinkRestControllerConstants {

	// CONTROLLER //
	public static final String CONTROLLER_REQUEST_NAME = "drinks";
		
	// CONTROLLER PATH //
	public static final String CONTROLLER_REQUEST_MAPPING = "${app.rest.public.base-path}" + CONTROLLER_REQUEST_NAME;
	
	// FIND CONTROLLER // 
	public static final String FIND_MODEL_CONTROLLER_TAG_NAME = "DrinkFindModelServiceController";
	public static final String FIND_MODEL_CONTROLLER_TAG_DESCRIPTION = "Rest Controller to find Drink";
	public static final String FIND_MODEL_CONTROLLER_REQUEST_MAPPING = CONTROLLER_REQUEST_MAPPING + "/find";
	public static final String CONTROLLER_GET_FIND_BY_ID = "/id/{id}";
	public static final String CONTROLLER_GET_EXISTS_BY_ID = "/id/{id}/exists";
	public static final String CONTROLLER_GET_FIND_BY_NAME = "/name/{name}";
}
