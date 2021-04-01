/**
 * StartEndDateModelMappingContextConverter.java 29 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model;

import javax.validation.Valid;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.StartEndDateModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.StartEndDateModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.StartEndDateModel;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * StartEndDateModelMappingContextConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class StartEndDateModelMappingContextConverter implements Converter<StartEndDateModelDTO, StartEndDateModel> {

	@NonNull
	StartEndDateModelMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Valid
	public StartEndDateModel convert(MappingContext<StartEndDateModelDTO, StartEndDateModel> context) {
		return converter.convert(context.getSource());
	}

}
