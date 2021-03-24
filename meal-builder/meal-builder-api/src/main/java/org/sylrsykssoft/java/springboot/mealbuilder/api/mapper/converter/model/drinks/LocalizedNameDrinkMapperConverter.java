/**
 * LocalizedNameDrinkMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedNameDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedNameDrink;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedValueModel;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * LocalizedNameDrinkMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class LocalizedNameDrinkMapperConverter implements Converter<LocalizedNameDrinkDTO, LocalizedNameDrink> {

	@NonNull
	ModelMapper commonModelMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public LocalizedNameDrink convert(@NotNull @Valid final LocalizedNameDrinkDTO source) {
		final LocalizedFieldNameModel localizedId = commonModelMapper.map(source.getEmbeddedId(),
				LocalizedFieldNameModel.class);
		final LocalizedValueModel value = commonModelMapper.map(source.getValue(), LocalizedValueModel.class);

		return LocalizedNameDrink.builder().embeddedId(localizedId).value(value).build();
	}
}
