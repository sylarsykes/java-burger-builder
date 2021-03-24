/**
 * LocalizedDescriptionDrinkMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDescriptionDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDescriptionDrink;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * LocalizedDescriptionDrinkMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class LocalizedDescriptionDrinkMappingContextConverter
		implements Converter<LocalizedDescriptionDrinkDTO, LocalizedDescriptionDrink> {

	@NonNull
	LocalizedDescriptionDrinkMapperConverter converter;

	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedDescriptionDrink convert(
			@NotNull final MappingContext<LocalizedDescriptionDrinkDTO, LocalizedDescriptionDrink> context) {
		return converter.convert(context.getSource());
	}
}
