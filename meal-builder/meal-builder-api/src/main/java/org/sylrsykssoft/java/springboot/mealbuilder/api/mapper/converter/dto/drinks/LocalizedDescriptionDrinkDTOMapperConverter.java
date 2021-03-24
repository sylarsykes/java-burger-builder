/**
 * LocalizedDescriptionDrinkDTOMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDescriptionDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDescriptionDrink;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedValueModelDTO;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * LocalizedDescriptionDrinkDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class LocalizedDescriptionDrinkDTOMapperConverter
		implements Converter<LocalizedDescriptionDrink, LocalizedDescriptionDrinkDTO> {

	@NonNull
	ModelMapper commonModelMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public LocalizedDescriptionDrinkDTO convert(@NotNull @Valid final LocalizedDescriptionDrink source) {
		final LocalizedFieldNameModelDTO localizedId = commonModelMapper.map(source.getEmbeddedId(),
				LocalizedFieldNameModelDTO.class);
		final LocalizedValueModelDTO value = commonModelMapper.map(source.getValue(), LocalizedValueModelDTO.class);

		return LocalizedDescriptionDrinkDTO.builder().embeddedId(localizedId).value(value).build();
	}
}
