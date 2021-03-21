/**
 * AuditModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

/**
 * AuditModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class AuditModelDTOMapperConverter implements Converter<AuditModel, AuditModelDTO> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public AuditModelDTO convert(@NotNull @Valid final AuditModel source) {
		return AuditModelDTO.builder().createdBy(source.getCreatedBy()).createdDate(source.getCreatedDate())
				.lastModifiedBy(source.getLastModifiedBy()).lastModifiedDate(source.getLastModifiedDate()).build();
	}
}
