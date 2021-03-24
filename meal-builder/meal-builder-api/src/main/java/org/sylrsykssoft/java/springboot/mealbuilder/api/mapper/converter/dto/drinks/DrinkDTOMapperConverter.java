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
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDescriptionDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedNameDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * DrinkDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class DrinkDTOMapperConverter implements Converter<Drink, DrinkDTO> {

	@NonNull
	ModelMapper commonModelMapper;

	@NonNull
	ModelMapper embeddableModelMapper;

	@NonNull
	ModelMapper localizedDataModelMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public DrinkDTO convert(@NotNull @Valid final Drink source) {
		final NameModelDTO name = commonModelMapper.map(source.getName(), NameModelDTO.class);
		final DescriptionModelDTO description = commonModelMapper.map(source.getDescription(),
				DescriptionModelDTO.class);

		final FoodSizeDataDTO size = embeddableModelMapper.map(source.getSize(), FoodSizeDataDTO.class);
		final PriceDataDTO price = embeddableModelMapper.map(source.getPrice(), PriceDataDTO.class);

		final Map<String, LocalizedNameDrinkDTO> localizationsName = new HashMap<>();
		if (MapUtils.isNotEmpty(source.getLocalizationsName())) {
			source.getLocalizationsName().forEach((key, value) -> localizationsName.put(key,
					localizedDataModelMapper.map(value, LocalizedNameDrinkDTO.class)));
		}

		final Map<String, LocalizedDescriptionDrinkDTO> localizationsDescription = new HashMap<>();
		if (MapUtils.isNotEmpty(source.getLocalizationsDescription())) {
			source.getLocalizationsDescription().forEach((key, value) -> localizationsDescription.put(key,
					localizedDataModelMapper.map(value, LocalizedDescriptionDrinkDTO.class)));
		}

		final AuditModelDTO drinkCreationData = commonModelMapper.map(source.getDrinkCreationData(),
				AuditModelDTO.class);

		return DrinkDTO.builder().id(source.getId()).name(name).description(description).type(source.getType())
				.size(size).price(price).localizationsName(localizationsName)
				.localizationsDescription(localizationsDescription).drinkCreationData(drinkCreationData).build();
	}
}
