/**
 * DrinkMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections4.MapUtils;
import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.FoodSizeDataDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.PriceDataDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * DrinkDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class DrinkDTOMapperConverter implements Converter<Drink, DrinkDTO> {

	@NonNull
	private ModelMapper commonModelMapper;

	@NonNull
	private FoodSizeDataDTOMapperConverter foodSizeDataDTOConverter;

	@NonNull
	private PriceDataDTOMapperConverter priceDataDTOConverter;
	
	@NonNull
	private LocalizedDrinkDTOMapperConverter localizedDrinDTOkConverter;

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public DrinkDTO convert(@NotNull @Valid final Drink source) {
		final NameModelDTO name = commonModelMapper.map(source.getName(), NameModelDTO.class);
		final DescriptionModelDTO description = (source.getDescription() != null)
				? commonModelMapper.map(source.getDescription(), DescriptionModelDTO.class)
				: null;

		final FoodSizeDataDTO size = foodSizeDataDTOConverter.convert(source.getSize());
		final PriceDataDTO price = priceDataDTOConverter.convert(source.getPrice());

		final Map<String, LocalizedDrinkDTO> localizations = new HashMap<>();
		if (MapUtils.isNotEmpty(source.getLocalizations())) {
			source.getLocalizations().forEach((key, value) -> {
				localizations.put(key, localizedDrinDTOkConverter.convert(value));
			});
		}

		final AuditModelDTO drinkCreationData = commonModelMapper.map(source.getDrinkCreationData(),
				AuditModelDTO.class);

		return DrinkDTO.builder().id(source.getId()).name(name).description(description).type(source.getType())
				.size(size).price(price).localizations(localizations).drinkCreationData(drinkCreationData).build();
	}
}
