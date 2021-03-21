/**
 * LocalizedDrinkMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDrink;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * LocalizedDrinkDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class LocalizedDrinkDTOMapperConverter implements Converter<LocalizedDrink, LocalizedDrinkDTO> {

	@NonNull
	private ModelMapper commonModelMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public LocalizedDrinkDTO convert(@NotNull @Valid final LocalizedDrink source) {
		final LocalizedModelDTO localizedId = commonModelMapper.map(source.getEmbeddedId(), LocalizedModelDTO.class);
		final NameModelDTO localizedName = commonModelMapper.map(source.getName(), NameModelDTO.class);
		final DescriptionModelDTO localizedDescription = (source.getDescription() != null)
				? commonModelMapper.map(source.getDescription(), DescriptionModelDTO.class)
				: null;

		return LocalizedDrinkDTO.builder().embeddedId(localizedId).name(localizedName).description(localizedDescription)
				.build();
	}
}
