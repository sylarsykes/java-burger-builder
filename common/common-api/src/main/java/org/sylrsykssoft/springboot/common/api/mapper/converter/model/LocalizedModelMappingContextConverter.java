/**
 * LocalizedModelMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.LocalizedModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * LocalizedModelMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class LocalizedModelMappingContextConverter implements Converter<LocalizedModelDTO, LocalizedModel> {
	
	@NonNull
	private LocalizedModelMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedModel convert(@NotNull MappingContext<LocalizedModelDTO, LocalizedModel> context) {
		return converter.convert(context.getSource());
	}
}
