/**
 * CodeModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.CodeModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.CodeModel;

/**
 * CodeModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class CodeModelDTOMapperConverter implements Converter<CodeModel, CodeModelDTO> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public CodeModelDTO convert(@NotNull @Valid final CodeModel source) {
		return CodeModelDTO.builder().code(source.getCode()).build();
	}
}
