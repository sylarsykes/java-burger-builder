/**
 * DrinksCRUDModelMapperConfiguration.java 28 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.boot.configuration.modelmapper.drinks.service;

import static org.sylrsykssoft.java.springboot.mealbuilder.api.configuration.ApiConstants.API_MODELMAPPER_MODEL_DRINKS_CRUD_MODEL_MAPPER_BEAN_NAME;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.drinks.DrinkDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.service.model.create.dto.drinks.CreateDrinkModelDTOMappingContextConverter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.service.model.drinks.drink.create.dto.CreateDrinkModelDTO;

/**
 * DrinksCRUDModelMapperConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@ComponentScan(basePackageClasses = DrinksCRUDModelMapperMappingContextConverterConfiguration.class)
public class DrinksCRUDModelMapperConfiguration {

	/**
	 * Model mapper bean
	 * 
	 * @return ModelMapper
	 */
	@SuppressWarnings("squid:S107")
	@Bean(API_MODELMAPPER_MODEL_DRINKS_CRUD_MODEL_MAPPER_BEAN_NAME)
	public ModelMapper mealBuilderDrinksCRUDModelMapper(
			@Qualifier("createDrinkModelDTOMappingContextConverter") @NotNull CreateDrinkModelDTOMappingContextConverter createDrinkModelDTOMappingContextConverter) {
		final ModelMapper mapper = new ModelMapper();

		// DTO converters
		mapper.addConverter(createDrinkModelDTOMappingContextConverter, CreateDrinkModelDTO.class, DrinkDTO.class);

		return mapper;
	}

}
