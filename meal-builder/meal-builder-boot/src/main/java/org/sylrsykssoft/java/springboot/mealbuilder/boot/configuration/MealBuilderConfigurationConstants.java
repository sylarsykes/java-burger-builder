/**
 * MealBuilderConfigurationConstants.java 7 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinksApiConstants.DRINK_SCHEMA_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.meals.MealsApiConstants.MEAL_SCHEMA_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.sauces.SaucesApiConstants.SAUCE_SCHEMA_NAME;
import static org.sylrsykssoft.springboot.common.app.boot.configuration.CommonAppBootConstants.COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE;

import lombok.experimental.UtilityClass;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class MealBuilderConfigurationConstants {

	// DATASOURCE //
	public static final String MEAL_BUILDER_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE_DRINKS = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE
			+ "." + DRINK_SCHEMA_NAME;
	public static final String MEAL_BUILDER_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE_MEALS = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE
			+ "." + MEAL_SCHEMA_NAME;
	public static final String MEAL_BUILDER_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE_SAUCES = COMMON_APP_BOOT_CONFIGURATION_PROPERTIES_DATASOURCE
			+ "." + SAUCE_SCHEMA_NAME;

}
