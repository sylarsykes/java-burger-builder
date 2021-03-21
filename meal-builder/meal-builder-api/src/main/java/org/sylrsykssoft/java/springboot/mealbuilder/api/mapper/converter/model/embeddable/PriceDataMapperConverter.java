/**
 * PriceDataMapperConverter.java 20 mar. 2021
 *
 */
package org.sylrsykssoft.java.springboot.mealbuilder.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.java.springboot.mealbuilder.api.dto.embeddable.PriceDataDTO;
import org.sylrsykssoft.java.springboot.mealbuilder.api.model.embeddable.PriceData;

/**
 * PriceDataMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class PriceDataMapperConverter implements Converter<PriceDataDTO, PriceData> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public PriceData convert(@NotNull @Valid final PriceDataDTO source) {
		return PriceData.builder().price(source.getPrice()).build();
	}
}
