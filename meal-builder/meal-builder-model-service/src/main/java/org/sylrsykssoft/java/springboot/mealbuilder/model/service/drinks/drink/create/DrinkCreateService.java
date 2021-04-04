/**
 * DrinkCreateService.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.model.service.drinks.drink.create;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_DRINKS_MODEL_MAPPER_BEAN_NAME;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.IDrinkCreateModelService;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkLocalizationDataModelDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.DrinkRepository;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Slf4j
@Validated
@Service("drinkCreateServiceImpl")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DrinkCreateService implements IDrinkCreateModelService {

	private static final String LOG_CLASS_NAME = DrinkCreateService.class.getSimpleName() + ".";
	
	private static final String LOG_METHOD_SAVE = LOG_CLASS_NAME + "save - Create a new Drink - ";
	private static final String LOG_METHOD_INSERT_LOCALIZED_DATA = LOG_CLASS_NAME + "insertLocalizationData - Create a new LocalizedDrink - ";
	
	@Autowired
	DrinkRepository drinkRepository;

	@Autowired
	@Qualifier(API_MODELMAPPER_MODEL_DRINKS_MODEL_MAPPER_BEAN_NAME)
	ModelMapper mapper;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DrinkRepository getRepository() {
		return drinkRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SneakyThrows(NullPointerException.class)
	public DrinkDTO mapperToModel(@NonNull @Valid final Drink source) {
		return mapper.map(source, DrinkDTO.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SneakyThrows(NullPointerException.class)
	public Drink mapperToEntity(@NonNull @Valid final DrinkDTO source) {
		return mapper.map(source, Drink.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@SneakyThrows({ NullPointerException.class, IllegalArgumentException.class })
	public DrinkDTO save(@NonNull @NotNull @Valid final DrinkDTO dto) {
		LOGGER.info("{} dto {}", LOG_METHOD_SAVE, dto);
		
		final Drink resultEntity = getRepository().save(mapperToEntity(dto));
		
		LOGGER.info("{} result {}", LOG_METHOD_SAVE, resultEntity);
		
		return mapperToModel(resultEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@SneakyThrows({ NullPointerException.class, IllegalArgumentException.class })
	public int insertLocalizationData(@NonNull @NotNull @Valid final CreateDrinkLocalizationDataModelDTO localizedData) {
		LOGGER.info("{} dto {}", LOG_METHOD_INSERT_LOCALIZED_DATA, localizedData);
		
		return getRepository().insertLocalizationData(localizedData);
	}

}
