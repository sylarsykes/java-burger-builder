/**
 * DescriptionModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;

/**
 * DescriptionModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class DescriptionModelDTOMapperConverter implements Converter<DescriptionModel, DescriptionModelDTO> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public DescriptionModelDTO convert(@NotNull @Valid final DescriptionModel source) {
		return DescriptionModelDTO.builder().description(source.getDescription()).build();
	}
}
