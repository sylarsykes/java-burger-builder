/**
 * PriceDataMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * PriceDataMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class PriceDataMappingContextConverter implements Converter<PriceDataDTO, PriceData> {

	@NonNull
	private PriceDataMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public PriceData convert(@NotNull final MappingContext<PriceDataDTO, PriceData> context) {
		return converter.convert(context.getSource());
	}

}
