/**
 * ModelMapperConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_MODEL_MAPPER_BEAN_NAME;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.DrinkDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.DrinkDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedDrinkDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.FoodSizeDataDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.PriceDataDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.DrinkMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.DrinkMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedDrinkMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.FoodSizeDataMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.PriceDataMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class ModelMapperConfiguration {

	@Bean
	public FoodSizeDataDTOMapperConverter foodSizeDataDTOMapperConverter() {
		return new FoodSizeDataDTOMapperConverter();
	}

	@Bean
	public FoodSizeDataMapperConverter foodSizeDataMapperConverter() {
		return new FoodSizeDataMapperConverter();
	}

	@Bean
	public PriceDataDTOMapperConverter priceDataDTOMapperConverter() {
		return new PriceDataDTOMapperConverter();
	}

	@Bean
	public PriceDataMapperConverter priceDataMapperConverter() {
		return new PriceDataMapperConverter();
	}

	@Bean
	public LocalizedDrinkDTOMapperConverter localizedDrinkDTOMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper) {
		return new LocalizedDrinkDTOMapperConverter(commonModelMapper);
	}

	@Bean
	public LocalizedDrinkMapperConverter localizedDrinkMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper) {
		return new LocalizedDrinkMapperConverter(commonModelMapper);
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

	/**
	 * Model mapper bean
	 * 
	 * @return ModelMapper
	 */
	@Bean(API_MODELMAPPER_MODEL_MODEL_MAPPER_BEAN_NAME)
	public ModelMapper mealBuilderModelMapper(
			@Qualifier("drinkDTOMappingContextConverter") @NotNull final DrinkDTOMappingContextConverter drinkDTOMappingContextConverter,
			@Qualifier("drinkMappingContextConverter") @NotNull final DrinkMappingContextConverter drinkMappingContextConverter) {
		final ModelMapper mapper = new ModelMapper();

		// DTO converters
		mapper.addConverter(drinkDTOMappingContextConverter, Drink.class, DrinkDTO.class);

		// Model converters
		mapper.addConverter(drinkMappingContextConverter, DrinkDTO.class, Drink.class);

		return mapper;
	}

}
