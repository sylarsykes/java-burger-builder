/**
 * ModelMapperConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper.drinks;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_DRINKS_MODEL_MAPPER_BEAN_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.MealBuilderConfigurationConstants.MEAL_BUILDER_APP_BOOT_CONFIGURATION_MODEL_MAPPER_MEAL_BUILDER_DRINKS_MODEL_PROPERTIES;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.drinks.DrinkDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.drinks.DrinkMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.drinks.Drink;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.modelmapper.ModelMapperPropertiesConfiguration;

/**
 * DrinksModelMapperConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@ComponentScan(basePackageClasses = DrinksModelMapperMappingContextConverterConfiguration.class)
public class DrinksModelMapperConfiguration {

	@Bean
	@ConfigurationProperties(prefix = MEAL_BUILDER_APP_BOOT_CONFIGURATION_MODEL_MAPPER_MEAL_BUILDER_DRINKS_MODEL_PROPERTIES)
	public ModelMapperPropertiesConfiguration mealBuilderModelMapperConfigurationProperties() {
		return new ModelMapperPropertiesConfiguration();
	}

	/**
	 * Model mapper bean
	 * 
	 * @return ModelMapper
	 */
	@SuppressWarnings("squid:S107")
	@Bean(API_MODELMAPPER_MODEL_DRINKS_MODEL_MAPPER_BEAN_NAME)
	public ModelMapper mealBuilderDrinksModelMapper(
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
