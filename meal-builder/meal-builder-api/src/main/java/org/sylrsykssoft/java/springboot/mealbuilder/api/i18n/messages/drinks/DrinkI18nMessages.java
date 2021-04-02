/**
 * DrinkI18nMessages.java 1 abr. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.drinks;

import lombok.experimental.UtilityClass;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@UtilityClass
public class DrinkI18nMessages {

	public static final String DRINK_TYPE_FIELD_VALIDATION_CONSTRAINT_NOTNULL = "org.sylrsykssoft.springboot.mealbuilder.messages.drinks.drink.type.validation.constraints.NotNull";
	public static final String DRINK_TYPE_FIELD_VALIDATION_CONSTRAINT_NOTNULL_MESSAGE = "{" + DRINK_TYPE_FIELD_VALIDATION_CONSTRAINT_NOTNULL + "}";
	
	public static final String DRINK_FIND_SERVICE_FIND_BY_ID_NOTFOUND = "org.sylrsykssoft.springboot.mealbuilder.messages.drinks.DrinkFindService.findById.NotFound";
	public static final String DRINK_FIND_SERVICE_FIND_BY_ID_NOTFOUND_MESSAGE = "{" + DRINK_FIND_SERVICE_FIND_BY_ID_NOTFOUND + "}";
	public static final String DRINK_FIND_SERVICE_FIND_BY_NAME_NOTFOUND = "org.sylrsykssoft.springboot.mealbuilder.messages.drinks.DrinkFindService.findByName.NotFound";
	public static final String DRINK_FIND_SERVICE_FIND_BY_NAME_NOTFOUND_MESSAGE = "{" + DRINK_FIND_SERVICE_FIND_BY_NAME_NOTFOUND + "}";
}
