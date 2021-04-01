/**
 * AuditModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable.AuditModelMapperConverter;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * AuditModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public final class AuditModelMappingContextConverter implements Converter<AuditModelDTO, AuditModel> {
	
	@NonNull
	AuditModelMapperConverter converter;
	
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public AuditModel convert(@NotNull final MappingContext<AuditModelDTO, AuditModel> context) {
		return converter.convert(context.getSource());
	}
}
