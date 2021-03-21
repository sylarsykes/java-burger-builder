/**
 * DescriptionModelMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;

/**
 * DescriptionModelMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class DescriptionModelMapperConverter implements Converter<DescriptionModelDTO, DescriptionModel> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public DescriptionModel convert(@NotNull @Valid final DescriptionModelDTO source) {
		return DescriptionModel.builder().description(source.getDescription()).build();
	}
}
