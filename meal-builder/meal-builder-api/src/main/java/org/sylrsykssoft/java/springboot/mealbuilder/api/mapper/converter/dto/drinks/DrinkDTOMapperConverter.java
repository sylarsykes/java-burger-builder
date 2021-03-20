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
import org.springframework.stereotype.Component;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedModelDTO;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Component
public class DrinkDTOMapperConverter implements Converter<Drink, DrinkDTO> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public DrinkDTO convert(@NotNull @Valid final Drink source) {

		final NameModelDTO name = NameModelDTO.builder().name(source.getName().getName()).build();
		final DescriptionModelDTO description = (source.getDescription() != null)
				? DescriptionModelDTO.builder().description(source.getDescription().getDescription()).build()
				: null;

		final FoodSizeDataDTO size = FoodSizeDataDTO.builder().size(source.getSize().getSize()).build();
		final PriceDataDTO price = PriceDataDTO.builder().price(source.getPrice().getPrice()).build();

		final Map<String, LocalizedDrinkDTO> localizations = new HashMap<>();
		if (MapUtils.isNotEmpty(source.getLocalizations())) {
			source.getLocalizations().forEach((key, value) -> {
				final LocalizedModelDTO localizedId = LocalizedModelDTO.builder().id(value.getEmbeddedId().getId())
						.locale(value.getEmbeddedId().getLocale()).build();
				final NameModelDTO localizedName = NameModelDTO.builder().name(value.getName().getName()).build();
				final DescriptionModelDTO localizedDescription = (value.getDescription() != null) ? DescriptionModelDTO.builder()
						.description(value.getDescription().getDescription()).build() : null;
				
				final LocalizedDrinkDTO localizedData = LocalizedDrinkDTO.builder().embeddedId(localizedId)
						.name(localizedName).description(localizedDescription).build();

				localizations.put(key, localizedData);
			});
		}

		final AuditModelDTO drinkCreationData = AuditModelDTO.builder()
				.createdBy(source.getDrinkCreationData().getCreatedBy())
				.createdDate(source.getDrinkCreationData().getCreatedDate())
				.lastModifiedBy(source.getDrinkCreationData().getLastModifiedBy())
				.lastModifiedDate(source.getDrinkCreationData().getLastModifiedDate()).build();

		return DrinkDTO.builder().id(source.getId()).name(name).description(description).type(source.getType())
				.size(size).price(price).localizations(localizations).drinkCreationData(drinkCreationData).build();
	}

}
