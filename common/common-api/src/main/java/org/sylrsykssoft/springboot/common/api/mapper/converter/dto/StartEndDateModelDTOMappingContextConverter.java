/**
 * StartEndDateModelDTOMappingContextConverter.java 29 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto;

import javax.validation.Valid;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.StartEndDateModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.StartEndDateModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.StartEndDateModel;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * StartEndDateModelDTOMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class StartEndDateModelDTOMappingContextConverter implements Converter<StartEndDateModel, StartEndDateModelDTO> {

	@NonNull
	StartEndDateModelDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public StartEndDateModelDTO convert(MappingContext<StartEndDateModel, StartEndDateModelDTO> context) {
		return converter.convert(context.getSource());
	}

}
