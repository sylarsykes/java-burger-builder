/**
 * ModelMapperEmbeddableDataMappingContextConverterConfiguration.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper.embeddable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.FoodSizeDataDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.FoodSizeDataDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.PriceDataDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble.PriceDataDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.FoodSizeDataMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.FoodSizeDataMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.PriceDataMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable.PriceDataMappingContextConverter;

/**
 * ModelMapperEmbeddableDataMappingContextConverterConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class ModelMapperEmbeddableDataMappingContextConverterConfiguration {

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
	
}
