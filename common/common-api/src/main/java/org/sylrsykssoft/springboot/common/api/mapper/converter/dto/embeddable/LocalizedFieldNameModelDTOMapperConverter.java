/**
 * LocalizedFieldNameModelDTOMapperConverter.java 21 mar. 2021
 *
 */
package org.sylrsykssoft.springboot.common.api.mapper.converter.dto.embeddable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.Converters.Converter;
import org.sylrsykssoft.springboot.common.api.dto.embeddable.LocalizedFieldNameModelDTO;
import org.sylrsykssoft.springboot.common.api.model.embeddable.LocalizedFieldNameModel;

/**
 * LocalizedFieldNameModelDTOMapperConverter
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class LocalizedFieldNameModelDTOMapperConverter
		implements Converter<LocalizedFieldNameModel, LocalizedFieldNameModelDTO> {
	/**
	 * {@inheritDoc}
	 */
	@Valid
	@Override
	public LocalizedFieldNameModelDTO convert(@NotNull @Valid final LocalizedFieldNameModel source) {
		return LocalizedFieldNameModelDTO.builder().id(source.getId()).locale(source.getLocale())
				.fieldName(source.getFieldName()).build();
	}
}
