/**
 * AuditModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable.AuditModelDTOMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * AuditModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RequiredArgsConstructor
public final class AuditModelDTOMappingContextConverter implements Converter<AuditModel, AuditModelDTO> {
	
	@NonNull
	private AuditModelDTOMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public AuditModelDTO convert(@NotNull MappingContext<AuditModel, AuditModelDTO> context) {
		return converter.convert(context.getSource());
	}
}
