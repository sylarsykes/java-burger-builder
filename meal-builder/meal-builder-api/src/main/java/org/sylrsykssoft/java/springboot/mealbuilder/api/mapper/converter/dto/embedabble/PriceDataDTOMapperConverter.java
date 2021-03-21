/**
 * PriceDataMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.dto.embedabble;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;

/**
 * PriceDataDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class PriceDataDTOMapperConverter implements Converter<PriceData, PriceDataDTO> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public PriceDataDTO convert(@NotNull @Valid final PriceData source) {
		return PriceDataDTO.builder().price(source.getPrice()).build();
	}
}
