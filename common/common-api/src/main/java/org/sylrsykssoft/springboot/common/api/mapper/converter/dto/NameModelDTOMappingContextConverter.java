/**
 * NameModelDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.NameModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * NameModelDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class NameModelDTOMappingContextConverter implements Converter<NameModel, NameModelDTO> {
	
	@NonNull
	private NameModelDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public NameModelDTO convert(@NotNull MappingContext<NameModel, NameModelDTO> context) {
		return converter.convert(context.getSource());
	}
}
