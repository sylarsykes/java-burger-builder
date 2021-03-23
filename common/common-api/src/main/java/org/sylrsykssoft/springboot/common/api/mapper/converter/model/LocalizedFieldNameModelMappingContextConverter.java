/**
 * LocalizedFieldNameModelMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.LocalizedFieldNameModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * LocalizedFieldNameModelMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class LocalizedFieldNameModelMappingContextConverter
		implements Converter<LocalizedFieldNameModelDTO, LocalizedFieldNameModel> {

	@NonNull
	private LocalizedFieldNameModelMapperConverter converter;

	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedFieldNameModel convert(
			@NotNull MappingContext<LocalizedFieldNameModelDTO, LocalizedFieldNameModel> context) {
		return converter.convert(context.getSource());
	}
}
