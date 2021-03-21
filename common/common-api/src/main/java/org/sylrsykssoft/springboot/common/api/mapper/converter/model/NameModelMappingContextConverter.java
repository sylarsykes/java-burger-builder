/**
 * NameModelMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.NameModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.NameModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.NameModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * NameModelMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class NameModelMappingContextConverter implements Converter<NameModelDTO, NameModel> {
	
	@NonNull
	private NameModelMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public NameModel convert(@NotNull MappingContext<NameModelDTO, NameModel> context) {
		return converter.convert(context.getSource());
	}
}
