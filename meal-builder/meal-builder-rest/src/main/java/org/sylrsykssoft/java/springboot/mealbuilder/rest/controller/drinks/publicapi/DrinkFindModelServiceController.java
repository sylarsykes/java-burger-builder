/**
 * DrinkFindModelServiceController.java 4 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.rest.controller.drinks.publicapi;

import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.CONTROLLER_GET_EXISTS_BY_ID;
import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.CONTROLLER_GET_FIND_BY_ID;
import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.CONTROLLER_GET_FIND_BY_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.FIND_MODEL_CONTROLLER_REQUEST_MAPPING;
import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.FIND_MODEL_CONTROLLER_TAG_DESCRIPTION;
import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.FIND_MODEL_CONTROLLER_TAG_NAME;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.drinks.drink.find.IDrinkFindService;
import org.sylrsykssoft.springboot.common.api.rest.IRestModelController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Slf4j
@Validated
@RestController
@RequestMapping(path = FIND_MODEL_CONTROLLER_REQUEST_MAPPING)
@Tag(name = FIND_MODEL_CONTROLLER_TAG_NAME, description = FIND_MODEL_CONTROLLER_TAG_DESCRIPTION)
public class DrinkFindModelServiceController implements IRestModelController<DrinkDTO, Drink, Long> {

	private static final String LOG_CLASS_NAME = DrinkFindModelServiceController.class.getSimpleName() + ".";

	private static final String LOG_METHOD_FIND_BY_ID = LOG_CLASS_NAME + "findById - Retrieves an entity by its id - ";

	private static final String LOG_METHOD_EXISTS_BY_ID = LOG_CLASS_NAME
			+ "existsById - Returns whether an entity with the given id exists - ";

	private static final String LOG_METHOD_FIND_BY_NAME = LOG_CLASS_NAME
			+ "findByName - Retrieves an entity by its name - ";

	@Autowired
	@Qualifier("drinkFindServiceImpl")
	IDrinkFindService findByModelService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IDrinkFindService getModelService() {
		return findByModelService;
	}

	/**
	 * Retrieves an dto by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the entity with the given id.
	 * @throws IllegalArgumentException if {@literal id} is {@literal null}.
	 * @throws EntityNotFoundException  if entity not exists.
	 */
	@GetMapping(CONTROLLER_GET_FIND_BY_ID)
	@ResponseBody
	@Operation(summary = "Retrieves an dto by its id.", tags = FIND_MODEL_CONTROLLER_TAG_NAME, responses = {
			@ApiResponse(responseCode = "200", description = "DrinkDTO object"),
			@ApiResponse(responseCode = "400", description = "Illegal argument"),
			@ApiResponse(responseCode = "404", description = "DrinkDTO not exists") })
	public @Valid DrinkDTO findById(
			@Parameter(name = "id", description = "The id of the drink object", required = true) @PathVariable @NonNull @Positive final Long id) {
		LOGGER.info("{} id {}", LOG_METHOD_FIND_BY_ID, id);

		final DrinkDTO result = getModelService().findById(id);

		LOGGER.info("{} result {}", LOG_METHOD_FIND_BY_ID, result);

		return result;
	}

	/**
	 * Returns whether an dto with the given id exists.
	 *
	 * @param id must not be {@literal null}.
	 * @return {@literal true} if an entity with the given id exists,
	 *         {@literal false} otherwise.
	 * @throws IllegalArgumentException if {@literal id} is {@literal null}.
	 */
	@GetMapping(CONTROLLER_GET_EXISTS_BY_ID)
	@Operation(summary = "Returns whether an dto with the given id exists.", tags = FIND_MODEL_CONTROLLER_TAG_NAME, responses = {
			@ApiResponse(responseCode = "200", description = "DrinkDTO object"),
			@ApiResponse(responseCode = "400", description = "Illegal argument"),
			@ApiResponse(responseCode = "404", description = "DrinkDTO not exists") })
	public boolean existsById(
			@Parameter(name = "id", description = "The id of the drink object", required = true) @PathVariable @NonNull @Positive final Long id) {
		LOGGER.info("{} id {}", LOG_METHOD_EXISTS_BY_ID, id);

		final boolean exists = getModelService().existsById(id);

		LOGGER.info("{} result {}", LOG_METHOD_EXISTS_BY_ID, exists);

		return exists;
	}

	/**
	 * Retrieves an dto by its name.
	 *
	 * @param name must not be {@literal null}.
	 * @return the entity with the given name.
	 * @throws IllegalArgumentException if {@literal name} is {@literal null}.
	 * @throws EntityNotFoundException  if entity not exists.
	 */
	@GetMapping(CONTROLLER_GET_FIND_BY_NAME)
	@ResponseBody
	@Operation(summary = "Retrieves an dto by its name.", tags = FIND_MODEL_CONTROLLER_TAG_NAME, responses = {
			@ApiResponse(responseCode = "200", description = "DrinkDTO object"),
			@ApiResponse(responseCode = "400", description = "Illegal argument"),
			@ApiResponse(responseCode = "404", description = "DrinkDTO not exists") })
	public @Valid DrinkDTO findById(
			@Parameter(name = "name", description = "The name of the drink object", required = true) @PathVariable @NonNull @NotBlank final String name) {
		LOGGER.info("{} name {}", LOG_METHOD_FIND_BY_NAME, name);

		final DrinkDTO result = getModelService().findByName(name);

		LOGGER.info("{} result {}", LOG_METHOD_FIND_BY_NAME, result);

		return result;
	}
	
}
