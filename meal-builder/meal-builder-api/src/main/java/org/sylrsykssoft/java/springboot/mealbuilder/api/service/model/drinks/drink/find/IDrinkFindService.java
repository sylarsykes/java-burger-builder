/**
 * IDrinkFindService.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.find;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.springboot.common.api.service.model.find.FindByNameService;

/**
 * IDrinkFindService
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IDrinkFindService extends FindByNameService<DrinkDTO, Drink, Long> {

	
}
