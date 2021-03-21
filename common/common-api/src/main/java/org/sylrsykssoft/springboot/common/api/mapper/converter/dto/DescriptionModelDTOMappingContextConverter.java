/**
 * DescriptionModelDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.DescriptionModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * DescriptionModelDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class DescriptionModelDTOMappingContextConverter implements Converter<DescriptionModel, DescriptionModelDTO> {
	
	@NonNull
	private DescriptionModelDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public DescriptionModelDTO convert(@NotNull MappingContext<DescriptionModel, DescriptionModelDTO> context) {
		return converter.convert(context.getSource());
	}
}
