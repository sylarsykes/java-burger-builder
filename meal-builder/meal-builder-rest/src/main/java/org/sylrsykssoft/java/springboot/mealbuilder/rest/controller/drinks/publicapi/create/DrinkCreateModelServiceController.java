/**
 * DrinkCreateModelServiceController.java 26 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.rest.controller.drinks.publicapi.create;

import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.CREATE_MODEL_CONTROLLER_REQUEST_MAPPING;
import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.CREATE_MODEL_CONTROLLER_TAG_DESCRIPTION;
import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.CREATE_MODEL_CONTROLLER_TAG_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.rest.configuration.drinks.DrinkRestControllerConstants.FIND_MODEL_CONTROLLER_TAG_NAME;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkModelDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.helper.IDrinkCreateModelHelperService;
import org.sylrsykssoft.springboot.common.api.rest.model.create.IRestCreateModelController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * DrinkCreateModelServiceController
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Slf4j
@Validated
@RestController
@RequestMapping(path = CREATE_MODEL_CONTROLLER_REQUEST_MAPPING)
@Tag(name = CREATE_MODEL_CONTROLLER_TAG_NAME, description = CREATE_MODEL_CONTROLLER_TAG_DESCRIPTION)
public class DrinkCreateModelServiceController implements IRestCreateModelController<CreateDrinkModelDTO, DrinkDTO, Drink, Long> {
	
	private static final String LOG_CLASS_NAME = DrinkCreateModelServiceController.class.getSimpleName() + ".";
	
	private static final String LOG_METHOD_SAVE = LOG_CLASS_NAME + "save - Create a new Drink - ";
	
	@Autowired
	@Qualifier("drinkCreateHelperServiceImpl")
	IDrinkCreateModelHelperService createModelService;
	
	@Override
	public IDrinkCreateModelHelperService getHelperModelService() {
		return createModelService;
	}

	@PostMapping
	@ResponseBody
	@Operation(summary = "Create new Drink.", tags = FIND_MODEL_CONTROLLER_TAG_NAME, responses = {
			@ApiResponse(responseCode = "200", description = "DrinkDTO object"),
			@ApiResponse(responseCode = "400", description = "Illegal argument"),
			@ApiResponse(responseCode = "500", description = "InternalServerError") })
	public @Valid DrinkDTO create(@NonNull @NotNull @Valid @RequestBody final CreateDrinkModelDTO source) {
		LOGGER.info("{} dto {}", LOG_METHOD_SAVE, source);
		
		final DrinkDTO result = getHelperModelService().save(source);
		
		LOGGER.info("{} result {}", LOG_METHOD_SAVE, result);
		
		return result;
	}

}
