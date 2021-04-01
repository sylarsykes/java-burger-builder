/**
 * DrinkApiConstants.java 27 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks;

import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.BASE_MODEL_NAME_ID_COLUMN;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.REPOSITORY_LOCALIZED_DESCRIPTION_ENTITY_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.REPOSITORY_LOCALIZED_DESCRIPTION_TABLE_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.REPOSITORY_LOCALIZED_NAME_ENTITY_NAME;
import static org.sylrsykssoft.springboot.common.api.configuration.CommonAPIConstants.REPOSITORY_LOCALIZED_NAME_TABLE_NAME;

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
	public static final String DRINK_ID_JOIN_COLUMN = REPOSITORY_DRINK_TABLE_NAME + "_" + BASE_MODEL_NAME_ID_COLUMN;

	public enum DrinkType {
		NO_ALCOHOLIC, ALCOHOLIC

		// Check exists use EnumUtils.isValidEnum
	}

	public static final String DRINK_TYPE_TYPE_COLUMN = "type";
	public static final int DRINK_TYPE_TYPE_COLUMN_LENGTH = 20;
	public static final String DRINK_TYPE_TYPE_COLUMN_DEFAULT_VALUE = "VARCHAR(" + DRINK_TYPE_TYPE_COLUMN_LENGTH
			+ ") DEFAULT 'NO_ALCOHOLIC'";

	// LOCALIZED DRINK //
	public static final String REPOSITORY_LOCALIZED_NAME_DRINK_TABLE_NAME = REPOSITORY_LOCALIZED_NAME_TABLE_NAME
			+ REPOSITORY_DRINK_TABLE_NAME;
	public static final String REPOSITORY_LOCALIZED_NAME_DRINK_ENTITY_NAME = REPOSITORY_LOCALIZED_NAME_ENTITY_NAME
			+ REPOSITORY_DRINK_ENTITY_NAME;
	public static final String REPOSITORY_LOCALIZED_DESCRIPTION_DRINK_TABLE_NAME = REPOSITORY_LOCALIZED_DESCRIPTION_TABLE_NAME
			+ REPOSITORY_DRINK_TABLE_NAME;
	public static final String REPOSITORY_LOCALIZED_DESCRIPTION_DRINK_ENTITY_NAME = REPOSITORY_LOCALIZED_DESCRIPTION_ENTITY_NAME
			+ REPOSITORY_DRINK_ENTITY_NAME;

}
