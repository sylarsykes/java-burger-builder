/**
 * DrinkMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * DrinkMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class DrinkMappingContextConverter implements Converter<DrinkDTO, Drink> {

	@NonNull
	private DrinkMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public Drink convert(@NotNull final MappingContext<DrinkDTO, Drink> context) {
		return converter.convert(context.getSource());
	}

}
