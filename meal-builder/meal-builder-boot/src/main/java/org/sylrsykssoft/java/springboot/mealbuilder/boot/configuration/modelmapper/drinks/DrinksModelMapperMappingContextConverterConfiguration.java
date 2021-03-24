/**
 * ModelMapperMappingContextConverterConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_EMBEDDABLE_MODEL_MODEL_MAPPER_BEAN_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_DRINKS_LOCALIZED_MODEL_MAPPER_BEAN_NAME;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.DrinkDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.DrinkDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.DrinkMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.DrinkMappingContextConverter;

/**
 * ModelMapperMappingContextConverterConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class DrinksModelMapperMappingContextConverterConfiguration {

	@Bean
	public DrinkDTOMapperConverter drinkDTOMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper,
			@Qualifier(API_MODELMAPPER_EMBEDDABLE_MODEL_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper embeddableModelMapper,
			@Qualifier(API_MODELMAPPER_MODEL_DRINKS_LOCALIZED_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper localizedDataModelMapper) {
		return new DrinkDTOMapperConverter(commonModelMapper, embeddableModelMapper, localizedDataModelMapper);
	}

	@Bean
	public DrinkDTOMappingContextConverter drinkDTOMappingContextConverter(
			@Qualifier("drinkDTOMapperConverter") @NotNull final DrinkDTOMapperConverter drinkDTOMapperConverter) {
		return new DrinkDTOMappingContextConverter(drinkDTOMapperConverter);
	}

	@Bean
	public DrinkMapperConverter drinkMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper,
			@Qualifier(API_MODELMAPPER_EMBEDDABLE_MODEL_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper embeddableModelMapper,
			@Qualifier(API_MODELMAPPER_MODEL_DRINKS_LOCALIZED_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper localizedDataModelMapper) {
		return new DrinkMapperConverter(commonModelMapper, embeddableModelMapper, localizedDataModelMapper);
	}

	@Bean
	public DrinkMappingContextConverter drinkMappingContextConverter(
			@Qualifier("drinkMapperConverter") @NotNull final DrinkMapperConverter drinkMapperConverter) {
		return new DrinkMappingContextConverter(drinkMapperConverter);
	}
	
}
