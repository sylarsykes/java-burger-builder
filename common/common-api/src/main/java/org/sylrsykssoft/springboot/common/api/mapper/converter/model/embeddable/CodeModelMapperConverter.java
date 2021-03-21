/**
 * CodeModelMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.CodeModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.CodeModel;

/**
 * CodeModelMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class CodeModelMapperConverter implements Converter<CodeModelDTO, CodeModel> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public CodeModel convert(@NotNull @Valid final CodeModelDTO source) {
		return CodeModel.builder().code(source.getCode()).build();
	}
}
