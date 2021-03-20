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
import org.springframework.stereotype.Component;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDrink;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedModel;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Component
public class DrinkMapperConverter implements Converter<DrinkDTO, Drink> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public Drink convert(@NotNull @Valid final DrinkDTO source) {

		final NameModel name = NameModel.builder().name(source.getName().getName()).build();
		final DescriptionModel description = (source.getDescription() != null)
				? DescriptionModel.builder().description(source.getDescription().getDescription()).build()
				: null;

		final FoodSizeData size = FoodSizeData.builder().size(source.getSize().getSize()).build();
		final PriceData price = PriceData.builder().price(source.getPrice().getPrice()).build();

		final Map<String, LocalizedDrink> localizations = new HashMap<>();
		if (MapUtils.isNotEmpty(source.getLocalizations())) {
			source.getLocalizations().forEach((key, value) -> {

				final LocalizedModel localizedId = LocalizedModel.builder().id(value.getEmbeddedId().getId())
						.locale(value.getEmbeddedId().getLocale()).build();
				final NameModel localizedName = NameModel.builder().name(value.getName().getName()).build();
				final DescriptionModel localizedDescription = DescriptionModel.builder()
						.description(value.getDescription().getDescription()).build();

				final LocalizedDrink localizedData = LocalizedDrink.builder().embeddedId(localizedId)
						.name(localizedName).description(localizedDescription).build();

				localizations.put(key, localizedData);
			});
		}

		final AuditModel drinkCreationData = AuditModel.builder()
				.createdBy(source.getDrinkCreationData().getCreatedBy())
				.createdDate(source.getDrinkCreationData().getCreatedDate())
				.lastModifiedBy(source.getDrinkCreationData().getLastModifiedBy())
				.lastModifiedDate(source.getDrinkCreationData().getLastModifiedDate()).build();

		return Drink.builder().id(source.getId()).name(name).description(description).type(source.getType())
				.size(size).price(price).localizations(localizations).drinkCreationData(drinkCreationData).build();
	}

}
