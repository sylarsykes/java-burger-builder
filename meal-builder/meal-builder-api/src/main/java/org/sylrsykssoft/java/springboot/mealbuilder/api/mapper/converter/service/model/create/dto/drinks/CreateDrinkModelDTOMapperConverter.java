/**
 * CreateDrinkModelDTOMapperConverter.java 28 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.service.model.create.dto.drinks;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.FoodSize;
import org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.drinks.DrinkApiConstants.DrinkType;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * CreateDrinkModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class CreateDrinkModelDTOMapperConverter implements Converter<CreateDrinkModelDTO, DrinkDTO> {

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
	public DrinkDTO convert(@NotNull @Valid final CreateDrinkModelDTO source) {
		final NameModelDTO name = commonModelMapper.map(source.getName(), NameModelDTO.class);
		final DescriptionModelDTO description = commonModelMapper.map(source.getDescription(),
				DescriptionModelDTO.class);

		final DrinkType type = DrinkType.valueOf(source.getType());

		final FoodSizeDataDTO size = FoodSizeDataDTO.builder().size(FoodSize.valueOf(source.getSize())).build();

		final Map<LocalizedFieldNameModelDTO, LocalizedDrinkDTO> localizationsData = new HashMap<>();
		if (MapUtils.isNotEmpty(source.getLocalizationsData())) {
			source.getLocalizationsData().forEach((localeKey, values) -> {
				if (CollectionUtils.isNotEmpty(values)) {
					values.forEach(localizedFieldNameModel -> {
						if (localizedFieldNameModel.getEmbeddedId() != null
								&& StringUtils.equals(localeKey, localizedFieldNameModel.getEmbeddedId().getLocale())) {
							final LocalizedFieldNameModelDTO key = commonModelMapper
									.map(localizedFieldNameModel.getEmbeddedId(), LocalizedFieldNameModelDTO.class);
							final LocalizedDrinkDTO value = LocalizedDrinkDTO.builder().embeddedId(key)
									.value(localizedFieldNameModel.getValue()).build();

							localizationsData.put(key, value);
						}
					});
				}
			});
		}

		return DrinkDTO.builder().name(name).description(description).type(type).size(size).price(source.getPrice())
				.drinkStartEndDateData(source.getDrinkStartEndDateData()).localizationsData(localizationsData).build();
	}
}
