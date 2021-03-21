/**
 * CodeModelMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.CodeModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.CodeModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.CodeModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * CodeModelMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class CodeModelMappingContextConverter implements Converter<CodeModelDTO, CodeModel> {
	
	@NonNull
	private CodeModelMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public CodeModel convert(@NotNull MappingContext<CodeModelDTO, CodeModel> context) {
		return converter.convert(context.getSource());
	}
}
