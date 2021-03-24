/**
 * LocalizedNameDrinkMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedNameDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedNameDrink;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * LocalizedNameDrinkMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class LocalizedNameDrinkMappingContextConverter
		implements Converter<LocalizedNameDrinkDTO, LocalizedNameDrink> {

	@NonNull
	LocalizedNameDrinkMapperConverter converter;

	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedNameDrink convert(
			@NotNull final MappingContext<LocalizedNameDrinkDTO, LocalizedNameDrink> context) {
		return converter.convert(context.getSource());
	}
}
