/**
 * DrinksCUDControllerAdvice.java 5 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.rest.controller.drinks.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.sylrsykssoft.springboot.common.api.dto.error.ErrorTO;

/**
 * RestController advice
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RestControllerAdvice
public class DrinksCUDControllerAdvice {

	@ResponseBody
	@ExceptionHandler({  MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorTO drinkIllegalArgumentHandler(final BindException e) {
		return ErrorTO.builder().build().toBuilder()
				.createBy(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e).build();
	}
	
}
