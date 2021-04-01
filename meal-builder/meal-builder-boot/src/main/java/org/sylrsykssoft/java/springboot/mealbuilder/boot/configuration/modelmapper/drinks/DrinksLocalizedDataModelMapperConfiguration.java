/**
 * ModelMapperConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_DRINKS_LOCALIZED_MODEL_MAPPER_BEAN_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.MealBuilderConfigurationConstants.MEAL_BUILDER_APP_BOOT_CONFIGURATION_MODEL_MAPPER_MEAL_BUILDER_DRINKS_LOCALIZED_DATA_PROPERTIES;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.LocalizedDrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.LocalizedDrinkDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.LocalizedDrinkMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.LocalizedDrink;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.modelmapper.ModelMapperPropertiesConfiguration;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@ComponentScan(basePackageClasses = DrinksLocalizedDataModelMapperMappingContextConverterConfiguration.class)
public class DrinksLocalizedDataModelMapperConfiguration {

	@Bean
	@ConfigurationProperties(prefix = MEAL_BUILDER_APP_BOOT_CONFIGURATION_MODEL_MAPPER_MEAL_BUILDER_DRINKS_LOCALIZED_DATA_PROPERTIES)
	public ModelMapperPropertiesConfiguration mealBuilderDrinksLocalizedDataModelMapperConfigurationProperties() {
		return new ModelMapperPropertiesConfiguration();
	}

	/**
	 * Model mapper bean
	 * 
	 * @return ModelMapper
	 */
	@SuppressWarnings("squid:S107")
	@Bean(API_MODELMAPPER_MODEL_DRINKS_LOCALIZED_MODEL_MAPPER_BEAN_NAME)
	public ModelMapper mealBuilderDrinksLocalizedDataModelMapper(
			@Qualifier("localizedDrinkDTOMappingContextConverter") @NotNull final LocalizedDrinkDTOMappingContextConverter localizedDrinkDTOMappingContextConverter,
			@Qualifier("localizedDrinkMappingContextConverter") @NotNull final LocalizedDrinkMappingContextConverter localizedDrinkMappingContextConverter) {
		final ModelMapper mapper = new ModelMapper();

		// DTO converters
		mapper.addConverter(localizedDrinkDTOMappingContextConverter, LocalizedDrink.class, LocalizedDrinkDTO.class);

		// Model converters
		mapper.addConverter(localizedDrinkMappingContextConverter, LocalizedDrinkDTO.class, LocalizedDrink.class);

		return mapper;
	}
}
