/**
 * LocalizedModelDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.LocalizedModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * LocalizedModelDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class LocalizedModelDTOMappingContextConverter implements Converter<LocalizedModel, LocalizedModelDTO> {
	
	@NonNull
	private LocalizedModelDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedModelDTO convert(@NotNull MappingContext<LocalizedModel, LocalizedModelDTO> context) {
		return converter.convert(context.getSource());
	}
}
