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
}
