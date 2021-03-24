/**
 * DrinksLocalizedDataModelMapperMappingContextConverterConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedDescriptionDrinkDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedDescriptionDrinkDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedNameDrinkDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedNameDrinkDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedDescriptionDrinkMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedDescriptionDrinkMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedNameDrinkMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedNameDrinkMappingContextConverter;

/**
 * DrinksLocalizedDataModelMapperMappingContextConverterConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class DrinksLocalizedDataModelMapperMappingContextConverterConfiguration {

	@Bean
	public LocalizedNameDrinkDTOMapperConverter drinksLocalizedNameDrinkDTOMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper) {
		return new LocalizedNameDrinkDTOMapperConverter(commonModelMapper);
	}

	@Bean
	public LocalizedNameDrinkDTOMappingContextConverter drinksLocalizedNameDrinkDTOMappingContextConverter(
			@Qualifier("drinksLocalizedNameDrinkDTOMapperConverter") @NotNull final LocalizedNameDrinkDTOMapperConverter localizedDrinkDTOMapperConverter) {
		return new LocalizedNameDrinkDTOMappingContextConverter(localizedDrinkDTOMapperConverter);
	}

	@Bean
	public LocalizedNameDrinkMapperConverter drinksLocalizedNameDrinkMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper) {
		return new LocalizedNameDrinkMapperConverter(commonModelMapper);
	}

	@Bean
	public LocalizedNameDrinkMappingContextConverter drinksLocalizedNameDrinkMappingContextConverter(
			@Qualifier("drinksLocalizedNameDrinkMapperConverter") @NotNull final LocalizedNameDrinkMapperConverter localizedDrinkMapperConverter) {
		return new LocalizedNameDrinkMappingContextConverter(localizedDrinkMapperConverter);
	}

	@Bean
	public LocalizedDescriptionDrinkDTOMapperConverter drinksLocalizedDescriptionDrinkDTOMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper) {
		return new LocalizedDescriptionDrinkDTOMapperConverter(commonModelMapper);
	}

	@Bean
	public LocalizedDescriptionDrinkDTOMappingContextConverter drinksLocalizedDescriptionDrinkDTOMappingContextConverter(
			@Qualifier("drinksLocalizedDescriptionDrinkDTOMapperConverter") @NotNull final LocalizedDescriptionDrinkDTOMapperConverter localizedDrinkDTOMapperConverter) {
		return new LocalizedDescriptionDrinkDTOMappingContextConverter(localizedDrinkDTOMapperConverter);
	}

	@Bean
	public LocalizedDescriptionDrinkMapperConverter drinksLocalizedDescriptionDrinkMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper) {
		return new LocalizedDescriptionDrinkMapperConverter(commonModelMapper);
	}

	@Bean
	public LocalizedDescriptionDrinkMappingContextConverter drinksLocalizedDescriptionDrinkMappingContextConverter(
			@Qualifier("drinksLocalizedDescriptionDrinkMapperConverter") @NotNull final LocalizedDescriptionDrinkMapperConverter localizedDrinkMapperConverter) {
		return new LocalizedDescriptionDrinkMappingContextConverter(localizedDrinkMapperConverter);
	}

}
