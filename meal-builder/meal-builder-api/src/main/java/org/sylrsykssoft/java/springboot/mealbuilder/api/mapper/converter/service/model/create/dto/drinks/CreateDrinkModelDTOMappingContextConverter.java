/**
 * CreateDrinkModelDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.service.model.create.dto.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkModelDTO;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * CreateDrinkModelDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class CreateDrinkModelDTOMappingContextConverter implements Converter<CreateDrinkModelDTO, DrinkDTO> {

	@NonNull
	CreateDrinkModelDTOMapperConverter converter;

	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public DrinkDTO convert(@NotNull final MappingContext<CreateDrinkModelDTO, DrinkDTO> context) {
		return converter.convert(context.getSource());
	}
}
