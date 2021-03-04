/**
 * DrinkApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks;


import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_OBJECT_DESCRIPTION_JPA;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_NAME_MODEL_OBJECT_NAME_JPA;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_MODEL_NAME_ID_JPA;

import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class DrinkApiConstants {

	// DRINK //
	public static final String REPOSITORY_DRINK_TABLE_NAME = "drink";
	public static final String REPOSITORY_DRINK_ENTITY_NAME = "Drink";
	
	public enum DrinkType {
		NO_ALCOHOLIC, ALCOHOLIC
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	// JPA FIELD NAMES //
	public static final String DRINK_MODEL_ID_JPA = BASE_MODEL_NAME_ID_JPA;
	public static final String DRINK_MODEL_NAME_JPA = BASE_NAME_MODEL_OBJECT_NAME_JPA;
	public static final String DRINK_MODEL_DESCRIPTION_JPA = BASE_NAME_MODEL_OBJECT_DESCRIPTION_JPA;
	
}
