/**
 * DrinksCRUDModelMapperMappingContextConverterConfiguration.java 28 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper.drinks.service;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_EMBEDDABLE_MODEL_MODEL_MAPPER_BEAN_NAME;
import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_DRINKS_LOCALIZED_MODEL_MAPPER_BEAN_NAME;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.service.model.create.dto.drinks.CreateDrinkModelDTOMapperConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.service.model.create.dto.drinks.CreateDrinkModelDTOMappingContextConverter;

/**
 * DrinksCRUDModelMapperMappingContextConverterConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class DrinksCRUDModelMapperMappingContextConverterConfiguration {

	@Bean
	public CreateDrinkModelDTOMapperConverter createDrinkModelDTOMapperConverter(
			@Qualifier(API_MODELMAPPER_COMMON_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper commonModelMapper,
			@Qualifier(API_MODELMAPPER_EMBEDDABLE_MODEL_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper embeddableModelMapper,
			@Qualifier(API_MODELMAPPER_MODEL_DRINKS_LOCALIZED_MODEL_MAPPER_BEAN_NAME) @NotNull final ModelMapper localizedDataModelMapper) {
		return new CreateDrinkModelDTOMapperConverter(commonModelMapper, embeddableModelMapper,
				localizedDataModelMapper);
	}
	
	@Bean
	public CreateDrinkModelDTOMappingContextConverter createDrinkModelDTOMappingContextConverter(
			@Qualifier("createDrinkModelDTOMapperConverter") @NotNull final CreateDrinkModelDTOMapperConverter createDrinkModelDTOMapperConverter) {
		return new CreateDrinkModelDTOMappingContextConverter(createDrinkModelDTOMapperConverter);
	}
}
