/**
 * AuditModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.model.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.AuditModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.AuditModel;

/**
 * AuditModelMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class AuditModelMapperConverter implements Converter<AuditModelDTO, AuditModel> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public AuditModel convert(@NotNull @Valid final AuditModelDTO source) {
		return AuditModel.builder().createdBy(source.getCreatedBy()).createdDate(source.getCreatedDate())
				.lastModifiedBy(source.getLastModifiedBy()).lastModifiedDate(source.getLastModifiedDate()).build();
	}
}
