/**
 * BurgerApiConstants.java 16 feb. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals;

import static java.util.Arrays.asList;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

/**
 * Api constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class BreadApiConstants {

	// BREAD //
	public static final String REPOSITORY_BREAD_TABLE_NAME = "bread";
	public static final String REPOSITORY_BREAD_ENTITY_NAME = "Bread";
	public static final String BREAD_ID_JOIN_COLUMN = "bread_id";
	public static final String BREAD_TYPE_COLUMN = "type";
	
	public enum BreadTypeMeal {
		BURGER, BURRITO, KEBAB, SANDWICH
		
		// Check exists use EnumUtils.isValidEnum
	}
	
	// @see https://en.wikipedia.org/wiki/List_of_breads
	// @see https://en.wikipedia.org/wiki/List_of_sandwiches
	@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
	@Getter
	@RequiredArgsConstructor
	public enum BreadType {
		BURGER(BreadTypeMeal.BURGER, asList("chapata")),
		SANDWICH(BreadTypeMeal.BURGER, asList("Baguette", "Arepa", "Bagel", "Mollete", "Barmbrack", "Sandwich bread"));
		
		BreadTypeMeal typeMeal;
		
		List<String> breads;
		
		// Check exists use EnumUtils.isValidEnum
	}
	
}
