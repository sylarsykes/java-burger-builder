/**
 * IDrinkCreateModelService.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.springboot.common.api.service.model.create.CreateModelService;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IDrinkCreateModelService extends CreateModelService<DrinkDTO, Drink, Long> {

}
