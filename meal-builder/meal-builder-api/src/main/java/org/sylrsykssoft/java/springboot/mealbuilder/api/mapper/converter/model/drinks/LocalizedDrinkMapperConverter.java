/**
 * LocalizedDrinkMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDrink;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedValueModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * LocalizedDrinkDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class LocalizedDrinkMapperConverter implements Converter<LocalizedDrinkDTO, LocalizedDrink> {

	@NonNull
	private ModelMapper commonModelMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public LocalizedDrink convert(@NotNull @Valid final LocalizedDrinkDTO source) {
		final LocalizedFieldNameModel localizedId = commonModelMapper.map(source.getEmbeddedId(),
				LocalizedFieldNameModel.class);
		final LocalizedValueModel value = commonModelMapper.map(source.getValue(), LocalizedValueModel.class);

		return LocalizedDrink.builder().embeddedId(localizedId).value(value).build();
	}
}
