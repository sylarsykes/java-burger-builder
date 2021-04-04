/**
 * IDrinkCreateModelService.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkLocalizationDataModelDTO;
import org.sylrsykssoft.springboot.common.api.service.model.create.CreateModelService;

import lombok.NonNull;

/**
 * IDrinkCreateModelService
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IDrinkCreateModelService extends CreateModelService<DrinkDTO, Drink, Long> {

	/**
	 * Insert drink localized data
	 * @param localizedData Localized data
	 * @return int
	 */
	int insertLocalizationData(@NonNull @NotNull @Valid CreateDrinkLocalizationDataModelDTO localizedData);
	
}
