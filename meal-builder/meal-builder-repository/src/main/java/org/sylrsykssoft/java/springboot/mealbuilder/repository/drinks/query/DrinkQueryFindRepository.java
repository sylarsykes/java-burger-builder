/**
 * DrinkQueryFindRepository.java 3 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.query;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.REPOSITORY_DRINK_ENTITY_NAME;

import lombok.experimental.UtilityClass;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class DrinkQueryFindRepository {

	public static final String REPOSITORY_DRINK_ALIAS_NAME_NAMEQUERY_NAME = "D";
	
	public static final String REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME = REPOSITORY_DRINK_ENTITY_NAME
			+ ".findByName";
	public static final String REPOSITORY_DRINK_FIND_BY_NAME_NAMEQUERY_NAME_PARAM = "name";
	
	public static final String REPOSITORY_DRINK_FIND_BY_TYPE_NAMEQUERY_NAME = REPOSITORY_DRINK_ENTITY_NAME
			+ ".findByType";
	public static final String REPOSITORY_DRINK_FIND_BY_TYPE_NAMEQUERY_NAME_PARAM = "type";
	

}
