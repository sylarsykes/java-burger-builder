/**
 * DrinkCreateHelperService.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.model.service.drinks.drink.create.helper;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_DRINKS_CRUD_MODEL_MAPPER_BEAN_NAME;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections4.MapUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.IDrinkCreateModelService;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkLocalizationDataModelDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkModelDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.helper.IDrinkCreateModelHelperService;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.find.IDrinkFindService;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;

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
	@Qualifier("drinkFindServiceImpl")
	IDrinkFindService findByModelService;

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

		final DrinkDTO tempDtoToSave = mapperToModel(dto);
		final Map<LocalizedFieldNameModelDTO, LocalizedDrinkDTO> localizationsData = tempDtoToSave
				.getLocalizationsData();
		final DrinkDTO dtoToSave = tempDtoToSave.toBuilder().localizationsData(new HashMap<>()).build();

		final DrinkDTO savedResult = getModelService().save(dtoToSave);

		if (MapUtils.isNotEmpty(localizationsData)) {
			localizationsData.forEach((key, value) -> {
				final CreateDrinkLocalizationDataModelDTO localizedData = CreateDrinkLocalizationDataModelDTO.builder()
						.id(savedResult.getId()).embeddedId(value.getEmbeddedId()).value(value.getValue()).build();
				getModelService().insertLocalizationData(localizedData);
			});
		}

		final DrinkDTO result = findByModelService.findByName(savedResult.getName().getName(), Locale.UK);

		LOGGER.info("{} result {}", LOG_METHOD_SAVE, result);

		return result;
	}

}
