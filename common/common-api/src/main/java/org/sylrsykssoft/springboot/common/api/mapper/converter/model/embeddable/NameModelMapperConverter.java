/**
 * NameModelMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;

/**
 * NameModelMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class NameModelMapperConverter implements Converter<NameModelDTO, NameModel> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public NameModel convert(@NotNull @Valid final NameModelDTO source) {
		return NameModel.builder().name(source.getName()).build();
	}
}
