/**
 * LocalizedFieldNameModelDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.LocalizedFieldNameModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * LocalizedFieldNameModelDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class LocalizedFieldNameModelDTOMappingContextConverter
		implements Converter<LocalizedFieldNameModel, LocalizedFieldNameModelDTO> {

	@NonNull
	private LocalizedFieldNameModelDTOMapperConverter converter;

	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedFieldNameModelDTO convert(
			@NotNull MappingContext<LocalizedFieldNameModel, LocalizedFieldNameModelDTO> context) {
		return converter.convert(context.getSource());
	}
}
