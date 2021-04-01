/**
 * DrinkMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections4.MapUtils;
import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDrink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.StartEndDateModel;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * DrinkMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class DrinkMapperConverter implements Converter<DrinkDTO, Drink> {

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
	public Drink convert(@NotNull @Valid final DrinkDTO source) {
		final NameModel name = commonModelMapper.map(source.getName(), NameModel.class);
		final DescriptionModel description = commonModelMapper.map(source.getDescription(), DescriptionModel.class);

		final FoodSizeData size = embeddableModelMapper.map(source.getSize(), FoodSizeData.class);
		final PriceData price = embeddableModelMapper.map(source.getPrice(), PriceData.class);
		final StartEndDateModel drinkStartEndDateData = commonModelMapper.map(source.getDrinkStartEndDateData(),
				StartEndDateModel.class);

		final Map<LocalizedFieldNameModel, LocalizedDrink> localizationsData = new HashMap<>();
		if (MapUtils.isNotEmpty(source.getLocalizationsData())) {
			source.getLocalizationsData()
					.forEach((key, value) -> localizationsData.put(
							commonModelMapper.map(key, LocalizedFieldNameModel.class),
							localizedDataModelMapper.map(value, LocalizedDrink.class)));
		}

		final AuditModel drinkCreationData = (source.getDrinkCreationData() != null)
				? commonModelMapper.map(source.getDrinkCreationData(), AuditModel.class)
				: AuditModel.builder().build();

		return Drink.builder().id(source.getId()).name(name).description(description).type(source.getType()).size(size)
				.price(price).drinkStartEndDateData(drinkStartEndDateData).localizationsData(localizationsData)
				.drinkCreationData(drinkCreationData).build();
	}

}
