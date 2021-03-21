/**
 * DrinkDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * DrinkDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class DrinkDTOMappingContextConverter implements Converter<Drink, DrinkDTO> {

	@NonNull
	private DrinkDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public DrinkDTO convert(@NotNull final MappingContext<Drink, DrinkDTO> context) {
		return converter.convert(context.getSource());
	}

}
