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
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;

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
		final LocalizedModel localizedId = commonModelMapper.map(source.getEmbeddedId(), LocalizedModel.class);
		final NameModel localizedName = commonModelMapper.map(source.getName(), NameModel.class);
		final DescriptionModel localizedDescription = (source.getDescription() != null)
				? commonModelMapper.map(source.getDescription(), DescriptionModel.class)
				: null;

		return LocalizedDrink.builder().embeddedId(localizedId).name(localizedName).description(localizedDescription)
				.build();
	}
}
