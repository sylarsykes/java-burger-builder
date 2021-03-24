/**
 * LocalizedDescriptionDrinkMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDescriptionDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDescriptionDrink;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedValueModel;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * LocalizedDescriptionDrinkMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class LocalizedDescriptionDrinkMapperConverter
		implements Converter<LocalizedDescriptionDrinkDTO, LocalizedDescriptionDrink> {

	@NonNull
	ModelMapper commonModelMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public LocalizedDescriptionDrink convert(@NotNull @Valid final LocalizedDescriptionDrinkDTO source) {
		final LocalizedFieldNameModel localizedId = commonModelMapper.map(source.getEmbeddedId(),
				LocalizedFieldNameModel.class);
		final LocalizedValueModel value = commonModelMapper.map(source.getValue(), LocalizedValueModel.class);

		return LocalizedDescriptionDrink.builder().embeddedId(localizedId).value(value).build();
	}
}
