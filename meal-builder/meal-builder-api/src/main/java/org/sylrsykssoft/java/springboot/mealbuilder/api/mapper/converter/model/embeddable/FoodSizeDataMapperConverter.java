/**
 * FoodSizeDataMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable;

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
public final class FoodSizeDataMapperConverter implements Converter<FoodSizeDataDTO, FoodSizeData> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public FoodSizeData convert(@NotNull @Valid final FoodSizeDataDTO source) {
		return FoodSizeData.builder().size(source.getSize()).build();

	}
}
