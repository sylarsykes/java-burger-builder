/**
 * LocalizedValueModelMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedValueModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.LocalizedValueModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedValueModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * LocalizedValueModelMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class LocalizedValueModelMappingContextConverter implements Converter<LocalizedValueModelDTO, LocalizedValueModel> {
	
	@NonNull
	private LocalizedValueModelMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedValueModel convert(@NotNull MappingContext<LocalizedValueModelDTO, LocalizedValueModel> context) {
		return converter.convert(context.getSource());
	}
}
