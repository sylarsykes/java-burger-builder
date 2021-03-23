/**
 * PriceDataDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * PriceDataDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class PriceDataDTOMappingContextConverter implements Converter<PriceData, PriceDataDTO> {

	@NonNull
	private PriceDataDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public PriceDataDTO convert(@NotNull final MappingContext<PriceData, PriceDataDTO> context) {
		return converter.convert(context.getSource());
	}

}
