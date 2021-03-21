/**
 * DescriptionModelMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.DescriptionModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.DescriptionModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.DescriptionModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * DescriptionModelMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class DescriptionModelMappingContextConverter implements Converter<DescriptionModelDTO, DescriptionModel> {
	
	@NonNull
	private DescriptionModelMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public DescriptionModel convert(@NotNull MappingContext<DescriptionModelDTO, DescriptionModel> context) {
		return converter.convert(context.getSource());
	}
}
