/**
 * FoodSizeDataMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.FoodSizeDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.FoodSizeData;

/**
 * FoodSizeDataDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class FoodSizeDataDTOMapperConverter implements Converter<FoodSizeData, FoodSizeDataDTO> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public FoodSizeDataDTO convert(@NotNull @Valid final FoodSizeData source) {
		return FoodSizeDataDTO.builder().size(source.getSize()).build();

	}
}
