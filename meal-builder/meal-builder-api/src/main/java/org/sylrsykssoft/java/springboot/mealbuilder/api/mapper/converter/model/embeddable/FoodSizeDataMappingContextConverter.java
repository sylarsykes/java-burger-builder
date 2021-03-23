/**
 * FoodSizeDataMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * FoodSizeDataMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class FoodSizeDataMappingContextConverter implements Converter<FoodSizeDataDTO, FoodSizeData> {

	@NonNull
	private FoodSizeDataMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public FoodSizeData convert(@NotNull final MappingContext<FoodSizeDataDTO, FoodSizeData> context) {
		return converter.convert(context.getSource());
	}

}
