/**
 * ModelMapperConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper.embeddable;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_EMBEDDABLE_MODEL_MODEL_MAPPER_BEAN_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.MealBuilderConfigurationConstants.MEAL_BUILDER_APP_BOOT_CONFIGURATION_MODEL_MAPPER_EMBEDDABLE_PROPERTIES;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.FoodSizeDataDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.PriceDataDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.FoodSizeDataMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.PriceDataMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;
import org.sylrsykssoft.springboot.common.app.boot.configuration.properties.modelmapper.ModelMapperPropertiesConfiguration;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@ComponentScan(basePackageClasses = ModelMapperEmbeddableDataMappingContextConverterConfiguration.class)
public class ModelMapperEmbeddableConfiguration {

	@Bean
	@ConfigurationProperties(prefix = MEAL_BUILDER_APP_BOOT_CONFIGURATION_MODEL_MAPPER_EMBEDDABLE_PROPERTIES)
	public ModelMapperPropertiesConfiguration mealBuilderModelEmbeddableMapperConfigurationProperties() {
		return new ModelMapperPropertiesConfiguration();
	}

	/**
	 * Model mapper bean
	 * 
	 * @return ModelMapper
	 */
	@SuppressWarnings("squid:S107")
	@Bean(API_MODELMAPPER_EMBEDDABLE_MODEL_MODEL_MAPPER_BEAN_NAME)
	public ModelMapper mealBuilderEmbeddableModelMapper(
			@Qualifier("foodSizeDataDTOMappingContextConverter") @NotNull FoodSizeDataDTOMappingContextConverter foodSizeDataDTOMappingContextConverter,
			@Qualifier("priceDataDTOMappingContextConverter") @NotNull PriceDataDTOMappingContextConverter priceDataDTOMappingContextConverter,
			@Qualifier("foodSizeDataMappingContextConverter") @NotNull FoodSizeDataMappingContextConverter foodSizeDataMappingContextConverter,
			@Qualifier("priceDataMappingContextConverter") @NotNull PriceDataMappingContextConverter priceDataMappingContextConverter) {
		final ModelMapper mapper = new ModelMapper();

		// DTO common converters
		mapper.addConverter(foodSizeDataDTOMappingContextConverter, FoodSizeData.class, FoodSizeDataDTO.class);
		mapper.addConverter(priceDataDTOMappingContextConverter, PriceData.class, PriceDataDTO.class);

		// Model common converters
		mapper.addConverter(foodSizeDataMappingContextConverter, FoodSizeDataDTO.class, FoodSizeData.class);
		mapper.addConverter(priceDataMappingContextConverter, PriceDataDTO.class, PriceData.class);

		return mapper;
	}
}
