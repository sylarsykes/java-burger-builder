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
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.FoodSizeDataMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.PriceDataMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDrink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * DrinkMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public class DrinkMapperConverter implements Converter<DrinkDTO, Drink> {

	@NonNull
	private ModelMapper commonModelMapper;

	@NonNull
	private FoodSizeDataMapperConverter foodSizeDataDTOConverter;

	@NonNull
	private PriceDataMapperConverter priceDataDTOConverter;

	@NonNull
	private LocalizedDrinkMapperConverter localizedDrinDTOkConverter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public Drink convert(@NotNull @Valid final DrinkDTO source) {
		final NameModel name = commonModelMapper.map(source.getName(), NameModel.class);
		final DescriptionModel description = (source.getDescription() != null)
				? commonModelMapper.map(source.getDescription(), DescriptionModel.class)
				: null;

		final FoodSizeData size = foodSizeDataDTOConverter.convert(source.getSize());
		final PriceData price = priceDataDTOConverter.convert(source.getPrice());

		final Map<String, LocalizedDrink> localizations = new HashMap<>();
		if (MapUtils.isNotEmpty(source.getLocalizations())) {
			source.getLocalizations()
					.forEach((key, value) -> localizations.put(key, localizedDrinDTOkConverter.convert(value)));
		}

		final AuditModel drinkCreationData = commonModelMapper.map(source.getDrinkCreationData(), AuditModel.class);

		return Drink.builder().id(source.getId()).name(name).description(description).type(source.getType()).size(size)
				.price(price).localizations(localizations).drinkCreationData(drinkCreationData).build();
	}

}
