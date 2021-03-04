/**
 * DrinkQueryFindRepository.java 3 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.query;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.CocktailApiConstants.REPOSITORY_COCKTAIL_ENTITY_NAME;

import lombok.experimental.UtilityClass;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class CocktailQueryFindRepository {

	public static final String REPOSITORY_COCKTAIL_ALIAS_NAME_NAMEQUERY_NAME = "C";
	
	public static final String REPOSITORY_COCKTAIL_FIND_BY_NAME_NAMEQUERY_NAME = REPOSITORY_COCKTAIL_ENTITY_NAME
			+ ".findByName";
	public static final String REPOSITORY_COCKTAIL_FIND_BY_NAME_NAMEQUERY_NAME_PARAM = "name";
	
	public static final String REPOSITORY_COCKTAIL_FIND_BY_TYPE_NAMEQUERY_NAME = REPOSITORY_COCKTAIL_ENTITY_NAME
			+ ".findByType";
	public static final String REPOSITORY_COCKTAIL_FIND_BY_TYPE_NAMEQUERY_NAME_PARAM = "type";
	

}
