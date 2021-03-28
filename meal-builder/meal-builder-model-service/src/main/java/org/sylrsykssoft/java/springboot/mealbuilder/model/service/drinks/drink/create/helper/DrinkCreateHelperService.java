/**
 * DrinkCreateHelperService.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.model.service.drinks.drink.create.helper;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_DRINKS_CRUD_MODEL_MAPPER_BEAN_NAME;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.IDrinkCreateModelService;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkModelDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.helper.IDrinkCreateModelHelperService;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * DrinkCreateHelperService
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Slf4j
@Validated
@Service("drinkCreateHelperServiceImpl")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DrinkCreateHelperService implements IDrinkCreateModelHelperService {

	private static final String LOG_CLASS_NAME = DrinkCreateHelperService.class.getSimpleName() + ".";
	
	private static final String LOG_METHOD_SAVE = LOG_CLASS_NAME + "save - Create a new Drink - ";
	
	@Autowired
	@Qualifier("drinkCreateServiceImpl")
	IDrinkCreateModelService createModelService;
	
	@Autowired
	@Qualifier(API_MODELMAPPER_MODEL_DRINKS_CRUD_MODEL_MAPPER_BEAN_NAME)
	ModelMapper mapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IDrinkCreateModelService getModelService() {
		return createModelService;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DrinkDTO mapperToModel(@Valid final CreateDrinkModelDTO source) {
		return mapper.map(source, DrinkDTO.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DrinkDTO save(@NonNull @NotNull @Valid final CreateDrinkModelDTO dto) {
		LOGGER.info("{} dto {}", LOG_METHOD_SAVE, dto);
		
		final DrinkDTO result = getModelService().save(mapperToModel(dto));
		
		LOGGER.info("{} result {}", LOG_METHOD_SAVE, result);
		
		return result;
	}


}
