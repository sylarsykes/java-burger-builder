/**
 * LocalizedValueModelDTOMappingContextConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedValueModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.LocalizedValueModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedValueModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * LocalizedValueModelDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class LocalizedValueModelDTOMappingContextConverter implements Converter<LocalizedValueModel, LocalizedValueModelDTO> {
	
	@NonNull
	private LocalizedValueModelDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedValueModelDTO convert(@NotNull MappingContext<LocalizedValueModel, LocalizedValueModelDTO> context) {
		return converter.convert(context.getSource());
	}
}
