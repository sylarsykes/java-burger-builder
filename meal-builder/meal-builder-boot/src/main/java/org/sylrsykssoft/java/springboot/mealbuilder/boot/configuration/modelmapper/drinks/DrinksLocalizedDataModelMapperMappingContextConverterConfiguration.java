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
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedDrinkDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedDrinkDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedDrinkMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedDrinkMappingContextConverter;

/**
 * DrinksLocalizedDataModelMapperMappingContextConverterConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class DrinksLocalizedDataModelMapperMappingContextConverterConfiguration {

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

}
