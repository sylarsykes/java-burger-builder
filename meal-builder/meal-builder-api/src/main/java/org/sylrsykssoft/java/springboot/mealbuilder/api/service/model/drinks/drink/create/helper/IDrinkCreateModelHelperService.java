/**
 * IDrinkCreateModelHelperService.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.helper;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkModelDTO;
import org.sylrsykssoft.springboot.common.api.service.model.create.helper.CreateModelHelperService;

/**
 * IDrinkCreateModelHelperService
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IDrinkCreateModelHelperService extends CreateModelHelperService<CreateDrinkModelDTO, DrinkDTO, Drink, Long> {

}
