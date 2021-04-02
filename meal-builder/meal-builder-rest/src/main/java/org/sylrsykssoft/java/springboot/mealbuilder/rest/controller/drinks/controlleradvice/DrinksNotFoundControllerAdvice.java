/**
 * DrinksNotFoundControllerAdvice.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.rest.controller.drinks.controlleradvice;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.sylrsykssoft.java.springboot.mealbuilder.rest.controller.drinks.publicapi.create.DrinkCreateModelServiceController;
import org.sylrsykssoft.java.springboot.mealbuilder.rest.controller.drinks.publicapi.find.DrinkFindModelServiceController;
import org.sylrsykssoft.springboot.common.api.dto.error.ErrorTO;

/**
 * RestController advice
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RestControllerAdvice(assignableTypes = { DrinkFindModelServiceController.class,
		DrinkCreateModelServiceController.class })
public class DrinksNotFoundControllerAdvice {

	@ResponseBody
	@ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorTO drinkIllegalArgumentHandler(final RuntimeException e) {
		return ErrorTO.builder().build().toBuilder().createBy(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e)
				.build();
	}

	@ResponseBody
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorTO drinkNotFoundHandler(final EntityNotFoundException enfe) {
		return ErrorTO.builder().build().toBuilder().createBy(HttpStatus.NOT_FOUND.value(), enfe.getMessage(), enfe)
				.build();
	}

}
