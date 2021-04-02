/**
 * DrinkFindService.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.model.service.drinks.drink.find;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_DRINKS_MODEL_MAPPER_BEAN_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.drinks.DrinkI18nMessages.DRINK_FIND_SERVICE_FIND_BY_ID_NOTFOUND;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.i18n.messages.drinks.DrinkI18nMessages.DRINK_FIND_SERVICE_FIND_BY_NAME_NOTFOUND;

import java.util.Locale;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.find.IDrinkFindService;
import org.sylrsykssoft.java.springboot.mealbuilder.repository.drinks.DrinkRepository;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * DrinkFindService
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Slf4j
@Validated
@Service("drinkFindServiceImpl")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class DrinkFindService implements IDrinkFindService {

	private static final String LOG_CLASS_NAME = DrinkFindService.class.getSimpleName() + ".";

	private static final String LOG_METHOD_FIND_BY_ID = LOG_CLASS_NAME + "findById - Retrieves an entity by its id - ";

	private static final String LOG_METHOD_EXISTS_BY_ID = LOG_CLASS_NAME
			+ "existsById - Returns whether an entity with the given id exists - ";

	private static final String LOG_METHOD_FIND_BY_NAME = LOG_CLASS_NAME
			+ "findByName - Retrieves an entity by its name - ";

	@Autowired
	DrinkRepository drinkRepository;

	@Autowired
	@Qualifier(API_MODELMAPPER_MODEL_DRINKS_MODEL_MAPPER_BEAN_NAME)
	ModelMapper mapper;

	@Autowired
	MessageSource messageSource;

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
	@SneakyThrows({ NullPointerException.class, IllegalArgumentException.class })
	public DrinkDTO findById(@NonNull @NotNull @Positive final Long id, @NonNull @NotNull final Locale locale)
			throws IllegalArgumentException, EntityNotFoundException {
		LOGGER.info("{} id {} locale {}", LOG_METHOD_FIND_BY_ID, id, locale);

		final Optional<Drink> resultEntity = getRepository().findById(id);

		return mapperToModel(resultEntity.orElseThrow(() -> new EntityNotFoundException(
				messageSource.getMessage(DRINK_FIND_SERVICE_FIND_BY_ID_NOTFOUND, new Object[] { id }, locale))));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SneakyThrows({ NullPointerException.class, IllegalArgumentException.class })
	public boolean existsById(@NonNull @NotNull @Positive final Long id) throws IllegalArgumentException {
		LOGGER.info("{} id {}", LOG_METHOD_EXISTS_BY_ID, id);

		return getRepository().existsById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SneakyThrows({ NullPointerException.class, IllegalArgumentException.class })
	public DrinkDTO findByName(@NonNull @NotBlank final String name, @NonNull @NotNull final Locale locale)
			throws IllegalArgumentException, EntityNotFoundException {
		LOGGER.info("{} name {}", LOG_METHOD_FIND_BY_NAME, name);

		final Optional<Drink> resultEntity = getRepository().findByName(name);

		return mapperToModel(resultEntity.orElseThrow(() -> new EntityNotFoundException(
				messageSource.getMessage(DRINK_FIND_SERVICE_FIND_BY_NAME_NOTFOUND, new Object[] { name }, locale))));
	}

}
