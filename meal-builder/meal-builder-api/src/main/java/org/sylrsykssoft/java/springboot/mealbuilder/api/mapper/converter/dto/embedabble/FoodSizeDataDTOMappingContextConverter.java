/**
 * FoodSizeDataDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * FoodSizeDataDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class FoodSizeDataDTOMappingContextConverter implements Converter<FoodSizeData, FoodSizeDataDTO> {

	@NonNull
	private FoodSizeDataDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public FoodSizeDataDTO convert(@NotNull final MappingContext<FoodSizeData, FoodSizeDataDTO> context) {
		return converter.convert(context.getSource());
	}

}
