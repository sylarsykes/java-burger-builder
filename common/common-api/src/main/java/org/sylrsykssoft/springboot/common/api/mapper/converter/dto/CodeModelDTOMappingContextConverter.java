/**
 * CodeModelDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.CodeModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.CodeModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.CodeModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * CodeModelDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class CodeModelDTOMappingContextConverter implements Converter<CodeModel, CodeModelDTO> {
	
	@NonNull
	private CodeModelDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public CodeModelDTO convert(@NotNull MappingContext<CodeModel, CodeModelDTO> context) {
		return converter.convert(context.getSource());
	}
}
