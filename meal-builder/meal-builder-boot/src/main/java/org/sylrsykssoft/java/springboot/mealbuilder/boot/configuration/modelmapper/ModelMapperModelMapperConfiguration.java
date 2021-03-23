/**
 * ModelMapperModelMapperConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.DrinkDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.DrinkDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedDrinkDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedDrinkDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.FoodSizeDataDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.FoodSizeDataDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.PriceDataDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.PriceDataDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.DrinkMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.DrinkMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedDrinkMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedDrinkMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.FoodSizeDataMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.FoodSizeDataMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.PriceDataMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.PriceDataMappingContextConverter;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class ModelMapperModelMapperConfiguration {

	@Bean
	public FoodSizeDataDTOMapperConverter foodSizeDataDTOMapperConverter() {
		return new FoodSizeDataDTOMapperConverter();
	}
	
	@Bean
	public FoodSizeDataDTOMappingContextConverter foodSizeDataDTOMappingContextConverter(
			@Qualifier("foodSizeDataDTOMapperConverter") @NotNull final FoodSizeDataDTOMapperConverter foodSizeDataDTOMapperConverter) {
		return new FoodSizeDataDTOMappingContextConverter(foodSizeDataDTOMapperConverter);
	}

	@Bean
	public FoodSizeDataMapperConverter foodSizeDataMapperConverter() {
		return new FoodSizeDataMapperConverter();
	}

	@Bean
	public FoodSizeDataMappingContextConverter foodSizeDataMappingContextConverter(
			@Qualifier("foodSizeDataMapperConverter") @NotNull final FoodSizeDataMapperConverter foodSizeDataMapperConverter) {
		return new FoodSizeDataMappingContextConverter(foodSizeDataMapperConverter);
	}

	@Bean
	public PriceDataDTOMapperConverter priceDataDTOMapperConverter() {
		return new PriceDataDTOMapperConverter();
	}
	
	@Bean
	public PriceDataDTOMappingContextConverter priceDataDTOMappingContextConverter(
			@Qualifier("priceDataDTOMapperConverter") @NotNull final PriceDataDTOMapperConverter priceDataDTOMapperConverter) {
		return new PriceDataDTOMappingContextConverter(priceDataDTOMapperConverter);
	}

	@Bean
	public PriceDataMapperConverter priceDataMapperConverter() {
		return new PriceDataMapperConverter();
	}
	
	@Bean
	public PriceDataMappingContextConverter priceDataMappingContextConverter(
			@Qualifier("priceDataMapperConverter") @NotNull final PriceDataMapperConverter priceDataMapperConverter) {
		return new PriceDataMappingContextConverter(priceDataMapperConverter);
	}

	@Bean
	public LocalizedDrinkDTOMapperConverter localizedDrinkDTOMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper) {
		return new LocalizedDrinkDTOMapperConverter(commonModelMapper);
	}

	@Bean
	public LocalizedDrinkDTOMappingContextConverter localizedDrinkDTOMappingContextConverter(
			@Qualifier("localizedDrinkDTOMapperConverter") @NotNull final LocalizedDrinkDTOMapperConverter localizedDrinkDTOMapperConverter) {
		return new LocalizedDrinkDTOMappingContextConverter(localizedDrinkDTOMapperConverter);
	}

	@Bean
	public LocalizedDrinkMapperConverter localizedDrinkMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper) {
		return new LocalizedDrinkMapperConverter(commonModelMapper);
	}

	@Bean
	public LocalizedDrinkMappingContextConverter localizedDrinkMappingContextConverter(
			@Qualifier("localizedDrinkMapperConverter") @NotNull final LocalizedDrinkMapperConverter localizedDrinkMapperConverter) {
		return new LocalizedDrinkMappingContextConverter(localizedDrinkMapperConverter);
	}

	@Bean
	public DrinkDTOMapperConverter drinkDTOMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper,
			@Qualifier("foodSizeDataDTOMapperConverter") @NotNull final FoodSizeDataDTOMapperConverter foodSizeDataDTOMapperConverter,
			@Qualifier("priceDataDTOMapperConverter") @NotNull final PriceDataDTOMapperConverter priceDataDTOMapperConverter,
			@Qualifier("localizedDrinkDTOMapperConverter") @NotNull final LocalizedDrinkDTOMapperConverter localizedDrinkDTOMapperConverter) {
		return new DrinkDTOMapperConverter(commonModelMapper, foodSizeDataDTOMapperConverter,
				priceDataDTOMapperConverter, localizedDrinkDTOMapperConverter);
	}

	@Bean
	public DrinkDTOMappingContextConverter drinkDTOMappingContextConverter(
			@Qualifier("drinkDTOMapperConverter") @NotNull final DrinkDTOMapperConverter drinkDTOMapperConverter) {
		return new DrinkDTOMappingContextConverter(drinkDTOMapperConverter);
	}

	@Bean
	public DrinkMapperConverter drinkMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper,
			@Qualifier("foodSizeDataMapperConverter") @NotNull final FoodSizeDataMapperConverter foodSizeDataMapperConverter,
			@Qualifier("priceDataMapperConverter") @NotNull final PriceDataMapperConverter priceDataMapperConverter,
			@Qualifier("localizedDrinkMapperConverter") @NotNull final LocalizedDrinkMapperConverter localizedDrinkMapperConverter) {
		return new DrinkMapperConverter(commonModelMapper, foodSizeDataMapperConverter, priceDataMapperConverter,
				localizedDrinkMapperConverter);
	}

	@Bean
	public DrinkMappingContextConverter drinkMappingContextConverter(
			@Qualifier("drinkMapperConverter") @NotNull final DrinkMapperConverter drinkMapperConverter) {
		return new DrinkMappingContextConverter(drinkMapperConverter);
	}
}
