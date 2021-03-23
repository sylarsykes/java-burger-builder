/**
 * LocalizedDrinkDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDrink;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * LocalizedDrinkDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class LocalizedDrinkDTOMappingContextConverter implements Converter<LocalizedDrink, LocalizedDrinkDTO> {

	@NonNull
	private LocalizedDrinkDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedDrinkDTO convert(@NotNull final MappingContext<LocalizedDrink, LocalizedDrinkDTO> context) {
		return converter.convert(context.getSource());
	}

}
